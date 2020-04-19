package com.sl.web.listener; /**
 * Created by Achi on 4/18/2020.
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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
