package com.eversec.xhz.datasource;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



//模拟连接池
public class SimpleConnectionPool {
	//存放链接对象的池
	private static List<Connection> pool = Collections.synchronizedList(new ArrayList<Connection>());
	//最开始初始化一些链接到池中
	static{
		for(int i=0;i<10;i++){
			Connection conn = JdbcUtil.getConnection();
			pool.add(conn);
		}
	}
	//从池中获取一个链接
	public static Connection getConnection(){
		if(pool.size()>0){
			return pool.remove(0);
		}else{
			throw new RuntimeException("服务器忙");
		}
	}
	//用完后还回池中
	public static void release(Connection conn){
		pool.add(conn);
	}
}
