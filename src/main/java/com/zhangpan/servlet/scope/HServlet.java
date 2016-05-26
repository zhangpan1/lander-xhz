package com.zhangpan.servlet.scope;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1 获得表单提交的用户名密码 
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				
				//
				Map<String,String> error = new HashMap<String, String>();
				
				//2 验证
				if(!(name!=null && name.trim().length()>0 && name.equals("tom"))){
					error.put("name", "用户名有误!");
				}
				if(!(password!=null && password.trim().length()>0 && password.equals("1234"))){
					error.put("password", "密码错误!");
				}
				
				
				//将错误信息通过request域带到错误页面
				request.setAttribute("error",error );
				if(error.size() > 0){
					//失败==> 回到登录页面,并显示错误信息
					request.getRequestDispatcher("/login2/login.jsp").forward(request, response);
				}else{
					//成功==> 成功页面
					request.getRequestDispatcher("/login2/success.jsp").forward(request, response);
				}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
