package com.zhangpan.servlet.response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo7 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//0 告诉浏览器是什么东西
		//getServletContext().getMimeType(".jar") Context对象根据 后缀名去web.xml查找mime类型.
	resp.setContentType(getServletContext().getMimeType(".jar"));
//告诉浏览器推荐用户使用什么名称下载
	resp.setHeader("Content-Disposition", "attachment;filename=everdata-lte-209-0.0.1.jar");
//1 获得图片的输入流
InputStream  in = 	getServletContext().getResourceAsStream("/WEB-INF/everdata-lte-209-0.0.1.jar");
	//2 通过response获得输出字节流
OutputStream out = resp.getOutputStream();
	//3 两个对接
byte[] buffer = new byte[1024];
int len = 0;
while((len=in.read(buffer))>0){
	out.write(buffer, 0, len);
	out.flush();
}
in.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
