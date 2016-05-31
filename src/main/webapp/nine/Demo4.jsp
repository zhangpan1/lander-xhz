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
    			//3 pageContext可以用来获得其他8个内置对象
    			
    		pageContext.getRequest();
    		
    		pageContext.getResponse();
    		
    		pageContext.getSession();
    		
    		pageContext.getServletContext();
    		
    		pageContext.getServletConfig();
    		
    		pageContext.getOut();
    		
    		pageContext.getException();
    		
    		pageContext.getPage();

    	 %>
    	 <%=request.getAttribute("name") %>
  </body>
</html>
