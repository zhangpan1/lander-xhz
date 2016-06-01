package com.eversec.tag.example;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseSimpleTag extends SimpleTagSupport {
	private boolean flag;//��������
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null);
	}
	
}
