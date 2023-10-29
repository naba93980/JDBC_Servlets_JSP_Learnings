package com.servlet.inter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 165767567568756L;
	private Connection connection;
	private PreparedStatement preparedStatement;

	@Override
	public void init(ServletConfig config) throws ServletException {

		ServletContext context = config.getServletContext();
		String driver = context.getInitParameter("driver");
		String dbUrl = context.getInitParameter("dbUrl");

		System.out.println("Login servlet initialised");

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(dbUrl, "root", "12345678");
			preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email=? AND password=?");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				request.setAttribute("message", "Welcome user ");
				request.setAttribute("user", result);
				request.getRequestDispatcher("/homeServlet").forward(request, response);
			} else {
				request.getRequestDispatcher("/login.html").forward(request, response);
			}
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {

		try {
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
