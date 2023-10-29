package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/Trial")
public class FilterTrail extends HttpFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		response.getWriter().print("from filter before servlet");
		chain.doFilter(request, response);
		response.getWriter().print("from filter after servlet");
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}

// filter sits infront of servlet, request reaches it first then from filter to servlet then again back to filter then to client as response