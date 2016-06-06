/*package com.eversec.zhangpan.crm;

import java.util.List;



public class BusinessServiceImpl implements BusinessService {
	private CustomerDao cDao = new CustomerDaoMySQLImpl();
	public List<Customer> findAllCustomers() {
		return cDao.findAll();
	}

	public void addCustomer(Customer c) {
		cDao.save(c);
	}

	public void deleteCustomer(Integer customerId) {
		cDao.del(customerId);
	}

	public void updateCustomer(Customer c) throws IdIsNullEmpty {
		if(c.getId()==0c.getId()==null)
			throw new IdIsNullEmpty("The customer's id can not be empty");
		cDao.update(c);
	}

	public Customer findCustomerById(Integer customerId) {
		return cDao.findOne(customerId);
	}

}
*/