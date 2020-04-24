package com.sl.web.controller;

import com.sl.web.constant.MessageType;
import com.sl.web.model.RestAuthentication;
import com.sl.web.model.User;
import com.sl.web.util.HibernateUtil;
import com.sl.web.util.MessageUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String token = "";
        Date date = new Date();
        String toDay = new SimpleDateFormat("dd-M-yyyy").format(date);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Object result = session.createQuery("FROM User WHERE email=:uname AND password=:pass").setParameter("uname", email).setParameter("pass", password).uniqueResult();
        if (result != null) {
            User user = (User) result;
            request.getSession().setAttribute("user", user);

            List<RestAuthentication> authentications = session.createQuery("FROM RestAuthentication WHERE userByUserId=:user ORDER BY date desc", RestAuthentication.class).setParameter("user", user).list();
            if (authentications == null) {
                token = issueToken(user, session, request);
            } else {
                RestAuthentication authentication = authentications.get(0);
                if (authentication.getRemoteAddress().equals(request.getRemoteAddr())) {

                    Date last_time = authentication.getDate();
                    String last_date = new SimpleDateFormat("dd-M-yyyy").format(last_time);

                    if (last_date.equals(toDay)) {
                        token = authentication.getToken();
                    } else {
                        token = issueToken(user, session, request);
                    }
                }
            }

            request.getSession().setAttribute("rest-token", token);
            response.sendRedirect("admin/index.jsp");
        } else {
            MessageUtil messageUtil = new MessageUtil(MessageType.WARNING, "Invalid Username or Password");
            request.getSession().setAttribute("message", messageUtil);
            response.sendRedirect("admin/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("admin/login.jsp");
    }

    private String issueToken(User user, Session hs, HttpServletRequest request) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token

        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();

        RestAuthentication restAuthentication = new RestAuthentication();
        restAuthentication.setRemoteAddress(request.getRemoteAddr());
        restAuthentication.setDate(new Timestamp(new Date().getTime()));
        restAuthentication.setToken(token);
        restAuthentication.setUserByUserId(user);

        Transaction transaction = hs.beginTransaction();
        hs.save(restAuthentication);
        transaction.commit();

        return token;
    }
}
