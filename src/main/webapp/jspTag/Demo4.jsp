<%-- <%@page import="cn.itcast.bean.User"%> --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Demo3.jsp' starting page</title>
    
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
  		<%-- <jsp:useBean id="u" scope="page" class="cn.itcast.bean.User" ></jsp:useBean> --%>
  		<jsp:setProperty property="name" name="u" param="name" />
  		
  		<jsp:getProperty property="name" name="u"/>
  		
  		<%--<%
  		User user = new User();
  		pageContext.setAttribute("u", user);
  		
  		((User)pageContext.getAttribute("u")).setName(request.getParameter("name"));
  		
  		out.print(((User)pageContext.getAttribute("u")).getName());
  		
  		%>
  		--%>
  	
  
  </body>
</html>
