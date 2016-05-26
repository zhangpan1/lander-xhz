package com.zhangpan.servlet.response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class demo6 extends HttpServlet{
	/**
	 * 使用字节流发送图片
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//0告诉浏览器，发过去流的MIME类型 ---描述信息的（通过MIME类型）
		resp.setContentType("image/png");
		//1获得图片的输入流
	InputStream is = getServletContext().getResourceAsStream("/WEB-INF/001.png");
		//2通过response获得输出子节流
	OutputStream out = resp.getOutputStream();	
	    //3两个对接
	byte[] buffer = new byte[1024];
	int len = 0;
	while ((len = is.read(buffer))>0) {
		out.write(buffer,0,len);
		out.flush();
	}
	    is.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
