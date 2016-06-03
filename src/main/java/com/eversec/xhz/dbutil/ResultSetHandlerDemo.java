package com.eversec.xhz.dbutil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;



public class ResultSetHandlerDemo {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	//ArrayHandler:适合结果只有一条的情况。把记录中的每个字段的值封装到了一个Object[]中。
	@Test
	public void test1() throws SQLException{
		Object[] objs = qr.query("select * from person", new ArrayHandler());
		for(Object obj:objs)//每个元素就是列的值
			System.out.println(obj);
	}
	//ArrayListHandler:多条结果。把每条记录的列值封装到Object[]，再把Object[]封装到List中
	@Test
	public void test2() throws SQLException{
		List<Object[]> list = qr.query("select * from person", new ArrayListHandler());
		for(Object[] objs:list){
			System.out.println("----------------------");
			for(Object obj:objs)//每个元素就是列的值
				System.out.println(obj);
		}
	}
	//ColumnListHandler:封装某列的值。把取出的列值封装到List中。
	@Test
	public void test3() throws SQLException{
		List<Object> list = qr.query("select * from person", new ColumnListHandler("name"));
		for(Object obj:list){
			System.out.println(obj);
		}
	}
	//KeyedHandler:适合有多条记录的情况
	@Test
	public void test4() throws SQLException{
		Map<Object, Map<String,Object>> bmap = qr.query("select * from person", new KeyedHandler("id"));
		for(Map.Entry<Object, Map<String,Object>> bme:bmap.entrySet()){
			System.out.println("------------------");
			for(Map.Entry<String, Object> lme:bme.getValue().entrySet()){
				System.out.println(lme.getKey()+":"+lme.getValue());
			}
		}
	}
	//MapHandler:适合结果有一条的情况。把记录的列明作为key，列值作为value封装到一个Map中
	@Test
	public void test5() throws SQLException{
		Map<String,Object> map= qr.query("select * from person", new MapHandler());
		for(Map.Entry<String, Object> me:map.entrySet()){
			System.out.println(me.getKey()+":"+me.getValue());
		}
	}
	//MapListHandler:适合多条记录的结果。把记录的列明作为key，列值作为value封装到一个Map中。再把Map放到List中
	@Test
	public void test6() throws SQLException{
		List<Map<String,Object>> list= qr.query("select * from person", new MapListHandler());
		for(Map<String,Object> map:list){
			System.out.println("------------------");
			for(Map.Entry<String, Object> me:map.entrySet()){
				System.out.println(me.getKey()+":"+me.getValue());
			}
		}
	}
	//ScalarHandler:适合结果只有一条且只有一列情况。
	@Test
	public void test7() throws SQLException{
		Object obj = qr.query("select count(*) from person", new ScalarHandler(1));
		System.out.println(obj.getClass().getName());
		System.out.println(obj);
	}
}
