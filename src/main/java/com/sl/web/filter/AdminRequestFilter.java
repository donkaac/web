package com.sl.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminRequestFilter", urlPatterns = "/admin/*")
public class AdminRequestFilter implements Filter {
    public static String[] ALLOWED_PATH = {"/login","/bower_components","/build", "/dist", "/plugins", "/includes"};

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        String requestURI = request.getRequestURI();

        String path = requestURI.substring(request.getContextPath().length());

        boolean allowedPath = false;

        for (String s : ALLOWED_PATH) {
            if (path.contains(s)) {
                allowedPath = true;
                break;
            }
        }

        boolean loggedIn = (session != null && session.getAttribute("user") != null);


        if (loggedIn || allowedPath) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
