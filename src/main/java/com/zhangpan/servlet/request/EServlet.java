package com.zhangpan.servlet.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1获得表单提交的用户面密码
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		//2判断是否正确tom 1234才算成功
		if (name != null && name.trim().length()>0 
				&& name.equals("tom")&&password!=null
				&& password.trim().length()>0 
				&& password.equals("1234")){
			//成功==>转发到成功页面
			req.getRequestDispatcher("/login/success.jsp").forward(req, resp);
			
			//自己来做,很多弊端,不要这样
		/*	AServlet a = new AServlet();
			a.service(request, response);*/
		}else {
			//失败==>转发到失败页面
			req.getRequestDispatcher("/login/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

}
