package com.eversec.filter.some;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class DirtyWordsFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request;
		HttpServletResponse response;

		try {
			request = (HttpServletRequest) req;
			response = (HttpServletResponse) res;
		} catch (ClassCastException e) {
			throw new ServletException("non-HTTP request or response");
		}
		
		MyHttpServletRequest1 mrequest1 = new MyHttpServletRequest1(request);
		chain.doFilter(mrequest1, response);

	}

	public void destroy() {

	}

}
class MyHttpServletRequest1 extends HttpServletRequestWrapper{
	private String strs[] = {"畜生","搞基","禽兽"};
	public MyHttpServletRequest1(HttpServletRequest request) {
		super(request);
	}

	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(value==null)
			return value;
		//过滤脏话
		for(String s:strs){
			value = value.replace(s, "**");
		}
		
		return value;
	}
	
}
