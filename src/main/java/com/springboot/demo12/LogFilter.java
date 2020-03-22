package com.springboot.demo12;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class LogFilter implements  Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("==LogFilter =init===");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("==LogFilter =filter ==="+ request.getRemoteHost());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("=====destroy======");
    }
}
