package com.jdbcservletsjsp.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/")
public class Home extends GenericServlet {

    private static final long serialVersionUID = 5106198083959735070L;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	response.getWriter().write("<h1>home</h1>");
    }

}
