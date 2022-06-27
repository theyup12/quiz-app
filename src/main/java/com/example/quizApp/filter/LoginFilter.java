package com.example.quizApp.filter;

import com.example.quizApp.domain.LoginDomain;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns="/online-quiz/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException{

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpSession oldSession = ((HttpServletRequest)request).getSession(false);
        if(oldSession == null || oldSession.getAttribute("user") == null){
            request.setAttribute("error", "* Please Sign In");
            request.setAttribute("userLogin", new LoginDomain());
            request.getRequestDispatcher(((HttpServletRequest) request).getContextPath()+"/login.jsp").forward(request,response);

        }else {
            chain.doFilter(request,response);
        }
    }
    @Override
    public void destroy(){

    }
}
