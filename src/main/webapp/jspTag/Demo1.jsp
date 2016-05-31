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
    <jsp:forward page="/jspTag/Demo2.jsp">
   		 <jsp:param  name="name" value="tom" ></jsp:param>
    </jsp:forward>
    <%
    	request.getRequestDispatcher("").forward(request, response);
    	request.getParameterMap().put("name", new String[]{"tom"});
    %>
    
  	<%--<jsp:include page="/jspTag/Demo2.jsp">
  		
  	</jsp:include>
   <%
    	//request.getRequestDispatcher("").include(request, response);
    %>
    This is kakakaka~.
  --%></body>
</html>
