package com.eversec.xhz.listener;

public class Student {
	private String name;
	private StudentListener listener;
	public Student(String name){
		this.name = name;
	}
	public void eat(){
		if (listener != null){
			listener.preEat(new StudentEvent(this));
		}
		System.out.println(name+":开吃");
	}
	public void Study(){
		if (listener != null){
			listener.preStudy(new StudentEvent(this));
		}
		System.out.println(name+":开始学习");
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addStudentListener(StudentListener listener){
		this.listener = listener;
	}
}
