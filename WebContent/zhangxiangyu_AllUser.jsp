<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="zhangxiangyu.dao.Dao"%>
<%@ page language="java" import="zhangxiangyu.daoimpl.Daoimpl"%>
<%@ page language="java" import="zhangxiangyu.user.User"%>
<%@ page language="java" import="java.util.Iterator"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ page language="java" import="java.util.List"%>
<%@ page language="java" import="zhangxiangyu.conn.Conn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>管理对所有用户进行管理</h2>
	<% 
	try {
			Dao zhangxiangyu_dao =new Daoimpl();
			List <User> zhangxiangyu_alluser =new ArrayList<User>();
			zhangxiangyu_alluser=zhangxiangyu_dao.zhangxiangyu_SelectAllUser();
			Iterator<User> zhangxiangyu_Ite =zhangxiangyu_alluser.iterator();
	 %>
	    <table border="1">
	    <tr> <th> 用户名 </th>   <th>权限</th>  </tr>   
	    <% 
			while(zhangxiangyu_Ite.hasNext()){
			User zhangxiangyu_user =zhangxiangyu_Ite.next();
		%>
		
			<tr> <td> <%=zhangxiangyu_user.getZhangxiangyu_username() %> </td>
				 <td> <%=zhangxiangyu_user.getZhangxiangyu_type() %> </td>
				 <td> <a href="zhangxiangyu_UserUpdate.jsp?zhangxiangyu_id=<%=zhangxiangyu_user.getZhangxiangyu_id()%>">修改</a> </td>
				 <td> <a href="DeleteUser?zhangxiangyu_id=<%=zhangxiangyu_user.getZhangxiangyu_id()%>">删除</a> </td>
		    </tr>
		 
		    <%
		   
			}
	       %>
	       </table>
	       <% 
			}
			catch(Exception e) {
				System.out.println(e);
			}
	%>
</body>
</html>