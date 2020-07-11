<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>注册页面</h2>
	<form action="RegisterServlet" method="get">
	<table>
	<tr> <td>用户名</td>
	     <td> <input type="text" name="zhangxiangyu_username"> </td>
	</tr>
	<tr> <td>密码</td>
	     <td> <input type="password" name="zhangxiangyu_password"> </td>
	</tr>
	<tr> <td>用户类型</td>
	     <td> <input type="radio" name="zhangxiangyu_type" value="普通用户">普通用户 
	     	  <input type="radio" name="zhangxiangyu_type" value="管理员">管理员

	     </td>
	</tr>
	<tr> <td> <input type="submit" value="注册">  </td>
	     <td> <input type="reset" > </td>
	</tr>
	
	</table>
	
	
	
	</form>
</body>
</html>