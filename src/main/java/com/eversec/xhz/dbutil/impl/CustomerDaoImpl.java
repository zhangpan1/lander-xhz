/*package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.domain.Order;
import com.itheima.util.DBCPUtil;

public class CustomerDaoImpl implements CustomerDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void addCustomer(Customer c) {
		try {
			//保存客户的基本信息
			qr.update("insert into customers (id,name,address) values (?,?,?)", c.getId(),c.getName(),c.getAddress());
			//查看有没有订单，保存订单的信息
			List<Order> os = c.getOs();
			if(os.size()>0){
//			for(Order o:os){
//				qr.update("insert into orders (ordernum,amount,customerId) values (?,?,?)", o.getOrdernum(),o.getAmount(),c.getId());
//			}
				Object params[][] = new Object[os.size()][];
				for(int i=0;i<os.size();i++){
					Order o = os.get(i);
					params[i] = new Object[]{o.getOrdernum(),o.getAmount(),c.getId()};
				}
				qr.batch("insert into orders (ordernum,amount,customerId) values (?,?,?)", params);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//客户对应的订单要不要查？看需求
		//查询客户时，把订单查询出来，但订单中只有id的信息。延迟加载机制。懒
	public Customer findCustomer(int customerId) {
		//饿汉子：不懒的 lazy=false的
		try {
			Customer c = qr.query("select * from customers where id=?", new BeanHandler<Customer>(Customer.class), customerId);
			if(c!=null){
				//把定单查询出来
				List<Order> os = qr.query("select * from orders where customerId=?", new BeanListHandler<Order>(Order.class), customerId);
				c.setOs(os);
			}
			return c;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
*/