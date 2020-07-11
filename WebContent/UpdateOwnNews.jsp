<%@page import="zhangxiangyu.daoimpl.Daoimpl"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="zhangxiangyu.daoimpl.NewsDaoimpl"%>
<%@page import="zhangxiangyu.dao.NewsDao"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ page language="java" import="java.util.List"%>
<%@ page language="java" import="zhangxiangyu.news.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>新闻修改</h2>
	<%
	List <News> zhangxiangyu_list =new ArrayList <News>();
	NewsDao zhangxiangyu_dao =new NewsDaoimpl();
	int zhangxiangyu_id =Integer.parseInt(request.getParameter("zhangxiangyu_id"));
	zhangxiangyu_list=zhangxiangyu_dao.zhangxiangyu_SelectId(zhangxiangyu_id);
	
	%>
<form action="UpdateOwnNews?zhangxiangyu_id=<%=zhangxiangyu_list.get(0).getZhangxiangyu_id() %>" method="post">
<table>
<tr> 
<td>标题</td>
<td> <input type="text" name="zhangxiangyu_title" value="<%=zhangxiangyu_list.get(0).getZhangxiangyu_title()%>"> </td>
</tr>
<tr> 
<td>作者</td>
<td> <%=zhangxiangyu_list.get(0).getZhangxiangyu_author() %> </td>
</tr>
<tr> 
<td>内容</td>
<td> <input type="text" name="zhangxiangyu_content" value="<%=zhangxiangyu_list.get(0).getZhangxiangyu_content()%>"> </td>
</tr>
<tr> 
<td> <input type="submit" value="修改"> </td>
</tr>
</table>
</form>
</body>
</html>