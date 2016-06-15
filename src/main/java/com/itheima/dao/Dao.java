package com.itheima.dao;

import java.io.Serializable;

public interface Dao<T> {
	void add(T t);
	void update(T t);
	/**
	 * 根据主键查询一个对象
	 * @param id
	 * @return
	 */
	T findOne(Serializable id);
	/**
	 * 根据主键删除一个对象
	 * @param id
	 */
	void del(Serializable id);
}
