/*package com.eversec.xhz.datasource;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		final SpringBrother bitch = new SpringBrother();//不能是final的
		//用他的子类作为代理类
		
		 Class superclass:父类型
		 Callback callback：如何代理
		 
		SpringBrother middleman = (SpringBrother) Enhancer.create(SpringBrother.class, new MethodInterceptor(){
			//匿名内部类：具体策略
			//只要执行任何方法，都会经过该方法
			
			 返回值：当前调用的方法的返回值
			 Object proxy：当前代理对象的引用。
			 Method method:当前执行的方法。
			 Object[] args:当前指定的方法用到的参数
			 
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy arg3) throws Throwable {
				if("sing".equals(method.getName())){
					float money = (Float)args[0];
					if(money>10000){
						method.invoke(bitch, money/2);
					}
				}
				if("dance".equals(method.getName())){
					float money = (Float)args[0];
					if(money>20000){
						method.invoke(bitch, money/2);
					}
				}
				return null;
			}
			
		});
		middleman.sing(100000);
		middleman.dance(200000);
	}

}
*/