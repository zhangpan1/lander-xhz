package com.eversec.zhangpan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;




//JDBC改进:JDBC编码的模板

public class JdbcDemo4 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select id,name,password,email,birthday from users");
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
			
			for(User u:users)
				System.out.println(u);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{// final finally finalize区别
			JdbcUtil.release(rs, stmt, conn);
		}
	}

}
