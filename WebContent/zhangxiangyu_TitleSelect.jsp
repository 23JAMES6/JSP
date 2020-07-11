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
	<h2>这里是标题模糊查询</h2>
	<%
	NewsDao zhangxiangyu_dao =new NewsDaoimpl();
	List <News> zhangxiangyu_list =new ArrayList <News>();
	String zhangxiangyu_word =request.getParameter("zhangxiangyu_title");
	out.print(zhangxiangyu_word);
	zhangxiangyu_list =  zhangxiangyu_dao.zhangxiangyu_Select(zhangxiangyu_word);
	out.print(zhangxiangyu_list.size());
	Iterator <News> zhangxiangyu_ite =zhangxiangyu_list.iterator();
	%>
	
</body>
</html>