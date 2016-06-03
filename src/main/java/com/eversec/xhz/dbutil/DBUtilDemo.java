package com.eversec.xhz.dbutil;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;


/*
create database day18;
use day18;
create table person(
	id int primary key,
	name varchar(100),
	birthday date
);
 */
public class DBUtilDemo {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	@Test
	public void test1() throws SQLException{
		qr.update("insert into person values(?,?,?)", 1,"zxn","1998-09-08");
	}
	@Test
	public void test11() throws SQLException{
		qr.update("insert into person values(?,?,?)", 2,"zxnn",new Date());
	}
	@Test
	public void test2() throws SQLException{
		qr.update("update person set name=? where id=?", "lxj",2);
	}
	@Test
	public void test3() throws SQLException{
		qr.update("delete from person where id=?", 2);
	}
	//批处理
	@Test
	public void test4() throws SQLException{
		//高维：插入的记录条数    低维：每条记录的参数
		Object [][]params = new Object[10][];
		
		for(int i=0;i<10;i++){
			params[i] = new Object[]{i+1,"aaa"+(i+1),new Date()};
		}
		
		qr.batch("insert into person values(?,?,?)", params);
	}

}
