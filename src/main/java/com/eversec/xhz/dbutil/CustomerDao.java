package com.eversec.xhz.dbutil;

import com.eversec.xhz.dbutil.impl.*;
import com.eversec.zhangpan.crm.Customer;

public interface CustomerDao {
	//
	void addCustomer(Customer c);
	//
	Customer findCustomer(int customerId);
}
