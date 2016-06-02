package com.eversec.zhangpan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



//JDBC改进

public class JdbcDemo2 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:///day15?user=root&password=sorry");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id,name,password,email,birthday from users");
		List<User> users = new ArrayList<User>();
		while(rs.next()){
			//封装:把结果搞到实体Bean（Domain），模型
			//数据库类型和Java类型的对应关系：固定的
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setBirthday(rs.getDate("birthday"));
			users.add(user);
		}
		rs.close();
		stmt.close();
		conn.close();
		
		for(User u:users)
			System.out.println(u);
	}

}
