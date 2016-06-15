/*package com.eversec.login.mvc;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JsonConfig;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class JSONDemo {
	@Test
	public void test1(){
		String s[] = {"a","b","c"};
		JSONArray json = JSONArray.getJSONObject(s);
		System.out.println(json);
	}
	@Test
	public void test2(){
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		JSONArray json = JSONArray.toJSONObject(list);
		System.out.println(json);
	}
	@Test
	public void test3(){
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "金瓶梅", 20));
		list.add(new Product(2, "葵花", 20));
		JSONArray json = JSONArray.toJSONObject(list);
		System.out.println(json);
	}
	@Test
	public void test4(){
		Product p = new Product(1, "金瓶梅", 20);
		JSONObject json = JSONObject.toJSONObject(p);
		System.out.println(json);
	}
	//过滤
	@Test
	public void test5(){
		Product p = new Product(1, "金瓶梅", 20);
		JsonConfig jc = new JsonConfig();
		jc.setExcludes(new String[]{"id"});
		JSONObject json = JSONObject.fromObject(p,jc);
		System.out.println(json);
	}
}
*/