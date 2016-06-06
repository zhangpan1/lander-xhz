package com.eversec.upload.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String name = request.getParameter("name");
//		String photos[] = request.getParameterValues("photo");
//		System.out.println("name="+name);
//		System.out.println("photos="+photos);
		
		ServletInputStream sis = request.getInputStream();
		int len = -1;
		byte b[] = new byte[1024];
		while((len=sis.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}
		sis.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
