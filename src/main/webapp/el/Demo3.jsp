<%-- <%@page import="cn.itcast.bean.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  	<%
  		request.setAttribute("num1", 10);
  		request.setAttribute("num2", 20);
  		//EL表达式支持如下运算符.
  	 %>
  
  		${num1 > num2} ==>${num1 gt num2}<br>
  		${num1 < num2} ==>${num1 lt num2}<br>
  		${num1 <= num2}==>${num1 le num2} <br>
  		${num1 >= num2}==>${num1 ge num2} <br>
  		${num1 == num2}==>${num1 eq num2} <br>
  		${num1 != num2}==>${num1 ne num2} <br>
  		${true && true}<br>
  		${true || true}<br>
  		${!true}<br>
  		${(num1 > num2)?"num1厉害":"老2厉害" }
  </body> 
</html>
 --%>