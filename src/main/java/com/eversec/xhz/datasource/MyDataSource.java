package com.eversec.xhz.datasource;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;



//标准的数据源
public class MyDataSource implements DataSource {
	
	private static List<Connection> pool = Collections.synchronizedList(new ArrayList<Connection>());
	//最开始初始化一些链接到池中
	static{
		for(int i=0;i<10;i++){
			Connection conn = JdbcUtil.getConnection();
			pool.add(conn);
		}
	}
	
	
	public Connection getConnection() throws SQLException {
		if(pool.size()>0){
			final Connection conn =  pool.remove(0);//数据库驱动的
			Connection proxyConn = (Connection)Proxy.newProxyInstance(conn.getClass().getClassLoader(), 
					conn.getClass().getInterfaces(), new InvocationHandler() {
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
							if("close".equals(method.getName())){
								//用户调用的是close方法：还回池中
								return pool.add(conn);
							}else{
								//调用原来对象的对应方法
								return method.invoke(conn, args);
							}
						}
					});
			return proxyConn;
		}else{
			throw new RuntimeException("服务器忙");
		}
	}
	
	
	
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {

	}

	public void setLoginTimeout(int seconds) throws SQLException {

	}

	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	public Connection getConnection(String username, String password)
			throws SQLException {
		return null;
	}



	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}
