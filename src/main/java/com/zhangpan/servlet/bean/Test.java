/*package cn.itcast.bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class Test {

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		//内省就是操作我们javabean提供的一套api
		User u = new User();
		//例如: 利用内省原理 设置u的 名字为tom.密码为1234
		
		//1 获得 java Bean的描述信息
			try {
				BeanInfo info =	Introspector.getBeanInfo(User.class);
				
				//2 获得 User中的属性信息
				PropertyDescriptor[] pds = info.getPropertyDescriptors();
				
				//3 遍历属性信息
				
				for(PropertyDescriptor pd : pds){
					Method writer = pd.getWriteMethod();
					//判断当前遍历的属性是否是 name属性
					if(pd.getName().equals("name")){
						//如果是name属性,获得操作name属性的写入方法(setName)
						writer.invoke(u, "tom");
					}else if(pd.getName().equals("password")){
						//如果是password属性,获得操作password属性的写入方法(setPassword)
						writer.invoke(u, "1234");
					}
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(u);
		
	}

}
*/