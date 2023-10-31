package com.servlet.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.mvc.model.AverageCalculator;


@WebServlet("/averageController")
public class AverageController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("number1"));
		int num2 = Integer.parseInt(request.getParameter("number2"));
		
		AverageCalculator avg = new AverageCalculator();
		int average = avg.average(num1, num2);
		
		request.setAttribute("result", average);
		request.getRequestDispatcher("/views/result.jsp").forward(request, response);
	}

}
