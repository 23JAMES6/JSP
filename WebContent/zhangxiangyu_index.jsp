<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<title>主页</title>
</head>
<style type="text/css"> 
#container{
	width: 1000px;
	margin: 0 auto;
}
#header{
		
	height: 305px;
	background-image: url("图片3.png");
	}
#nav{
	height: 60px;
    border:1px solid #EEE;
}
ul{
	margin: 0px;
	padding: 0px;
}
li{
	list-style: none;
}

#nav li{
 list-style: none;
 float:left;
 width: 123px;	
 height: 60px;
 border-right: 1px solid #CCC;
 text-align: center;
 line-height: 60px;
 background-color: #FF9933;
 margin:0px;
}
#main{
	height: 1000px;
}
.one{
	height: 300px;
	border:1px dashed #CCC;
}
.one ul{
    margin-left:100px;
}
.one li{
line-height: 30px;
}
#footer{		
height: 100px;
	}
a{
	text-decoration: none;
}
.td1{
	width: 100px;
}
td{
	padding-left:30px;
	height: 30px;
}
tr{
	
	height: 30px;
}
.ima{
	margin-top: 60px;
	margin-left: 30px;
    width: 300px;
	float:left;
}
</style>
<body>
<div id="container">
     <div id="header">
		 
     </div>
   <div id="nav">
	<ul>
	<li> <a href="zhangxiangyu_Login.jsp">登录</a>        </li>
	<li> <a href="zhangxiangyu_register.jsp">注册</a>     </li>
	<li> <a href="zhangxiangyu_Fuzzyquery.jsp">模糊查询 </a></li>
	<li>娱乐新闻</li>
    <li>国外信息</li>
	<li>好莱坞</li>
	<li>NBA</li>
	<li>关于我们</li>		
    </ul>
   </div>
<div id="main">
    
    <div class="one">
    	 <h3>热点新闻</h3> 
    	<%
Connection conn = null;
ResultSet rsAll = null;
PreparedStatement stmt = null;
try {
//--开始创建连接--
Class.forName("org.gjt.mm.mysql.Driver");
String strConn = "jdbc:mysql://localhost:3306/jsp";
conn = DriverManager.getConnection(strConn, "root","zxy54321");
//--开始查询所有数据--
request.setCharacterEncoding("gb18030");
String strSql = "select title,author,content from news";
stmt = conn.prepareStatement(strSql,
ResultSet.TYPE_SCROLL_SENSITIVE,
ResultSet.CONCUR_READ_ONLY);
rsAll = stmt.executeQuery();
%>
<!--输出表格头-->
<table width="80%" border=1 cellspacing="0" align="center">
<tr>
<td><font size="2" color="#0000FF">标题</font></td>
<td><font size="2" color="#0000FF">作者</font></td>
<td><font size="2" color="#0000FF">内容</font></td>
</tr>



<%
String str = (String) request.getParameter("page");
if (str == null) { 
     str = "0";
}
int pagesize = 3;//页面大小
rsAll.last();//将指针指向最后一行
int recordCount = rsAll.getRow();//获取此时所在的行数 ，就是总行数
int maxPage = 0;//最大页数
maxPage = (recordCount % pagesize == 0) ? (recordCount / pagesize)
: (recordCount / pagesize + 1);//总页数
int currentPage = Integer.parseInt(str);//当前页
if (currentPage < 1) {//处理特殊当前页号
    currentPage = 1;
} else {
    if (currentPage > maxPage) {
         currentPage = maxPage;
    }
}
//--读取当前页的信息并输出--
rsAll.absolute((currentPage - 1) * pagesize + 1);//定位记录指针位置
for (int i = 1; i <= pagesize; i++) {
%>
<tr>
<td><font size="2"><%=rsAll.getString("title")%></font></td>
<td><font size="2"><%=rsAll.getString("author")%></font></td>
<td><font size="2"><%=rsAll.getString("content")%></font></td>
</tr>
<%
   if (!rsAll.next()) {//移动记录指针并判断数据是否读完
        break;
      }
}
%>
</table>
当前页数：[<%=currentPage%>/<%=maxPage%>]&nbsp;
<%
//--显示页面导航--
if (currentPage > 1) {
%>
     <a href="zhangxiangyu_index.jsp?page=1">第一页</a> 
     <a href="zhangxiangyu_index.jsp?page=<%=currentPage - 1%>">上一页</a> 
<%
 }
 if (currentPage < maxPage) {
 %>
     <a href="zhangxiangyu_index.jsp?page=<%=currentPage + 1%>">下一页</a> 
     <a href="zhangxiangyu_index.jsp?page=<%=maxPage%>">最后一页&nbsp;</a> 
<%
 }
 rsAll.close(); stmt.close(); conn.close();
 } catch (Exception e) {
      e.printStackTrace();
 }
 %>
    	
    </div>
    <div class="one">
    	<div class="ima">
    	<img src="图片.png">
    	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    </div>
<div class="ima">
    	<img src="图片.png">
    	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    </div>
    <div class="ima">
    	<img src="图片.png">
    	<p>全国两会</p>
    </div>	
</div>
<div id="footer">
   <center><h1>新闻管理系统</h1></center>
</div>
</div>
</body>
</html>