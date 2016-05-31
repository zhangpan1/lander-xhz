/*package com.zhangpan.servlet.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.sun.org.apache.commons.beanutils.Converter;

public class MyConverter implements Converter {

	public Object convert(Class arg0, Object arg1) {
		//xxx ==> OOO
		String birthdayStr = arg1.toString();//1990-01-01 ==> date
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			return format.parse(birthdayStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
*/