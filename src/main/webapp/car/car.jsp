<%@page import="java.util.Map.Entry"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  	//1 获得session
  	//2 从session中取出购物车的map
  	Map<String,Integer> map = (Map<String,Integer>)session.getAttribute("car");
  
  %>
  
  
  <body>
   	<h1 align="center" >购物车详情</h1>
   	<table border="1" align="center" >
   		<tr><th>商品名称</th><th>商品数量</th></tr>
   		<%
  	//3 遍历显示
   			if(map!=null && map.size()>0){
   				for(Entry<String,Integer> en : map.entrySet()){
   					%>
   					<tr><td><%=en.getKey() %></td><td><%=en.getValue() %></td></tr>	
   					
   					<% 
   				}
   			}else {
   				out.print("您还没有添加任何商品!!");
   			}
   		%>
   	</table>
  </body>
</html>
