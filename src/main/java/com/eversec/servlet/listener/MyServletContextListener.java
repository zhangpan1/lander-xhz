package com.eversec.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//何时执行时关键

public class MyServletContextListener implements ServletContextListener {
	//重点：该方法执行一次，因为ServletCOntext只有一个。
	//应用场景：完成系统的初始化工作。
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		System.out.println(sc+"初始化");
		ServletContext sd = sce.getServletContext();
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		System.out.println(sc+"销毁");
	}
	
}
