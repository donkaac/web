package com.sl.web.controller;

import com.sl.web.model.User;
import com.sl.web.util.HibernateUtil;
import org.hibernate.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Login",urlPatterns = "/login")
public class Login extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Session session= HibernateUtil.getSessionFactory().openSession();
        List list= session.createQuery("from User where email=:uname and password=:pass").setParameter("uname",email).setParameter("pass", password).list();
        if (list !=null){
            User user=(User) list.get(0);
            request.getSession().setAttribute("user",user);
            response.sendRedirect("admin/index.jsp");
        }else{
            response.sendRedirect("admin.login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}
