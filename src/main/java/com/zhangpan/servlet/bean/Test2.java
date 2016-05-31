/*package cn.itcast.bean;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Date;

public class Test2 {

	*//**
	 * @param args
	 * 自动把一个bean中的属性值 拷贝到另一个bean中
	 *//*
	public static void main(String[] args) {
		User u1 = new User();
		u1.setName("tom");
		u1.setPassword("1234");
		u1.setAge(18);
		u1.setBirthday(new Date());
		//-----------
		User2 u2 = new User2();
		
		copyProperties(u1,u2);// struts1 
		
		System.out.println(u2);
		
		
		
	}

	private static void copyProperties(User u1, User2 u2) {
		
		//1 获得u1中的属性描述
		//2 遍历这些属性描述
		try {
			for(PropertyDescriptor pd :Introspector.getBeanInfo(u1.getClass()).getPropertyDescriptors()){
					String propName = pd.getName();
					if (!propName.equals("class")) {
						//3 查看u2是否具有这些属性
						PropertyDescriptor pd2 = new PropertyDescriptor(
								propName, User2.class);
						//有该属性 ==> 获得该属性值,查看是否是null
						if (pd2 != null) {
							Object obj = pd.getReadMethod().invoke(u1);
							if (obj != null) {
								//不是null 拷贝到u2
								pd2.getWriteMethod().invoke(u2, obj);
							}
						}
					}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}

}
*/