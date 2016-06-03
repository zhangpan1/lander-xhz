/*package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.dao.PersonDao;
import com.itheima.domain.IdCard;
import com.itheima.domain.Order;
import com.itheima.domain.Person;
import com.itheima.util.DBCPUtil;

public class PersonDaoImpl implements PersonDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void savePerson(Person p) {
		try {
			qr.update("insert into person (id,name,birthday) values (?,?,?)", p.getId(),p.getName(),p.getBirthday());
			IdCard idcard = p.getIdCard();
			if(idcard!=null){
				qr.update("insert into idcard (id,num) values (?,?)", p.getId(),idcard.getNum());
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Person findPerson(int personId) {
		try {
			Person p = qr.query("select * from person where id=?",new BeanHandler<Person>(Person.class), personId);
			if(p!=null){
				IdCard idCard = qr.query("select * from idcard where id=?",new BeanHandler<IdCard>(IdCard.class), personId);
				p.setIdCard(idCard);
			}
			return p;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
*/