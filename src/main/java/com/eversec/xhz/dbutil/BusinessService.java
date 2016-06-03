package com.eversec.xhz.dbutil;

public interface BusinessService {
	/**
	 * 转账
	 * @param sourceAccountName 转出账户
	 * @param targetAccountName 转入账户
	 * @param money 涉及金额
	 */
	void transfer(String sourceAccountName,String targetAccountName,float money);//转账
}
