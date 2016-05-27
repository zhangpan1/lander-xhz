package com.zhangpan.login.xhz;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSevlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("GBK");
		resp.setContentType("text/html;charset=utf-8");
		//1.获得用户名
		String name = req.getParameter("name");
		String remeber = req.getParameter("remeber");
	
		//2.获得是否需要记住用户名
		URLEncoder.encode(name, "utf-8");
		Cookie cookie = new Cookie("remeber",name);
		if(remeber != null && remeber.equals("yes")){
			cookie.setMaxAge(60*60*24*7);
		} else {
			cookie.setMaxAge(0);
		}
		resp.addCookie(cookie);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		//3.判断是否沟通记住用户名
		//4. 勾选了===>新建cookie 设置有效时间为一周
		//   没勾选===>新建cookie 删除 设置有限时间为0
		//5.去成功页面
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
