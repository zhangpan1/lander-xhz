package com.eversec.xhz.dbutil;

public interface AccountDao {
	void transfer(String sourceAccountName,String targetAccountName,float money);
}
