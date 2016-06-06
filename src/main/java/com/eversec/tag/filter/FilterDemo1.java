package com.eversec.tag.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements Filter {
	
	public FilterDemo1(){
		System.out.println("FilterDemo1实例化了");
	}
	
	//初始化方法
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FilterDemo1初始化了");
	}
	//针对拦截范围内的资源的访问，每次访问都会由容器来调用该方法。
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("FilterDemo1执行了");
		chain.doFilter(request, response);//放行：让下一个上
	}
	//销毁方法
	public void destroy() {
		System.out.println("FilterDemo1销毁了");
	}

}
