package com.eversec.login.mvc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import com.thoughtworks.xstream.XStream;

//把JavaBean---->XML
public class XStreamDemo {
	@Test
	public void test1(){
		Product p = new Product(1, "金瓶梅", 20);
		XStream xs = new XStream();
		
		//指定别名
		xs.alias("product", Product.class);
		
		String xml = xs.toXML(p);
		System.out.println(xml);
	}
	@Test
	public void test2(){
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "充气筒", 20));
		products.add(new Product(2, "金瓶梅", 10));
		products.add(new Product(3, "袜子", 10));
		products.add(new Product(4, "洗衣粉", 10));
		products.add(new Product(5, "肥皂", 7));
		
		XStream xs = new XStream();
		//指定别名
		xs.alias("products", List.class);
		xs.alias("product", Product.class);
		String xml = xs.toXML(products);
		System.out.println(xml);
	}
}
