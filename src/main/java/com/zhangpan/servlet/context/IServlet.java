package com.zhangpan.servlet.context;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//以下是静态变量中取值
		/*//取值
		//String str = 	Constant.str;
		//Object bao = Constant.obj;
		String bag = (String) Constant.map.get("bag");		
		
		Constant.map.remove("car");*/
		//通过servletContext取值
			//1获得servletContext对象
		ServletContext sc = getServletContext();
			//2 操作map
			String bag = (String) sc.getAttribute("bag");
			
		//输出到客户端
		response.getWriter().print(bag);
		//不喜欢,扔掉(删除)
		sc.removeAttribute("bag");
		//遍历
		Enumeration<String> en = sc.getAttributeNames();
		System.out.println(sc);
		while(en.hasMoreElements()){
			String key = en.nextElement();
			 Object value =  sc.getAttribute(key);
			
			 System.out.println(key +"==>"+value);
			 
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
