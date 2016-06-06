package com.eversec.filter.examine;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//控制静态资源的缓存时间
public class NeedCacheFilter implements Filter {

	private FilterConfig filterConfig;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request;
		HttpServletResponse response;
		try{
			request = (HttpServletRequest)req;
			response = (HttpServletResponse)resp;
		}catch(Exception e){
			throw new RuntimeException("non-http request or response");
		}
		
		long time = 0;//缓存的时间.单位是毫秒
		
		//知道用户访问的是html|css|js   截取uri的后缀  /day19_01_example/1.html
		String uri = request.getRequestURI();//    /day19_01_example/1.html
		String extensitionName = uri.substring(uri.lastIndexOf(".")+1);// html
		
		
		
		//获取对应的参数：设置缓存的时间
		if("html".equals(extensitionName)){
			time = Long.parseLong(filterConfig.getInitParameter("html"))*60*1000;
		}
		if("css".equals(extensitionName)){
			time = Long.parseLong(filterConfig.getInitParameter("css"))*60*1000;
		}
		if("js".equals(extensitionName)){
			time = Long.parseLong(filterConfig.getInitParameter("js"))*60*1000;
		}
		
		response.setDateHeader("Expires", System.currentTimeMillis()+time);
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
