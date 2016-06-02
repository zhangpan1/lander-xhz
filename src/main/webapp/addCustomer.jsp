<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加新客户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/servlet/Controller?op=addCustomer" method="post">
    	<table border="1" width="438">
    		<tr>
    			<td>姓名：</td>
    			<td>
    				<input name="name"/>
    			</td>
    		</tr>
    		<tr>
    			<td>性别：</td>
    			<td>
    				<input type="radio" name="gender" value="male" checked="checked"/>男性
    				<input type="radio" name="gender" value="female"/>女性
    			</td>
    		</tr>
    		<tr>
    			<td>生日yyyy-MM-dd：</td>
    			<td>
    				<input name="birthday"/>
    			</td>
    		</tr>
    		<tr>
    			<td>电话：</td>
    			<td>
    				<input name="cellphone"/>
    			</td>
    		</tr>
    		<tr>
    			<td>邮箱：</td>
    			<td>
    				<input name="email"/>
    			</td>
    		</tr>
    		<tr>
    			<td>爱好：</td>
    			<td>
    				<input type="checkbox" name="hobbies" value="吃饭"/>吃饭
    				<input type="checkbox" name="hobbies" value="睡觉"/>睡觉
    				<input type="checkbox" name="hobbies" value="学java"/>学java
    			</td>
    		</tr>
    		<tr>
    			<td>类型：</td>
    			<td>
    				<input type="radio" name="type" value="VIP" checked="checked"/>VIP
    				<input type="radio" name="type" value="VVIP"/>VVIP
    			</td>
    		</tr>
    		<tr>
    			<td>描述：</td>
    			<td>
    				<textarea rows="3" cols="38" name="description"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="保存"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
