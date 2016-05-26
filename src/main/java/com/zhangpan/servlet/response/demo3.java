package com.zhangpan.servlet.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//1.设置响应头 为Refresh:5;url=/Day08-response/AServlet
		resp.setHeader("Refresh", "5;url=/Day08-response/AServlet");
		//2.使用字符流发送提示,5秒后跳转
		resp.getWriter().print("您将在<span id='one' ></span>秒后跳转到AServlet!" +
				"<script type='text/javascript'>" +
				"var count = 5;" +
				"function fun1(){" +
				"var span = document.getElementById('one');" +
				"span.innerHTML = count--;" +
				"" +
				"if(count>0){" +
				"window.setTimeout(fun1,1000);" +
					"}" +
				"}" +
				"fun1();" +
				"</script>");
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
