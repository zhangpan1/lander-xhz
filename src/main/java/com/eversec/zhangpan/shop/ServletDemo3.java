package com.eversec.zhangpan.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletDemo3 extends HttpServlet {
	private List<Product> products = new ArrayList<Product>();
	public void init() throws ServletException {
		products.add(new Product(1, "充气筒", 20));
		products.add(new Product(2, "金瓶梅", 10));
		products.add(new Product(3, "袜子", 10));
		products.add(new Product(4, "洗衣粉", 10));
		products.add(new Product(5, "肥皂", 7));
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("products", products);
		request.getRequestDispatcher("/listProducts.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
