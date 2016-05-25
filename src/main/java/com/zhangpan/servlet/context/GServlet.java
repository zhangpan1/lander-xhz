package com.zhangpan.servlet.context;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//获得全局 init param配置
			//1 获得servletContext
				ServletContext sc = getServletContext();
			//2 调用getxxx方法
				Enumeration<String> en =  sc.getInitParameterNames();
				
				while(en.hasMoreElements()){
					String key = en.nextElement();
					String value  = sc.getInitParameter(key);
					
					response.getWriter().print(key+"===>"+value+"<br/>");
				}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
