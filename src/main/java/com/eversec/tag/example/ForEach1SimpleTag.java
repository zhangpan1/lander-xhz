package com.eversec.tag.example;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEach1SimpleTag extends SimpleTagSupport {
	private List items;
	private String var;//��
	public void setItems(List items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}
	public void doTag() throws JspException, IOException {
		if(items!=null){
			PageContext pc = (PageContext)getJspContext();
			for(Object obj:items){
				pc.setAttribute(var, obj);//�ѵ�ǰԪ�طŵ�ҳ�淶Χ
				getJspBody().invoke(null);//����������ִ��
			}
			pc.removeAttribute(var);
		}
	}
	
	
}
