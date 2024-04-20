package org.example.project_1.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter(urlPatterns = "/user/*")
public class MyFilter implements Filter {

    @Override
    public  void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("user");
        if(obj == null){
            res.sendRedirect("http://localhost:8080/login/Login.jsp");
        } else {
            res.sendRedirect("http://localhost:8080/index.jsp");
        }
    }


}
