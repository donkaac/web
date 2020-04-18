package com.sl.web.listeners; /**
 * Created by Achi on 4/18/2020.
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AppContextListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("ROOT_ADMIN",servletContext.getContextPath()+"/admin/");
        servletContext.setAttribute("ROOT_USER",servletContext.getContextPath()+"/");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
