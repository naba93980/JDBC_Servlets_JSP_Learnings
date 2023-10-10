package com.jdbcservletjsp.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readServlet")
public class ReadUserServlet extends HttpServlet {

	private static final long serialVersionUID = 165767567568756L;
	private Connection connection;

	public void init() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12651395",
					"sql12651395", "XxyXyvgUZq");
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Statement statement = connection.createStatement();
			String command = String.format("SELECT * FROM user");
			ResultSet result = statement.executeQuery(command);

			while (result.next()) {
				String firstName = result.getString(1);
				String secondName = result.getString(2);
				String email = result.getString(3);
				String password = result.getString(4);
				response.getWriter().println(firstName + " " + secondName + " " + " " + email + " " + password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
