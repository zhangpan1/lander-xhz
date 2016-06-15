/*package com.itheima.test;

import java.util.Date;

import com.itheima.dao.CustomerDao;
import com.itheima.dao.StudentDao;
import com.itheima.dao.impl.CustomerDaoImpl;
import com.itheima.dao.impl.StudentDaoImpl;
import com.itheima.domain.Customer;
import com.itheima.domain.Student;

public class DaoTest {
	public static void main(String[] args) {
//		CustomerDao cDao = new CustomerDaoImpl(Customer.class);
//		StudentDao sDao = new StudentDaoImpl(Student.class);
//		Customer c = new Customer();
//		c.setName("刘亚雄");
//		c.setGender("待定");
//		cDao.add(c);
//		
//		Student s = new Student();
//		s.setName("吕云雪");
//		s.setBirthday(new Date());
//		sDao.add(s);
		
		CustomerDao cDao = new CustomerDaoImpl();
		StudentDao sDao = new StudentDaoImpl();
//		Customer c = cDao.findOne(1);
//		System.out.println(c);
		Student s = sDao.findOne(3);
		System.out.println(s);
	}
}
*/