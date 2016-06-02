package com.eversec.xhz.datasource;

import java.sql.Connection;
//装饰模式的变体
import java.sql.SQLException;
import java.util.List;

public class MyConnection1 extends ConnectionWrapper {
	private Connection conn;
	private List<Connection> pool;
	public MyConnection1(Connection conn,List<Connection> pool) {
		super(conn);
		this.conn = conn;
		this.pool = pool;
	}
	public void close() throws SQLException {
		pool.add(conn);
	}
	
}
