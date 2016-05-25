package com.zhang.servlet.count;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Count1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.取得之前记录的数字
		     //从application域取
			 //取到了==> 不是第一次访问
			 //没有取到==>当前是第一次访问
		Integer count = (Integer) getServletContext().getAttribute("count");
		if(count != null){
			resp.getWriter().print("you are the "+(count++)+" visiter!");
		} else {
			count = 1;
			resp.getWriter().print("you are the first visiter");
		}
		getServletContext().setAttribute("count", count);
		//2.将访问次数输出给浏览器
		//3.将新的访问次数放回appplication
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
