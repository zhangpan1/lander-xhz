/*package com.itheima.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.dao.Dao;
import com.itheima.util.SessionFactoryUtil;

public abstract class BaseDao<T> implements Dao<T> {

	private Class clazz;//实体类型
	public BaseDao(){
		//给clazz赋值：需要知道操作的是哪个实体类，从而知道操作那张表
		Type type = this.getClass().getGenericSuperclass();//得到当前实例的带有泛型类型的父类
		ParameterizedType ptype = (ParameterizedType)type;//因为父类型带有泛型信息，就可以转为ParameterizedType（参数化的泛型类型）
		clazz = (Class)ptype.getActualTypeArguments()[0];// Customer|Student.class
	}
	
	public void add(T t) {
		Session session = null;
		try{
			session = SessionFactoryUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(t);
			tx.commit();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}
	public T findOne(Serializable id) {
		Session session = null;
		try{
			session = SessionFactoryUtil.getSession();
			return (T)session.get(clazz, id);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}
	public void update(T t) {
		Session session = null;
		try{
			session = SessionFactoryUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.update(t);
			tx.commit();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}

	

	public void del(Serializable id) {
		Session session = null;
		try{
			session = SessionFactoryUtil.getSession();
			Transaction tx = session.beginTransaction();
			T bean = (T)session.get(clazz, id);
			session.delete(bean);
			tx.commit();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}

}
*/