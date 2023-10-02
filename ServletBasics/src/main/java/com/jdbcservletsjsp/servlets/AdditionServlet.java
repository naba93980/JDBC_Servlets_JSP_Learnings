package com.jdbcservletsjsp.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

    private static final long serialVersionUID = 2600119695901747319L;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	String number1 = request.getParameter("number1");
	String number2 = request.getParameter("number2");
	int result = Integer.parseInt(number1) + Integer.parseInt(number2);
	response.setContentType("text/plain");
	response.getWriter().println(Integer.toString(result));
    }
}
