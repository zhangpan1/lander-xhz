package com.eversec.tag.example;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEach2SimpleTag extends SimpleTagSupport {
	private Object items;
	private String var;//��
	
	private Collection collection = new ArrayList();
	
	public void setItems(Object items) {
		//��items�е���ݸ㵽collection
		if(items instanceof List){
			collection = (List)items;
		}else if(items instanceof Set){
			collection = (Set)items;
		}else if(items instanceof Map){
			collection = ((Map)items).entrySet();//Map.Entry
//		}else if(items instanceof Object[]){//�������͵�����
//			collection = Arrays.asList((Object[])items);
//		}else{
		}else if(items.getClass().isArray()){//����
			//����ķ���
			int length = Array.getLength(items);
			for(int i=0;i<length;i++){
				collection.add(Array.get(items, i));
			}
		}else{
			throw new RuntimeException("��֧�ֵ�����");
		}
	}
	public void setVar(String var) {
		this.var = var;
	}
	public void doTag() throws JspException, IOException {
		PageContext pc = (PageContext)getJspContext();
		for(Object obj:collection){
			pc.setAttribute(var, obj);//�ѵ�ǰԪ�طŵ�ҳ�淶Χ
			getJspBody().invoke(null);//����������ִ��
		}
		pc.removeAttribute(var);
	}
	
	
}
