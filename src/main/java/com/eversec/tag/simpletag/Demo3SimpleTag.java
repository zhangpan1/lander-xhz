package com.eversec.tag.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo3SimpleTag extends SimpleTagSupport {

	
	private int count;//�����ͻ��Զ�ת��

	public void setCount(int count){
		this.count = count;
	}
	
	public void doTag() throws JspException, IOException {
		for(int i=0;i<count;i++){
			/*
			PageContext pc = (PageContext)getJspContext();
			JspWriter out = pc.getOut();
			//��ȡ��������
			JspFragment jf = getJspBody();
			jf.invoke(out);
			*/
			getJspBody().invoke(null);
		}
	}
}
