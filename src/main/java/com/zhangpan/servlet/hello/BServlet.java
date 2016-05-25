package com.zhangpan.servlet.hello;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BServlet implements Servlet{
	private ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//1.获得servlet的name
		String servletName = getServletConfig().getServletName();
		//将字符串输出到客户端（浏览器）
		res.getWriter().print(servletName+"<br/>");
		/*
		 *  String getInitParameter(String name) 
	   Enumeration getInitParameterNames()  
        */
		Enumeration<String> en =getServletConfig().getInitParameterNames();
		while(en.hasMoreElements()){
			String key = en.nextElement();
			String value = getServletConfig().getInitParameter(key);
			res.getWriter().print(key+"==>"+value+"<br/>");
		}
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
