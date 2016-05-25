package com.zhangpan.servlet.context;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//获得lib目录下的资源
			getServletContext().getRealPath("/WEB-INF/lib/students.xml");
			//获得src下的资源==> 获得classes目录下的资源
			getServletContext().getRealPath("/WEB-INF/classes/students.xml");
			//获得cn.itcast.servlet.servlet_context包下的资源
			getServletContext().getRealPath("/WEB-INF/classes/cn/itcast/servlet/servlet_context/students.xml");
			//---------------------------------------------------------------------------
			//如果获得的是包下的,那么太麻烦了.
			//一:使用getClass().getResourceAsStream方法,相对路径分为两种情况
				//1: 加"/"  ==> 相对的是classes目录
				//2: 不加"/" ==> 相对的是本类当前目录
			InputStream is = this.getClass().getResourceAsStream("students.xml");
			System.out.println(is);
			//二:使用this.getClass().getClassLoader().getResourceAsStream("");获得
				//只有一个相对路径 ==> 就是相对于 classes目录
			InputStream is2 = 	this.getClass().getClassLoader().getResourceAsStream("students.xml");
			System.out.println(is2);
			
		
			
			//注意: 使用类和类加载器加载资源文件时
				//1 jvm运行期间只加载一次. 但是使用下面的代码可以解决这个问题.
					String path = this.getClass().getClassLoader().getResource("students.xml").getPath();
					File file = new File(path.substring(1, path.length()));
					System.out.println(path);
				//2 getClassLoader()原本是用来加载.class文件的, 所以缓存设计的很小.不要用他加载一些别较大的资源.
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map map=null;
		
	}

}
