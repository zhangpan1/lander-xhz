package com.eversec.login.mvc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import com.thoughtworks.xstream.XStream;

public class XStreamDemo1 {
	@Test
	public void test1(){
		List<Province> provinces = new ArrayList<Province>();
		Province sd = new Province(37, "山东省");
		Province hb = new Province(42, "湖北省");
		Province hn = new Province(41, "河南省");
		
		sd.getCitys().add(new City(01, "济南市"));
		sd.getCitys().add(new City(02, "青岛市"));
		sd.getCitys().add(new City(03, "淄博市"));
		
		hb.getCitys().add(new City(01, "武汉市"));
		hb.getCitys().add(new City(02, "黄冈市"));
		hb.getCitys().add(new City(03, "襄阳市"));
		
		hn.getCitys().add(new City(01, "郑州市"));
		hn.getCitys().add(new City(02, "开封市"));
		hn.getCitys().add(new City(03, "洛阳市"));
		
		provinces.add(sd);
		provinces.add(hb);
		provinces.add(hn);
		
		XStream xs = new XStream();
		xs.autodetectAnnotations(true);//使用注解生成别名
		xs.alias("provinces", List.class);
		String xml = xs.toXML(provinces);
		System.out.println(xml);
	}
}
