/*package com.zhangpan.servlet.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.sun.org.apache.commons.beanutils.ConvertUtils;

public class BServlet extends HttpServlet {

	*//**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 *//*
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		User u = new User();
		
		u.setName(request.getParameter("name"));
		u.setPassword(request.getParameter("password"));
		//处理业务
		//使用内省封装参数.
		//populate(request.getParameterMap(), u);
		//BeanUtils ==> 
		try {
			//注册一个转换器,告诉BeanUtils如何进行转换
			ConvertUtils.register(new MyConverter(), Date.class);
			
			BeanUtils.populate(u,request.getParameterMap());
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(u);
		
		

	}

	private void populate(Map<String,String[]> map, User u) {
		try {
			Map<String,String[]> params = map;
			
			BeanInfo info = Introspector.getBeanInfo(User.class);
			
			PropertyDescriptor[] pds = info.getPropertyDescriptors();
			
			for(PropertyDescriptor pd : pds){
				//System.out.println(pd.getName());
				String[] param = params.get(pd.getName());
				if(param!=null && param.length>0){
					pd.getWriteMethod().invoke(u, param[0])	;
				}
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
*/