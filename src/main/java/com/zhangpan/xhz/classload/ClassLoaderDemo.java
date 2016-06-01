package com.zhangpan.xhz.classload;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderDemo {
	public static void main(String[] args) throws IOException {
		test1();
	}
	private static void test2() throws IOException {
		ClassLoader cl = ClassLoaderDemo.class.getClassLoader();
		InputStream in = cl.getResourceAsStream("a.properties");
		Properties prop = new Properties();
		prop.load(in);
		System.out.println(prop.getProperty("key"));
	}
	private static void test1() throws IOException {
		ClassLoader cl = ClassLoaderDemo.class.getClassLoader();
		InputStream in = cl.getResourceAsStream("a.properties");
		Properties prop = new Properties();
		prop.load(in);
		System.out.println(prop.getProperty("key"));
	}
}
