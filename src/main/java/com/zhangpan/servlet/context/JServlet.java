package com.zhangpan.servlet.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得 students.xml/
			//使用绝对路径,如果tomcat的路径变化了,那么项目代码就要修改.所以不好,要使用相对路径
		//File studentsXml = new File("E:\apache-tomcat-6.0.35\webapps\Day07-servlet\WEB-INF\students.xml");
			//File对象填写相对路径,相对的是tomcat目录下的bin目录
			//不能使用File的相对路径来获得xml
					/*File xml = new File(".");
					String path =  xml.getAbsolutePath();
					System.out.println(path);*/
		
		//其实 javaee 在servletContext 中准备了一些获得资源的相关方法
			//1 获得sc
			ServletContext sc = getServletContext();
			//2 getResourceAsStream ==> 填写相对路径即可, 相对的是webRoot下
				InputStream is = sc.getResourceAsStream("/WEB-INF/students.xml");
				System.out.println(is);
				
				String path = sc.getRealPath("/WEB-INF/students.xml");
				System.out.println(path);
				
				Set set = sc.getResourcePaths("/");
				
				for(Object obj : set){
					System.out.println(obj);
				}
				
				String path2= sc.getResource("/WEB-INF/students.xml").getPath();
				System.out.println(path2);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
