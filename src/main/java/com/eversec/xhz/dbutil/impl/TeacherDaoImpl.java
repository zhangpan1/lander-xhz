/*package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.dao.TeacherDao;
import com.itheima.domain.Student;
import com.itheima.domain.Teacher;
import com.itheima.util.DBCPUtil;

public class TeacherDaoImpl implements TeacherDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void addTeacher(Teacher t) {
		try {
			//保存老师的基本信息
			qr.update("insert into teachers(id,name,salary) values (?,?,?)", t.getId(),t.getName(),t.getSalary());
			//看看老师有没有关联的学员：
			List<Student> students = t.getStudents();
			if(students.size()>0){
				//遍历学员：
				for(Student s:students){
						//看看学员信息数据库有没有
					Object obj = qr.query("select id from students where id=?", new ScalarHandler(1), s.getId());
					if(obj==null){
						//没有：插入学员的基本信息
						qr.update("insert into students(id,name,grade) values (?,?,?)",s.getId(),s.getName(),s.getGrade());
					}
					//插入关系
					qr.update("insert into teachers_students(t_id,s_id) values (?,?)", t.getId(),s.getId());
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Teacher findTeacher(int teacherId) {
		try {
			Teacher t = qr.query("select * from teachers where id=?", new BeanHandler<Teacher>(Teacher.class), teacherId);
			if(t!=null){
				//去查教过哪些学员
//				String sql = "select * from students where id in (select s_id from teachers_students where t_id=?)";
//				String sql = "select s.* from students s,teachers_students ts where s.id=ts.s_id and ts.t_id=?";
				String sql = "select s.* from students s inner join teachers_students ts on s.id=ts.s_id where ts.t_id=? ";
				List<Student> students = qr.query(sql, new BeanListHandler<Student>(Student.class), teacherId);
				t.setStudents(students);
			}
			
			return t;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
*/