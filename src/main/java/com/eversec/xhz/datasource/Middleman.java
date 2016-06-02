package com.eversec.xhz.datasource;
//静态代理
public class Middleman implements Human{
	private Human h;
	public Middleman(Human h){
		this.h = h;
	}
	public void sing(float money) {
		if(money>10000)
			h.sing(money/2);
	}

	public void dance(float money) {
		if(money>20000)
			h.dance(money/2);
	}

	public void eat() {
		
	}

}
