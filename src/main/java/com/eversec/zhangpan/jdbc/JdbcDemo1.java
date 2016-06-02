package com.eversec.zhangpan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC入门案例：展示编码步骤
//任务目标：把数据库中users中的所有记录查询出来，打印到控制台上
/*
create database day15;

use day15;

create table users(
	id int primary key auto_increment,
	name varchar(40),
	password varchar(40),
	email varchar(60),
	birthday date
);

insert into users(name,password,email,birthday) values('zs','123456','zs@sina.com','1980-12-04');
insert into users(name,password,email,birthday) values('lisi','123456','lisi@sina.com','1981-12-04');
insert into users(name,password,email,birthday) values('wangwu','123456','wangwu@sina.com','1979-12-04');
 */

public class JdbcDemo1 {

	public static void main(String[] args) throws SQLException {
//		1、注册驱动
		/*DriverManager.registerDriver(new com.mysql.jdbc.Driver());//ctrl+shit+t
*///		2、获取与数据库的链接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15", "root", "sorry");
		System.out.println(conn.getClass().getName());
//		3、创建代表SQL语句的对象
		Statement stmt = conn.createStatement();
//		4、执行SQL语句
		ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");
//		5、如果是查询语句：返回结果集。
		while(rs.next()){
			System.out.println(rs.getObject("id"));
			System.out.println(rs.getObject("name"));
			System.out.println(rs.getObject("password"));
			System.out.println(rs.getObject("email"));
			System.out.println(rs.getObject("birthday"));
			System.out.println("---------------------");
		}
//		6、释放资源
		rs.close();
		stmt.close();
		conn.close();
	}

}
