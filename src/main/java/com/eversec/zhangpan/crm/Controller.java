/*package com.eversec.zhangpan.crm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;



public class Controller extends HttpServlet {
	private BusinessService s = new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String encoding = "UTF-8";
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		String op = request.getParameter("op");
		if("showAllCustomers".equals(op)){
			showAllCustomers(request,response);
		}else if("addCustomer".equals(op)){
			addCustomer(request,response);
		}
	}
	//添加新客户
	private void addCustomer(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		//封装数据到FormBean
		CustomerFormBean formBean = FillBeanUtil.fillBean(request, CustomerFormBean.class);
		//验证：略
		if(!formBean.validate()){
			//回显
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/addCustomer.jsp").forward(request, response);
			return;
		}
		//填充模型:生日的类型不匹配；爱好也不匹配
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Customer c = new Customer();
		try {
			BeanUtils.copyProperties(c, formBean);
		} catch (Exception e) {
			response.getWriter().write("服务器忙");
			return;
		}
		//单独处理爱好
		String hobbies[] = formBean.getHobbies();
		if(hobbies!=null&&hobbies.length>0){
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<hobbies.length;i++){
				if(i>0){
					sb.append(",");
				}
				sb.append(hobbies[i]);
			}
			c.setHobby(sb.toString());
		}
		//保存数据
		s.addCustomer(c);
		//Redirect After Post
		response.sendRedirect(request.getContextPath());
	}
	//查询所有的客户信息
	private void showAllCustomers(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		List<Customer> cs = s.findAllCustomers();
		request.setAttribute("cs", cs);
		request.getRequestDispatcher("/listCustomers.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
*/