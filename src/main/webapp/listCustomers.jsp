<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户信息列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.odd{
			background-color: #c3f3c3;
		}
		.even{
			background-color: #f3c3f3;
		}
	</style>
  </head>
  
  <body style="font-size: 12px">
  	<table width="88%">
  		<tr>
  			<td>
  				<a href="${pageContext.request.contextPath}/addCustomer.jsp">添加</a>
  				<a href="">删除</a>
  			</td>
  		</tr>
  		<tr>
  			<td>
	  			<c:if test="${empty cs }">
			    	没有客户信息
			    </c:if>
			    <c:if test="${!empty cs }">
			    	<h1>客户信息列表</h1>
			    	<table border="1" width="100%">
			    		<tr>
			    			<th nowrap="nowrap">选择</th>
			    			<th nowrap="nowrap">姓名</th>
			    			<th nowrap="nowrap">性别</th>
			    			<th nowrap="nowrap">生日</th>
			    			<th nowrap="nowrap">电话</th>
			    			<th nowrap="nowrap">邮箱</th>
			    			<th nowrap="nowrap">爱好</th>
			    			<th nowrap="nowrap">类型</th>
			    			<th nowrap="nowrap">描述</th>
			    			<th nowrap="nowrap">操作</th>
			    		</tr>
			    		<c:forEach items="${cs}" var="c" varStatus="vs">
			    			<tr class="${vs.index%2==0?'odd':'even' }">
				    			<td nowrap="nowrap">
				    				<input type="checkbox" name="ids" value="${c.id}">
				    			</td>
				    			<td nowrap="nowrap">${c.name}${c.gender }</td>
				    			<td nowrap="nowrap">${c.gender=='male'?'帅哥':'美女'}</td>
				    			<td nowrap="nowrap">${c.birthday}</td>
				    			<td nowrap="nowrap">${c.cellphone}</td>
				    			<td nowrap="nowrap">${c.email }</td>
				    			<td nowrap="nowrap">${c.hobby }</td>
				    			<td nowrap="nowrap">${c.type }</td>
				    			<td nowrap="nowrap">${c.description }</td>
				    			<td nowrap="nowrap">
				    				[<a href="">修改</a>]
				    				[<a href="">删除</a>]
				    			</td>
				    		</tr>
			    		</c:forEach>
			    	</table>
			    </c:if>
  			</td>
  		</tr>
    </table>
  </body>
</html>
