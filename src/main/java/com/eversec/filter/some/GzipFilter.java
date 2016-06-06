package com.eversec.filter.some;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GzipFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request;
		HttpServletResponse response;

		try {
			request = (HttpServletRequest) req;
			response = (HttpServletResponse) res;
		} catch (ClassCastException e) {
			throw new ServletException("non-HTTP request or response");
		}
		
		MyHttpServletResponse mresponse = new MyHttpServletResponse(response);
		chain.doFilter(request, mresponse);
		
		byte b[] = mresponse.getBytes();//原始数据:关键
		System.out.println("原始大小："+b.length);
		//判断客户端支持gzip吗
		if(request.getHeader("Accept-Encoding").contains("gzip")){
			//压缩输出
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			GZIPOutputStream gout = new GZIPOutputStream(out);
			gout.write(b);
			gout.close();
			
			b = out.toByteArray();//压缩后的数据
			System.out.println("压缩后大小："+b.length);
			//告知客户端压缩方式
			response.setHeader("Content-Encoding", "gzip");
			response.setContentLength(b.length);
		}
		ServletOutputStream sos = response.getOutputStream();
		sos.write(b);
	}

	public void destroy() {

	}

}
class MyHttpServletResponse extends HttpServletResponseWrapper{
	private ByteArrayOutputStream baos = new ByteArrayOutputStream();//临时仓库：存放原始数据的
	private PrintWriter pw;
	public MyHttpServletResponse(HttpServletResponse response) {
		super(response);
	}
	//字节流
	public ServletOutputStream getOutputStream() throws IOException {
		return new MyServletOutputStream(baos);
	}
	//字符流
	public PrintWriter getWriter() throws IOException {
		pw = new PrintWriter(new OutputStreamWriter(baos, super.getCharacterEncoding()));
		return pw;
	}
	public byte[] getBytes(){
		try {
			if(pw!=null){
				pw.close();
			}
			baos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toByteArray();
	}
}
class MyServletOutputStream extends ServletOutputStream{
	private ByteArrayOutputStream baos;
	public MyServletOutputStream(ByteArrayOutputStream baos){
		this.baos = baos;
	}
	public void write(int b) throws IOException {
		baos.write(b);
	}
	
}
