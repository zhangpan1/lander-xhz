package com.zhangpan.servlet.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookie3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1 获得当前访问的品牌
		String current = req.getParameter("name");
		//2 获得之前访问过的品牌(获得cookie)
		Cookie history = null;
	    Cookie[] cookies = req.getCookies();
	    if (cookies != null && cookies.length > 0) {
	    	for (Cookie c : cookies) {
	    		if (c.getName().equals("history")) {
	    			history = c;
	    		}
	    	}
	    }
		//3将当前访问加上之前访问的，创建一个新的cookie
	    String value = "";
	    if (history != null) {
	    	if (history.getValue().contains(current)) {//当前符文的是否之前已经访问过
	    		value = history.getValue();
	    	}else {
	    		value = history.getValue() + ","+current;
	    	}
	    	System.out.println(value);
	    }
	    Cookie newHistory = new Cookie("history",value);
	    
		//4将cookie添加到响应中
	    resp.addCookie(newHistory);
		//5将视频记录放置到request域中
	    req.setAttribute("history",value);
		//6转发到jsp显示
	    req.getRequestDispatcher("/history/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

}
