package com.eversec.zhangpan.crm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;



public class BatchDemo1 {
	@Test
	//插入2条数据，删除第一条。批处理
	/*
	create database day16;
	use day16;
	create table t1(
		id int primary key,
		name varchar(100)
	);
	 */
	//如果批处理执行的语句不相同，最好使用Statement
	public void test1(){
		Connection conn = null;
		Statement stmt =  null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();//内部有一个List，就是sql语句的缓存
			
			String sql1 = "insert into t1 (id,name) values(1,'aa1')";
			String sql2 = "insert into t1 (id,name) values(2,'aa2')";
			String sql3 = "delete from t1 where id=1";
			
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			
			int [] ii = stmt.executeBatch();//批处理.每条语句影响的行数
			
			for(int i:ii)
				System.out.println(i);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(null, stmt, conn);
		}
	}
	
	//很多时候：语句相同，只是参数不同
	//PreparedStatement
	//插入10条记录
	@Test
	public void test2(){
		Connection conn = null;
		PreparedStatement stmt =  null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("insert into t1 (id,name) values(?,?)");
			
			for(int i=0;i<10;i++){
				stmt.setInt(1, i+1);
				stmt.setString(2, "aa"+(i+1));
				stmt.addBatch();//向缓存中加的参数
			}
			
			int [] ii = stmt.executeBatch();//批处理.每条语句影响的行数
			
			for(int i:ii)
				System.out.println(i);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(null, stmt, conn);
		}
	}
	//插入100001条记录
	@Test
	public void test3(){
		Connection conn = null;
		PreparedStatement stmt =  null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("insert into t1 (id,name) values(?,?)");
			
			for(int i=0;i<100001;i++){
				stmt.setInt(1, i+1);
				stmt.setString(2, "aa"+(i+1));
				stmt.addBatch();//向缓存中加的参数
				if(i%1000==0){
					stmt.executeBatch();// 执行一次
					stmt.clearBatch();//清空缓存中的内容
				}
			}
			
			stmt.executeBatch();//批处理.每条语句影响的行数
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(null, stmt, conn);
		}
	}
}
