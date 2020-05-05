package com.tm.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//½â¾öÂÒÂë
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

}
