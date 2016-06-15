/*package com.itheima.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
	private static SessionFactory factory;//一个应用一般只有一个SessioFactory，他的创建比较耗时。
	static{
		Configuration cfg = new Configuration().configure();//读取hibenate.cfg.xml配置文件
		factory = cfg.buildSessionFactory();//根据配置文件信息产生SessionFactory对象
	}
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	//当做JDBC中的Connection
	public static Session getSession(){
		Session session = factory.openSession();
		return session;
	}
}
*/