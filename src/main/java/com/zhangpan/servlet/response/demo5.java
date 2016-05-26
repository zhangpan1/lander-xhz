package com.zhangpan.servlet.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo5 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//乱码问题，浏览器，和服务器
		resp.setCharacterEncoding("utf-8");
		//1 获得字符流
	    PrintWriter pw = resp.getWriter();
	    //ISO-8859-1
		//2发送汉字
		pw.print("你好，世界");
		//控制浏览器端使用的解码集
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		//控制服务器端的编码
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
