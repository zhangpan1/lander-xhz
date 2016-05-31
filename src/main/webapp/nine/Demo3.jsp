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
    			//2 pageContext操作其他三个域
    			/* //存值
    			pageContext.setAttribute("name", "tom",PageContext.REQUEST_SCOPE );
    			//取值
    			pageContext.getAttribute("name", PageContext.REQUEST_SCOPE);
    			//删除一个值
    			pageContext.removeAttribute("name", PageContext.REQUEST_SCOPE);
    			//遍历所有键
    			pageContext.getAttributeNamesInScope(PageContext.REQUEST_SCOPE); */
//---------------------------------------------------------------------------    		
//---------------------------------------------------------------------------

    	 %>
    	 <%=request.getAttribute("name") %>
  </body>
</html>
