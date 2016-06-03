package com.eversec.zhangpan.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;


public class MetaDataDemo {
	//数据库本身的元信息的获取
	@Test
	public void test1() throws SQLException{
		Connection conn = DBCPUtil.getConnection();
		DatabaseMetaData dmd = conn.getMetaData();
		System.out.println(dmd.getDatabaseProductName());
		
		conn.close();
	}
	//SQL语句参数的元信息
	@Test
	public void test2() throws SQLException{
		Connection conn = DBCPUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("??");//SQL语句要求程序要要写对
		ParameterMetaData pmd = stmt.getParameterMetaData();
		int num = pmd.getParameterCount();//获取sql语句中的占位符的个数
		System.out.println(num);
		conn.close();
	}
	//结果集元信息
	@Test
	public void test3() throws SQLException{
		Connection conn = DBCPUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from account");
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int num = rsmd.getColumnCount();//列数
		for(int i=0;i<num;i++){
			String columnName = rsmd.getColumnName(i+1);
			int type = rsmd.getColumnType(i+1);
			System.out.println(columnName+":"+type);
		}
		conn.close();
	}
}
