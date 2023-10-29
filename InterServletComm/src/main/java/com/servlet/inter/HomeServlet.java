package com.servlet.inter;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 174574576785876L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResultSet result = (ResultSet) request.getAttribute("user");

		try {
			String firstName = result.getString(1);
			response.getWriter().println(request.getAttribute("message") + firstName);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
