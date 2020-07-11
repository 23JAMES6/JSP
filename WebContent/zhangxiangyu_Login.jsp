<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>登录</h2>
	<form action="LoginServlet" method="get">
	<table>
	<tr> <td>用户名</td>
	     <td> <input type="text" name="zhangxiangyu_username"> </td>
	</tr>
	<tr> <td>密码</td>
	     <td> <input type="password" name="zhangxiangyu_password"> </td>
	</tr>
	<tr> <td>用户类型</td>
	     <td> <select name="zhangxiangyu_select">
	     	  <option>普通用户</option>
	     	  <option>管理员</option>
	         </select> 
	    </td>
	</tr>
	<tr> <td> <input type="submit" value="登录"> </td>
	     <td> <input type="reset"> </td>
	</tr>
	
	</table>
	
	
	
	</form>
</body>
</html>