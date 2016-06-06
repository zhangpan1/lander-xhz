package com.eversec.filter.examine;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//控制动态资源不要缓存
public class NoCacheFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request;
		HttpServletResponse response;
		try{
			request = (HttpServletRequest)req;
			response = (HttpServletResponse)resp;
		}catch(Exception e){
			throw new RuntimeException("non-http request or response");
		}
		
		response.setHeader("Expires", "-1");//控制缓存时间。只要比当前时间小即可
		response.setHeader("Cache-Control", "no-cache");//HTTP1.1
		response.setHeader("Pragma", "no-cache");//HTTP1.0
		
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

}
