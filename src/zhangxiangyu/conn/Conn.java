package zhangxiangyu.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	public Connection getConnection ()
	{
		Connection zhangxiangyu_conn=null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			zhangxiangyu_conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?characterEncoding=utf8", "root", "zxy54321");
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return zhangxiangyu_conn;
	}
}
