package com.eversec.zhangpan.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;



//JDBC的CRUD
public class JdbcDemo5 {
	@Test
	public void testAdd(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			int num = stmt.executeUpdate("insert into users (id,name,password,email,birthday) values (4,'周小宁','123456','zxn@itcast.cn','1995-10-09')");
			Assert.assertEquals(1, num);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	@Test
	public void testUpdate(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			int num = stmt.executeUpdate("update users set email='zxn@itheima.com' where id=4");
			Assert.assertEquals(1, num);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	@Test
	public void testFind(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users where id=4");
			if(rs.next()){
				System.out.println(rs.getString("name"));
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
	@Test
	public void testDelete(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			int num = stmt.executeUpdate("delete from users where id=4");
			Assert.assertEquals(1, num);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
}
