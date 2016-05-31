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
  	
  		使用EL访问User对象
  	
  	 <%
  	 	User u = new User();
  	 	u.setName("tom");
  	 	request.setAttribute("user", u);
  	  %>
  	  ${requestScope.user.name}==><%((User)request.getAttribute("user")).getName(); %><br>
  	  ${requestScope.user['name']}==><%((User)request.getAttribute("user")).getName(); %><br>	
  	<%
  		String[] array = new String[]{"tom","jerry","jack","rose"};
  		request.setAttribute("array", array);
  	 %>
  	  ${requestScope.array[2]} <br>
  	  <%
  	  		List<String> list = new ArrayList<String>();
  	  		list.add("jack");
  	  		list.add("rose");
  	  		request.setAttribute("list", list);
  	   %>
  	   ${requestScope.list[1]}<br>
  	   <%
  	   		Map<String,String> map = new HashMap<String,String>();
  	   		map.put("birthday", "now");
  	   		map.put("haha.heihei", "hiahia");
  	   		request.setAttribute("map", map);
  	    %>
  	    ${requestScope.map.birthday}<br>
  	    ${requestScope.map['birthday']}<br>
  	    ${requestScope.map['haha.heihei']}<br>
  	   
  	   
  </body>
</html>
 --%>