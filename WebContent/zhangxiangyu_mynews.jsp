<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="zhangxiangyu.daoimpl.NewsDaoimpl"%>
<%@page import="zhangxiangyu.dao.NewsDao"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ page language="java" import="java.util.List"%>
<%@ page language="java" import="zhangxiangyu.news.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>我的新闻</h2>
	<%
	String zhangxiangyu_author =(String)session.getAttribute("zhangxiangyu_username");
	List <News> zhangxiangyu_news =new ArrayList<News> ();
	NewsDao zhangxiangyu_dao =new NewsDaoimpl();
	zhangxiangyu_news= zhangxiangyu_dao.zhangxiangyu_SelectOwn(zhangxiangyu_author);
	News zhangxiangyu_n =new News();
	if(zhangxiangyu_news.size()==0)
	{
		out.print("您没有发布的新闻");
	}
	else{
		Iterator <News> zhangxiangyu_ite =zhangxiangyu_news.iterator();
	%>
		<table border="1">
		<tr> <th>标题</th>  <th>作者</th>  <th>内容</th>
		<%
		while(zhangxiangyu_ite.hasNext())
		{
			zhangxiangyu_n=zhangxiangyu_ite.next();
		%>
		<tr>
		<td> <%=zhangxiangyu_n.getZhangxiangyu_title() %> </td>
		<td> <%=zhangxiangyu_n.getZhangxiangyu_author() %></td>
		<td> <%=zhangxiangyu_n.getZhangxiangyu_content() %></td>
		<td> <a href="UpdateOwnNews.jsp?zhangxiangyu_id=<%=zhangxiangyu_n.getZhangxiangyu_id() %>">修改</a> </td>
		<td> <a href="DeleteOwnNews?zhangxiangyu_id=<%=zhangxiangyu_n.getZhangxiangyu_id() %>">删除</a> </td>
		</tr>
		<% 
		}
		%>
		</table>
		<% 	
	}
	%>
	<%
	HttpSession zhangxiangyu_session=request.getSession();
	zhangxiangyu_session.setAttribute("zhangxiangyu_author",request.getParameter("zhangxiangyu_author"));
	%>
	<br>
	<br>
	<a href="zhangxiangyu_AddMyNews.jsp">添加新闻</a>
</body>
</html>