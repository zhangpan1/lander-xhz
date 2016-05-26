package com.zhangpan.servlet.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 响应 分为4部分
 * 响应首行
 * 响应头
 * 响应空行
 * 响应正文
 * @author zhangp
 *response要干的事情，给这三个部分添加内容
 *肯定有一个方法是添加状态码，和描述状态码的
 *
 */
public class demo1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.sendError(404, "找到也不告诉你");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
