package com.eversec.zhangpan.crm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;



/*
create table account(
	id int primary key auto_increment,
	name varchar(40),
	money float
)character set utf8 collate utf8_general_ci;

insert into account(name,money) values('aaa',1000);
insert into account(name,money) values('bbb',1000);
insert into account(name,money) values('ccc',1000);
 */
public class AccountDemo {
	@Test
	public void test1(){
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);//设置事务的隔离级别
			conn.setAutoCommit(false);//  start transaction
			
			stmt = conn.prepareStatement("update account set money=money-100 where name='aaa'");
			stmt.executeUpdate();
			int i=1/0;
			stmt = conn.prepareStatement("update account set money=money+100 where name='bbb'");
			stmt.executeUpdate();
			
			conn.commit();// commit
		}catch(Exception e){
			if(conn!=null){
				try {
					conn.rollback();//rollback
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally{
			JdbcUtil.release(null, stmt, conn);
		}
	}
	//简单了解：事务回滚点
	@Test
	public void test2(){
		Connection conn = null;
		PreparedStatement stmt = null;
		Savepoint sp = null;
		try{
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//  start transaction
			
			stmt = conn.prepareStatement("update account set money=money-100 where name='aaa'");
			stmt.executeUpdate();
			
			stmt = conn.prepareStatement("update account set money=money+100 where name='bbb'");
			stmt.executeUpdate();
			
			sp = conn.setSavepoint();//设置一个回滚点
			
			stmt = conn.prepareStatement("update account set money=money-100 where name='bbb'");
			stmt.executeUpdate();
			
			int i=1/0;
			
			stmt = conn.prepareStatement("update account set money=money+100 where name='ccc'");
			stmt.executeUpdate();
//			conn.commit();// commit
		}catch(Exception e){
			if(conn!=null){
				try {
					conn.rollback(sp);//rollback到一个回滚点，事务并没有结束
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JdbcUtil.release(null, stmt, conn);
		}
	}
}
