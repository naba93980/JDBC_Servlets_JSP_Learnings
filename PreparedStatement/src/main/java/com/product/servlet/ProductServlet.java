package com.product.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = -5640890895972783229L;

	private Connection connection;
	private PreparedStatement preparedStatement;

	@Override
	public void init(ServletConfig config) throws ServletException {

		ServletContext context = config.getServletContext();
		String driver = context.getInitParameter("driver");
		String dbUrl = context.getInitParameter("dbUrl");

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(dbUrl, "root", "12345678");
			preparedStatement = connection.prepareStatement("INSERT INTO product VALUES (?,?,?,?)");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int result;

		try {
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, req.getParameter("description"));
			preparedStatement.setString(4, req.getParameter("price"));
			result = preparedStatement.executeUpdate();

			resp.setContentType("text/plain");
			resp.getWriter().write("result = " + result);
		} catch (SQLException e) {
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
