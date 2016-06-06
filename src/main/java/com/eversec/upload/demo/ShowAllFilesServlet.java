package com.eversec.upload.demo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//把WEB-INF/files中的所有文件遍历出来，封装到Map中
public class ShowAllFilesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String realPath = getServletContext().getRealPath("/WEB-INF/files");
		//key:UUID文件名；value：老文件名
		Map<String, String> map = new HashMap<String, String>();
		File file = new File(realPath);
		treeWalk(file,map);
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("/listFiles.jsp").forward(request, response);
	}
	//递归遍历
	private void treeWalk(File file, Map<String, String> map) {
		if(file.isFile()){
			String guidFileName = file.getName();// LKSDJFLKDSKF_a.txt
			String oldFileName = guidFileName.substring(guidFileName.indexOf("_")+1);// a.txt
			map.put(guidFileName, oldFileName);
		}else{
			File files[] = file.listFiles();
			for(File f:files){
				treeWalk(f,map);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
