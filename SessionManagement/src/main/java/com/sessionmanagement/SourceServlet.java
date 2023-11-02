package com.sessionmanagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");

		// session cookie - automatically added to response by the container
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30);
		session.setAttribute("user", userName);

		// custom cookie
		response.addCookie(new Cookie("name", userName));

		response.getWriter().print("<a href=\"targetServlet\">Click</a>");
	}
}
