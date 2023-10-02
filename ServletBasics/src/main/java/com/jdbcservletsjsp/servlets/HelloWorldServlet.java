package com.jdbcservletsjsp.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldServlet extends GenericServlet {

    private static final long serialVersionUID = 641078493826L;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	response.setContentType("text/plain");
	response.getWriter().println("hello");
    }

}
