<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Demo1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   EL表达式 内置对象的操作
   	${} ==> el的格式
   
    <%
    request.setAttribute("name", "requestTom");
    session.setAttribute("name", "sessionTom");
    application.setAttribute("name", "applicationTom");
    //pageContext.setAttribute("name", "pageTom");
    	
     %>
   	${requestScope.name}==><% request.getAttribute("name"); %><br>
   	${sessionScope.name}==><% session.getAttribute("name"); %><br>
   	${applicationScope.name}==><% application.getAttribute("name"); %><br>
   	${pageScope.name}==><% pageContext.getAttribute("name"); %>EL表达式如果获得的值是null,那么什么都不打印.<br>
   	
   	${name}==><% pageContext.findAttribute("name");//从最小的域开始,找key为name的属性值 %>
   	<hr>
   	下面试试剩下7个内置对象  (不常用)
   			5.param 
			6.paramValues  这两个对象封装了表单参数
			7.header
			8.headerValues 这两个对象封装了HTTP请求头
			9.initParam 封装了web.xml中 配置
			10.pageContex 封装了 9大内置对象中的 pageContext
			11.cookie  封装了cookie信息
   	
   		${param.name } ==> <% request.getParameter("name"); %><br>
   		${paramValues.habit } ==> <% request.getParameterValues("habit"); %><br>
   		${header.Accept } ==> <%request.getHeader("Accept"); %><br>
   		${headerValues.Accept } ==> <%request.getHeaders("Accept"); %><br>
   		${initParam.name } ==> <% application.getInitParameter("name"); %><br>
   		${pageContext.request.contextPath } ==> <% ((HttpServletRequest)pageContext.getRequest()).getContextPath(); %><br>
 		${cookie.name.value } ==> <% 
 					Cookie c = new Cookie("name","jerry");
 					c.setMaxAge(60*60);
 					response.addCookie(c);
 		
 					for(Cookie cookie : request.getCookies()){
 						if(cookie.getName().equals("name")){
 						cookie.getPath();
 						}
 					}
 		 %>
  </body>
</html>
 --%>