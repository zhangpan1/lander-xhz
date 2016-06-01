package com.eversec.tag.simpletag;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//��ʾ�����ߵ�IP
public class ShowCurrentTimeSimpleTag extends SimpleTagSupport {
	
//	private JspContext jc;
	
	//�ɷ��������ã����ڵ���doTag֮ǰ���á���PageContext����ע�����
//	public void setJspContext(JspContext jc) {
//		this.jc = jc;
//	}

	// �ɷ��������ã�����ִ�б�ǩ
	public void doTag() throws JspException, IOException {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = df.format(now);
		
		PageContext pc = (PageContext)getJspContext();
		
		pc.getOut().write(str);
	}

}
