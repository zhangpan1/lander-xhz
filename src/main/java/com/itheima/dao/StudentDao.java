package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Student;

public interface StudentDao extends Dao<Student>{
	List<Student> findAll();
}
