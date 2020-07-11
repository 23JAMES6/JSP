<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>添加新闻页面</h2>
	<form action="AddNews" method="get">
	<table>
	<tr>
	 <td> 标题</td>
	 <td> <input type="text" name="zhangxiangyu_title"> </td>
	</tr>
	<tr>
	 <td> 作者</td>
	 <td> <input type="text" name="zhangxiangyu_author"> </td>
	</tr>
	<tr>
	 <td> 内容</td>
	 <td> <input type="text" name="zhangxiangyu_content"> </td>
	</tr>
	<tr>
	 <td>  <input type="submit" value="添加新闻">       </td>
	</tr>
	</table>
	
	
	
	</form>
</body>
</html>