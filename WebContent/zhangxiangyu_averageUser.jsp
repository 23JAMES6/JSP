<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>普通用户页面</h2>
	<%
	String zhangxiangyu_s=(String) session.getAttribute("zhangxiangyu_username");
	out.print("欢迎"+zhangxiangyu_s+"登录");
	%>
	<br>
	<br>
	<h3> <a href="zhangxiangyu_own.jsp?zhangxiangyu_id=<%=(int)session.getAttribute("zhangxiangyu_id")%>">个人信息管理</a>   </h3>
	<h3> <a href="zhangxiangyu_mynews.jsp">新闻管理</a> </h3>
</body>
</html>