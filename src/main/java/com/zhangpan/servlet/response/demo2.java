package com.zhangpan.servlet.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//重定向
		//1.返回状态码为302
		resp.setStatus(302);
		//2.告诉浏览器去哪找新的地址，发送一个响应头：Location:httt:www.baidu.com
		resp.setHeader("Location", "/lander-xhz/demo1");
		resp.sendRedirect("/lander-xhz/demo1");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
