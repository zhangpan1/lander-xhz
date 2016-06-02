package com.eversec.zhangpan.crm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;


public class LobDemo {
	/*
	 create table t2(
	 	id int primary key,
	 	content longtext
	 );
	 */
	//插入大文本数据
	@Test
	public void testTextWrite() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into t2 (id,content) values (?,?)");
		stmt.setInt(1, 1);
		
		File file = new File("src/jpm.txt");
		Reader reader = new FileReader(file);
		stmt.setCharacterStream(2, reader, (int)file.length());//MySQL驱动对于setCharacterStream（int,Reader,long)根本没有实现
		
		stmt.executeUpdate();
		
		JdbcUtil.release(null, stmt, conn);
	}
	//取出大文本数据
	@Test
	public void testTextRead() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from t2 where id=1");
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			Reader r = rs.getCharacterStream("content");
			//写到磁盘上
			Writer w = new FileWriter("d:/jpm.txt");
			char c[] = new char[1024];
			int len = -1;
			while((len=r.read(c))!=-1){
				w.write(c, 0, len);
			}
			r.close();
			w.close();
		}
		
		JdbcUtil.release(rs, stmt, conn);
	}
	/*
	 create table t3(
	 	id int primary key,
	 	content longblob
	 );
	 */
	//插入大二进制数据
	@Test
	public void testBlobWrite() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into t3 (id,content) values (?,?)");
		stmt.setInt(1, 1);
		InputStream in = new FileInputStream("src/19.jpg");
		stmt.setBinaryStream(2, in, in.available());
		
		stmt.executeUpdate();
		
		JdbcUtil.release(null, stmt, conn);
	}
	//取出大二进制数据
	@Test
	public void testBlobRead() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from t3 where id=1");
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			InputStream in = rs.getBinaryStream("content");
			//写到磁盘上
			OutputStream out = new FileOutputStream("d:/a.jpg");
			byte b[] = new byte[1024];
			int len = -1;
			while((len=in.read(b))!=-1){
				out.write(b, 0, len);
			}
			in.close();
			out.close();
		}
		
		JdbcUtil.release(rs, stmt, conn);
	}
}
