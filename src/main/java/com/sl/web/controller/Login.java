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
import java.util.List;
import java.util.Random;

@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Object result = session.createQuery("from User where email=:uname and password=:pass").setParameter("uname", email).setParameter("pass", password).uniqueResult();
        if (result != null) {
            User user = (User) result;
            request.getSession().setAttribute("user", user);

            Random random = new SecureRandom();
            String token = new BigInteger(130, random).toString(32);

            RestAuthentication restAuthentication = new RestAuthentication();
            restAuthentication.setRemoteAddress(request.getRemoteAddr());
            restAuthentication.setToken(token);
            restAuthentication.setUserByUserId(user);

            Transaction transaction = session.beginTransaction();
            session.save(restAuthentication);
            transaction.commit();

            request.getSession().setAttribute("rest-token",token);

            response.sendRedirect("admin/index.jsp");
        } else {
            MessageUtil messageUtil = new MessageUtil(MessageType.WARNING,"Invalid Username or Password");
            request.getSession().setAttribute("message",messageUtil);
            response.sendRedirect("admin/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("admin/login.jsp");
    }
}
