package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Customer;

public interface CustomerDao extends Dao<Customer>{
	List<Customer> findPageCustomer(int startIndex,int size);
}
