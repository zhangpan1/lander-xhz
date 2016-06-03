package com.eversec.xhz.dbutil;

public class Thread1 extends Thread {

	private ThreadLocal tl;

	public Thread1(ThreadLocal tl) {
		this.tl = tl;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName()+":"+tl.get());
	}
	
}
