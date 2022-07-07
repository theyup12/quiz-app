package com.example.quizApp.filter;

import com.example.quizApp.domain.LoginDomain;
import com.example.quizApp.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns="/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpSession oldSession = ((HttpServletRequest)request).getSession(false);
        if(oldSession == null || oldSession.getAttribute("user") == null || ((User)oldSession.getAttribute("user")).getIsAdmin().equals((byte) 0)){
            request.getRequestDispatcher(((HttpServletRequest) request).getContextPath()+"/login.jsp").forward(request,response);
            request.setAttribute("error", "* Please Sign In with Admin Account");
            request.setAttribute("userLogin", new LoginDomain());
        }else {
            chain.doFilter(request,response);
        }
    }
    @Override
    public void destroy(){

    }
}
