package com.eversec.xhz.listener;

public class StudentEvent {
	private Object source;
	
	public StudentEvent(Object source){
		this.source = source;
	}
	public Object getSource(){
		return source;
	}
	
}
