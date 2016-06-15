/*package com.itheima.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.domain.Student;
import com.itheima.util.SessionFactoryUtil;

public class StudentDemo {
	@Test
	public void testAdd(){
		Session session = null;
		try{
			Student s = new Student();
			s.setName("周小宁");
			s.setBirthday(new Date());
			session = SessionFactoryUtil.getSession();
			//开始事务
			Transaction tx = session.beginTransaction();
			session.save(s);
			tx.commit();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}
	@Test
	public void testFindOne(){
		Session session = null;
		try{
			session = SessionFactoryUtil.getSession();
			Student s = (Student)session.get(Student.class, 2);
			System.out.println(s);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}
	@Test
	public void testUpdate(){
		Session session = null;
		try{
			session = SessionFactoryUtil.getSession();
			Student s = (Student)session.get(Student.class, 2);
			s.setName("小宁");
			Transaction tx = session.beginTransaction();
			session.update(s);
			tx.commit();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}
	@Test
	public void testDel(){
		Session session = null;
		try{
			session = SessionFactoryUtil.getSession();
			Student s = (Student)session.get(Student.class, 2);
			Transaction tx = session.beginTransaction();
			session.delete(s);
			tx.commit();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}
}
*/