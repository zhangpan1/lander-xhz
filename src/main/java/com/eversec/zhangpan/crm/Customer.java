package com.eversec.zhangpan.crm;

import java.io.Serializable;
/*
 * id int primary key auto_increment,
 * name varchar(100) not null
 * gender varchar(100) not null
 * birthday date not null
 * cellphone varchar(100) not null,
 * email varchar(100) not null
 * hobby varchar(100) not null,#eat,sleep,study
 * type varchar(100) not null,
 * description varchar(255)not null
 */
import java.sql.Date;
	
public class Customer implements Serializable {
	private Integer id;
	private String name;
	private String gender;
	private Date birthday;
	private String cellphone;
	private String email;
	private String hobby;
	private String type;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date date) {
		this.birthday = date;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
