package com.eversec.zhangpan.crm;

import java.util.List;



public interface CustomerDao {

	List<Customer> findAll();

	void save(Customer c);

	void del(Integer customerId);

	void update(Customer c);

	Customer findOne(Integer customerId);

}
