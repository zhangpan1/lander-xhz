package com.zhangpan.servlet.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DServlet  extends MyHttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("您现在是使用GET方式访问!");
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("您现在是使用POST方式访问!");
	}
}
