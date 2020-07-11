<%@page import="java.util.ArrayList"%>
<%@page import="zhangxiangyu.daoimpl.NewsDaoimpl"%>
<%@page import="zhangxiangyu.daoimpl.Daoimpl"%>
<%@page import="zhangxiangyu.dao.NewsDao"%>
<%@page import="zhangxiangyu.news.News"%>
<%@ page language="java" import="java.util.Iterator"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ page language="java" import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>管理员对新闻进行管理</h2>
	<%
	NewsDao zhangxiangyu_dao =new NewsDaoimpl();
	List <News> zhangxiangyu_news =new ArrayList<News> ();
	zhangxiangyu_news=zhangxiangyu_dao.zhangxiangyu_SelectAll();
	Iterator <News> zhangxiangyu_ite =zhangxiangyu_news.iterator();
	News zhangxiangyu_n =new News();
	%>
	<table border="1">
	<tr> <th>标题</th>  <th>作者</th>  <th>内容</th>  </tr>
	<% 
	while(zhangxiangyu_ite.hasNext())
	{
		zhangxiangyu_n=zhangxiangyu_ite.next();
	%>
		<tr> 
		<td> <%=zhangxiangyu_n.getZhangxiangyu_title()%> </td>
		<td> <%=zhangxiangyu_n.getZhangxiangyu_author()%> </td>
		<td> <%=zhangxiangyu_n.getZhangxiangyu_content()%> </td>
		<td> <a href="zhangxiangyu_newsupdate.jsp?zhangxiangyu_id=<%=zhangxiangyu_n.getZhangxiangyu_id()%>">修改</a> </td>
		<td> <a href="NewsDelete?zhangxiangyu_id=<%=zhangxiangyu_n.getZhangxiangyu_id() %>">删除</a> </td>
		</tr>
	<% 
	}
	%>
	</table>
	<br>
	<a href="zhangxiangyu_AddNews.jsp">添加新闻</a>
</body>
</html>