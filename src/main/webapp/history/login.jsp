<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
//1.获得浏览器发送  过来的cookie

  Cookie[] cookies = request.getCookies();
//2.遍历找到保存的用户名
Cookie remeber = null;
  if (cookies != null && cookies.length>0) {
	  for (Cookie c : cookies) {
		
		  if (c.getName().equals("remeber")) {
			  remeber =c;
		  }
	  }
  }
//3.如果找到 取得它的值
//4.把值设置到用户名所在的input
%>
<body>
<form action="/lander-xhz/LoginSevlet" method="post">
用户面：<input type="text" name="name" value="<%=remeber==null?"":remeber %>"/><br/>
密码：<input type="password" name="password"/><br/>
记住用户名（一周）:<input type="checkbox" name="remeber" value="yes"/><br/>
<input type="submit" name="登陆"/><br/>


</form>
</body>
</html>