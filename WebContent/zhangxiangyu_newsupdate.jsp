<%@page import="zhangxiangyu.daoimpl.NewsDaoimpl"%>
<%@page import="zhangxiangyu.dao.NewsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.Iterator"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ page language="java" import="java.util.List"%>
<%@ page language="java" import="zhangxiangyu.conn.Conn"%>
<%@ page language="java" import="zhangxiangyu.news.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>修改新闻页面</h2>
	<% int zhangxiangyu_id =Integer.parseInt(request.getParameter("zhangxiangyu_id"));   
	   NewsDao zhangxiangyu_dao =new NewsDaoimpl();
	   List <News> zhangxiangyu_list =new  ArrayList <News>();
	   zhangxiangyu_list =zhangxiangyu_dao.zhangxiangyu_SelectId(zhangxiangyu_id);
	   Iterator <News> zhangxiangyu_ite =zhangxiangyu_list.iterator();
	   News zhangxiangyu_news =new News();
	   
	   while(zhangxiangyu_ite.hasNext()){
		   zhangxiangyu_news=zhangxiangyu_ite.next();
     %>
		   <form action="NewsUpdate?zhangxiangyu_id=<%=zhangxiangyu_news.getZhangxiangyu_id() %>" method="post">
		   <table>
		   <tr> <td>标题</td>
		   	    <td> <input type="text" name="zhangxiangyu_title" value="<%=zhangxiangyu_news.getZhangxiangyu_title()%>">
		   	    </td>
		   </tr>
		   <tr> <td>作者</td>
		   	    <td> <input type="text" name="zhangxiangyu_author" value="<%=zhangxiangyu_news.getZhangxiangyu_author()%>">
		   	    </td>
		   </tr>
		   <tr> <td>内容</td>
		   	    <td> <input type="text" name="zhangxiangyu_content" value="<%=zhangxiangyu_news.getZhangxiangyu_content()%>">
		   	    </td>
		   </tr>
		   <tr>
		       <td>  <input type="submit" value="修改">  </td>
		   </tr>
    <% 
	   }
	%>
	 </table>
     </form>
</body>
</html>