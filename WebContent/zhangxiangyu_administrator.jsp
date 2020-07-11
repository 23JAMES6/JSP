<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>管理员页面</h2>
	<%
	String zhangxiangyu_s =(String) session.getAttribute("zhangxiangyu_username");
	out.println("欢迎"+zhangxiangyu_s+"登录");
	%>
   	<h3> <a href="zhangxiangyu_AllUser.jsp">用户管理</a>     </h3>
    <h3> <a href="zhangxiangyu_NewsSelect.jsp">新闻管理</a>     </h3>
</body>
</html>