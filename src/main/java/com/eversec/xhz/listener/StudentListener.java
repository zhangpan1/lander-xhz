package com.eversec.xhz.listener;

public interface StudentListener {
	void preEat(StudentEvent e);//监控吃饭之前的方法
	void preStudy(StudentEvent e);//监控学习之前的方法
}
