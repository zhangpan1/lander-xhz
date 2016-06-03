package com.eversec.xhz.dbutil;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		ThreadLocal tl = new ThreadLocal();//容器
		
		tl.set("p");//向tl的Map中放了一个P，key是Main线程
		
		//启动另外一个线程
		Thread1 tt = new Thread1(tl);
		tt.start();
		
		Object obj = tl.get();
		System.out.println(Thread.currentThread().getName()+":"+obj);
	}

}
