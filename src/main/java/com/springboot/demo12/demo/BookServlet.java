package com.springboot.demo12.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/user.do")
public class BookServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public BookServlet() {
        System.out.println("===servet BookServlet========");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("book servlet");
    }
}
