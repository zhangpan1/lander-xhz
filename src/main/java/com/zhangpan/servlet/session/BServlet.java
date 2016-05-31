package com.zhangpan.servlet.session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.获得要添加的商品（0-5）；
		String name = req.getParameter("name");
		int intName = Integer.parseInt(name);
		//2.将数字翻译成中文商品名称（使用数组）
		String[] products = new String[]{"肥皂","电动车","笔记本","小雨伞","八度空间","床单"};
		String productName = products[intName];
		//3.获得session
		HttpSession session = req.getSession();
		//4.获得session中保存的购物车（Map）
		Map<String,Integer> map = (Map<String,Integer>) session.getAttribute("car");
		if (map!=null){
			//获得到了==》不是第一次访问 ==》继续向Map中添加
			Integer count = map.get(productName);
			if(count == null){
				//不存在==》  添加并设置数量为1
				count = 1;
			}else{
				//map已经存在这个商品==》把数量加1
				count ++;
			}
			map.put(productName, count);
		}else{
			//没获得的==>第一次访问
			map = new HashMap<String,Integer>();
			//新建Map==>将商品添加并设置数量为1
			map.put(productName, 1);
		}
		//5 将Map操作完再放回session
		session.setAttribute("car", map);
		//6 返回到列表页面（重定向）
		resp.sendRedirect(req.getContextPath()+"/car/list.jsp");
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
	
}
