package com.zhangpan.servlet.response;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 响应正文
 * @author zhangp
 *
 */
public class demo4 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1获取输出字节流
		OutputStream os = resp.getOutputStream();
		//2输出中文
		os.write("你好世界".getBytes("utf-8"));
		//3.告诉浏览器用什么方式解码
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
