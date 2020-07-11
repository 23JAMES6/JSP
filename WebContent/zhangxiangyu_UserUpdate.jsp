<%@page import="java.util.ArrayList"%>

<%@page import="zhangxiangyu.daoimpl.Daoimpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="zhangxiangyu.dao.Dao"%>
<%@ page language="java" import="java.util.List"%>
<%@ page language="java" import="zhangxiangyu.user.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>管理员进行修改的页面</h2>
	
	<%
		Dao zhangxiangyu_dao =new Daoimpl();
		List <User> zhangxiangyu_list =new ArrayList <User>();
		int zhangxiangyu_id=Integer.parseInt(request.getParameter("zhangxiangyu_id"));
		zhangxiangyu_list =zhangxiangyu_dao.zhangxiangyu_SelectId(zhangxiangyu_id);
		User zhangxiangyu_user =zhangxiangyu_list.get(0);
	%>
	<form action="UpdateUser?zhangxiangyu_id=<%=zhangxiangyu_user.getZhangxiangyu_id()%>" method="post">
	<table>
	<tr> <td>用户名</td>
		 <td> <input type="text" name="zhangxiangyu_username"  
		 value="<%=zhangxiangyu_user.getZhangxiangyu_username()%>"> </td>
	</tr>
	
	<tr> <td>密码</td>
		 <td> <input type="text" name="zhangxiangyu_password"  
		 value="<%=zhangxiangyu_user.getZhangxiangyu_password()%>"> </td>
	</tr>
	<tr> <td>用户类型</td>
		 <td> <input type="text" name="zhangxiangyu_type" 
		  value="<%=zhangxiangyu_user.getZhangxiangyu_type()%>"> </td>
		 <td> (只能填写‘管理员’或‘普通用户’)
	</tr>
	
	<tr> 
		 <td> <input type="submit" value="提交修改"> </td> 
	</tr>
	</table>
	</form>
</body>
</html>