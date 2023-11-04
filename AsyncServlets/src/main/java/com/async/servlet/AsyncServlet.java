package com.async.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/asyncServlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AsyncContext context = request.startAsync();
		context.start(() -> {
			try {
				Thread.sleep(5000);
				response.getWriter().println(Thread.currentThread().getName());
				context.complete();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		System.out.println("initil thread - " + Thread.currentThread().getName()); // initial thread goes back to the
																					// pool
	}
}
