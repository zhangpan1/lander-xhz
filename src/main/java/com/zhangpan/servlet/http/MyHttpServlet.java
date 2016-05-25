package com.zhangpan.servlet.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhangpan.servlet.hello.MyGenericServlet;

public class MyHttpServlet extends MyGenericServlet{
	
	public static final String Method_GET = "GET";
	public static final String Method_POST = "POST";
	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		//优化1: 我们开发项目都是基于HTTP协议的, 而且服务器在service方法中传给我的ServletRequest对象,实际上就是HttpServletRequest对象
		//所以我们把 request和 response强转成HTTP的.
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		
		try {
			request = (HttpServletRequest) req;
			response = (HttpServletResponse) resp;
		} catch (Exception e) {
		
		}
		service(request,response);
	}
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//优化2: 我想根据请求方式的不同,做不同的事情
		//1获得客户端的请求方式
		String method =	req.getMethod();//GET/POST
		//2 根据请求方式不同,调用不同的方法
		if(method.equals(Method_GET)){
			doGet(req,resp);
		}else if(method.equals(Method_POST)){
			doPost(req,resp);
		}
		
		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
	}
}
