package com.eversec.tag.simpletag;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4SimpleTag extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
//		CharArrayWriter
		StringWriter sw = new StringWriter();//���л�����ַ������
		//��ȡ��������
		JspFragment jf = getJspBody();
		jf.invoke(sw);
		//��Ϊ��д���
		String str = sw.getBuffer().toString();
		str = str.toUpperCase();
		
		PageContext pc = (PageContext)getJspContext();
		pc.getOut().write(str);
	}
}
