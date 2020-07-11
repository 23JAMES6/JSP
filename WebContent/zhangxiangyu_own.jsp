<%@page import="java.util.ArrayList"%>
<%@page import="zhangxiangyu.daoimpl.Daoimpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="zhangxiangyu.dao.Dao"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ page language="java" import="java.util.List"%>
<%@ page language="java" import="zhangxiangyu.user.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>个人信息管理页面</h3>
	<%
	int zhangxiangyu_id =Integer.parseInt(request.getParameter("zhangxiangyu_id"));
	Dao zhangxiangyu_dao =new Daoimpl();
	List <User> zhangxiangyu_list =new ArrayList<User>();
	zhangxiangyu_list =zhangxiangyu_dao.zhangxiangyu_SelectId(zhangxiangyu_id);
	HttpSession zhangxiangyu_type =request.getSession();
	zhangxiangyu_type.setAttribute("zhangxiangyu_type", zhangxiangyu_list.get(0).getZhangxiangyu_type());
	%>
	<form action="UpdateOwn?zhangxiangyu_id=<%=zhangxiangyu_list.get(0).getZhangxiangyu_id() %>" method="post">
	<table>
	<tr> <td>用户名</td>     
	     <td> <input type="text" name="zhangxiangyu_username"  value="<%=zhangxiangyu_list.get(0).getZhangxiangyu_username()  %>"> </td>
	</tr>
	
	<tr> <td>密码</td>     
	     <td> <input type="text" name="zhangxiangyu_password" value="<%=zhangxiangyu_list.get(0).getZhangxiangyu_password()  %>"> </td>
	</tr>
	
	<tr> <td>权限</td>     
	     <td> <%=zhangxiangyu_list.get(0).getZhangxiangyu_type() %>
	</tr>
	
	<tr> <td> <input type="submit" value="修改"></td>     
	</tr>
	</table>
	</form>
</body>
</html>