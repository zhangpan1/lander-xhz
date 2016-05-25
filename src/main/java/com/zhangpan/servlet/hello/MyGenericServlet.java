package com.zhangpan.servlet.hello;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class MyGenericServlet implements Servlet,ServletConfig {

	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		this.init();
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return config;
	}

	@Override
	public abstract void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException ;

	@Override
	public String getServletInfo() {
		
		return "";
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getServletName() {
		// TODO Auto-generated method stub
		return getServletConfig().getServletName();
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return getServletConfig().getServletContext();
	}

	@Override
	public String getInitParameter(String name) {
		// TODO Auto-generated method stub
		return getServletConfig().getInitParameter(name);
	}

	@Override
	public Enumeration getInitParameterNames() {
		// TODO Auto-generated method stub
		return getServletConfig().getInitParameterNames();
	}
	
}
