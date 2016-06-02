package com.eversec.zhangpan.crm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class CustomerDaoMySQLImpl implements CustomerDao {

	public List<Customer> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select * from customers");
			rs = stmt.executeQuery();
			List<Customer> cs = new ArrayList<Customer>();
			while(rs.next()){
				Customer c = new Customer();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setEmail(rs.getString("email"));
				c.setHobby(rs.getString("hobby"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));
				cs.add(c);
			}
			
			return cs;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
		
	}

	public void save(Customer c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("insert into customers (name,gender,birthday,cellphone,email,hobby,type,description) values (?,?,?,?,?,?,?,?)");
			stmt.setString(1,c.getName());
			stmt.setString(2,c.getGender());
			stmt.setDate(3,new java.sql.Date(c.getBirthday().getTime()));
			stmt.setString(4,c.getCellphone());
			stmt.setString(5,c.getEmail());
			stmt.setString(6,c.getHobby());
			stmt.setString(7,c.getType());
			stmt.setString(8,c.getDescription());
			stmt.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
		
	}

	public void del(Integer customerId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("delete from customers where id=?");
			stmt.setInt(1, customerId);
			stmt.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
		
	}

	public void update(Customer c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("update customers set name=?,gender=?,birthday=?,cellphone=?,email=?,hobby=?,type=?,description=? where id=?");
			stmt.setString(1,c.getName());
			stmt.setString(2,c.getGender());
			stmt.setDate(3,new java.sql.Date(c.getBirthday().getTime()));
			stmt.setString(4,c.getCellphone());
			stmt.setString(5,c.getEmail());
			stmt.setString(6,c.getHobby());
			stmt.setString(7,c.getType());
			stmt.setString(8,c.getDescription());
			stmt.setInt(9, c.getId());
			stmt.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
		
	}

	public Customer findOne(Integer customerId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select * from customers where id=?");
			stmt.setInt(1, customerId);
			rs = stmt.executeQuery();
			if(rs.next()){
				Customer c = new Customer();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setEmail(rs.getString("email"));
				c.setHobby(rs.getString("hobby"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));
				return c;
			}
			
			return null;
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}

}
