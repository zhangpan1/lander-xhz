/*package com.eversec.upload.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//借助commons-fileupload组件实现文件上传：简单版本
public class UploadServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//检测form是否是multipart/form-data类型的
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart){
			throw new RuntimeException("The form's enctype attribute value must be multipart/form-data");
		}
		//解析请求内容
		DiskFileItemFactory factory = new DiskFileItemFactory();//产生FileItem的工厂
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List<FileItem> items = new ArrayList<FileItem>();
		try {
			items = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			throw new RuntimeException("解析请求失败");
		}
		//遍历：
		for(FileItem item:items){
			//处理普通字段
			if(item.isFormField()){
				processFormField(item);
			}else{
			//处理上传字段
				processUploadField(item);
			}
		}
	}

	protected void processUploadField(FileItem item) {
		try {
//			InputStream in = item.getInputStream();
			//找一个存放文件的位置；存放的文件名
			String fileName = item.getName();//上传的文件的文件名  C:\Users\wzhting\Desktop\a.txt  a.txt(浏览器不同)
			if(fileName!=null){
				fileName = FilenameUtils.getName(fileName);
			}
			//存放路径
			String realPath = getServletContext().getRealPath("/files");
			File storeDirectory = new File(realPath);
			if(!storeDirectory.exists()){
				storeDirectory.mkdirs();
			}
//			OutputStream out = new FileOutputStream(new File(storeDirectory, fileName));
//			
//			int len = -1;
//			byte b[] = new byte[1024];
//			while((len=in.read(b))!=-1){
//				out.write(b, 0, len);
//			}
//			in.close();
//			out.close();
			
			item.write(new File(storeDirectory, fileName));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void processFormField(FileItem item) {
		//打印到控制台
		String fieldName = item.getFieldName();
		String fieldValue = item.getString();
		System.out.println(fieldName+"="+fieldValue);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
*/