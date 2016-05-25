package com.zhangpan.servlet.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//使用静态变量完成通信
		/*//向静态变量中赋值
			//Constant.str = "i love you so so much!";
		//向女神送包
			//Constant.obj = "七匹狼包";
			Constant.map.put("bag", "lv");
			Constant.map.put("car", "QQ");
			Constant.map.put("phone", "ventu");*/
		//使用servletContext完成通信
			//1获得servletContext对象
				ServletContext sc = getServletContext();
			//2 操作map
				sc.setAttribute("bag", "Calvin Klein");
				sc.setAttribute("car", "BMW");
				sc.setAttribute("passport", "HAWAII");
				
				
				
				
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
