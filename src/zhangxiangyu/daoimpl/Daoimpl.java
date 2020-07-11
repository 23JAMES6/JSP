package zhangxiangyu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import zhangxiangyu.conn.Conn;
import zhangxiangyu.dao.Dao;
import zhangxiangyu.user.User;

public class Daoimpl implements Dao{
	//登录
	@Override
	public List<User> zhangxiangyu_Login(User user){
		List <User> zhangxiangyu_list =new ArrayList<User>();
		ResultSet zhangxiangyu_rs=null;
		try{
		Conn zhangxiangyu_c=new Conn();
		Connection zhangxiangyu_dbc=(Connection) zhangxiangyu_c.getConnection();
		String sql_select_id="select * from user where zhangxiangyu_username=? and zhangxiangyu_password=? and zhangxiangyu_type=?";
		PreparedStatement zhangxiangyu_pst=zhangxiangyu_dbc.prepareStatement(sql_select_id);
		zhangxiangyu_pst.setString(1, user.getZhangxiangyu_username());
		zhangxiangyu_pst.setString(2, user.getZhangxiangyu_password());
		zhangxiangyu_pst.setString(3, user.getZhangxiangyu_type());
		zhangxiangyu_rs=zhangxiangyu_pst.executeQuery();
		while(zhangxiangyu_rs.next()) {
		User zhangxiangyu_user =new User(); 
		zhangxiangyu_user.setZhangxiangyu_username(user.getZhangxiangyu_username());
		zhangxiangyu_user.setZhangxiangyu_password(user.getZhangxiangyu_password());
		zhangxiangyu_user.setZhangxiangyu_type(user.getZhangxiangyu_type());
		zhangxiangyu_user.setZhangxiangyu_id(zhangxiangyu_rs.getInt("zhangxiangyu_id"));
		zhangxiangyu_list.add(zhangxiangyu_user);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return zhangxiangyu_list;
	}
	
	//注册
	@Override
	public int zhangxiangyu_Register(User user) throws Exception {
		int zhangxiangyu_rs=0;
		try {
		Conn zhangxiangyu_conn =new Conn();
		Connection zhangxiangyu_c =zhangxiangyu_conn.getConnection();
		String zhangxiangyu_sql ="insert into user(zhangxiangyu_username,zhangxiangyu_password,zhangxiangyu_type) values(?,?,?)";
		PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
		zhangxiangyu_pst.setString(1,user.getZhangxiangyu_username());
		zhangxiangyu_pst.setString(2, user.getZhangxiangyu_password());
		zhangxiangyu_pst.setString(3, user.getZhangxiangyu_type());
		zhangxiangyu_rs  =   zhangxiangyu_pst.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return zhangxiangyu_rs;
	}
	//查询所有用户
	@Override
	public List<User> zhangxiangyu_SelectAllUser() throws Exception {
		List <User> zhangxiangyu_list =new ArrayList<User>();
		ResultSet zhangxiangyu_rs=null;
		try{
		Conn zhangxiangyu_c=new Conn();
		Connection zhangxiangyu_dbc=(Connection) zhangxiangyu_c.getConnection();
		String sql_select_id="select * from user";
		PreparedStatement zhangxiangyu_pst=zhangxiangyu_dbc.prepareStatement(sql_select_id);
		zhangxiangyu_rs=zhangxiangyu_pst.executeQuery();
		while(zhangxiangyu_rs.next()) {
		User zhangxiangyu_user =new User(); 
		zhangxiangyu_user.setZhangxiangyu_id(zhangxiangyu_rs.getInt("zhangxiangyu_id"));
		zhangxiangyu_user.setZhangxiangyu_username(zhangxiangyu_rs.getString("zhangxiangyu_username"));
		zhangxiangyu_user.setZhangxiangyu_password(zhangxiangyu_rs.getString("zhangxiangyu_password"));
		zhangxiangyu_user.setZhangxiangyu_type(zhangxiangyu_rs.getString("zhangxiangyu_type"));
		zhangxiangyu_list.add(zhangxiangyu_user);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return zhangxiangyu_list;
	}

	//删除用户
	@Override
	public int zhangxiangyu_DeleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		int zhangxiangyu_rs =0;
		try {
			Conn zhangxiangyu_conn =new Conn();
			Connection zhangxiangyu_c =zhangxiangyu_conn.getConnection();
			String zhangxiangyu_sql ="delete  from user where zhangxiangyu_id=?";
			PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
			zhangxiangyu_pst.setInt(1, id);
			zhangxiangyu_rs = zhangxiangyu_pst.executeUpdate();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return zhangxiangyu_rs;
	}
	//通过id进行查询
	@Override
	public List<User> zhangxiangyu_SelectId(int id) throws Exception {
		// TODO Auto-generated method stub
		List <User> zhangxiangyu_selectid =new ArrayList<User>();
		ResultSet zhangxiangyu_rs =null;
		try {
			Conn zhangxiangyu_conn =new Conn();
			Connection zhangxiangyu_c =zhangxiangyu_conn.getConnection();
			String zhangxiangyu_sql ="select * from user where zhangxiangyu_id=?";
			PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
			zhangxiangyu_pst.setInt(1,id);
			zhangxiangyu_rs=zhangxiangyu_pst.executeQuery();
			while(zhangxiangyu_rs.next()) {
				User zhangxiangyu_user =new User();
				zhangxiangyu_user.setZhangxiangyu_username(zhangxiangyu_rs.getString("zhangxiangyu_username"));
				zhangxiangyu_user.setZhangxiangyu_password(zhangxiangyu_rs.getString("zhangxiangyu_password"));
				zhangxiangyu_user.setZhangxiangyu_type(zhangxiangyu_rs.getString("zhangxiangyu_type"));
				zhangxiangyu_user.setZhangxiangyu_id(zhangxiangyu_rs.getInt("zhangxiangyu_id"));
				zhangxiangyu_selectid.add(zhangxiangyu_user);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return zhangxiangyu_selectid;
	}
	//将数据修改进数据库
	@Override
	public int zhangxiangyu_UpdateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		int zhangxiangyu_rs =0;
		try {
			Conn zhangxiangyu_conn =new Conn();
			Connection zhangxiangyu_c =zhangxiangyu_conn.getConnection();
			String zhangxiangyu_sql="update user set zhangxiangyu_username=?,zhangxiangyu_password=?,zhangxiangyu_type=? where zhangxiangyu_id=?";
			PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
			zhangxiangyu_pst.setString(1,user.getZhangxiangyu_username());
			zhangxiangyu_pst.setString(2,user.getZhangxiangyu_password());
			zhangxiangyu_pst.setString(3,user.getZhangxiangyu_type());
			zhangxiangyu_pst.setInt(4, user.getZhangxiangyu_id());
			zhangxiangyu_rs =zhangxiangyu_pst.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return zhangxiangyu_rs;
	}

	@Override
	public int zhangxiangyu_own(User user) throws Exception {
		int zhangxiangyu_rs =0;
		try {
			Conn zhangxiangyu_conn =new Conn();
			Connection zhangxiangyu_c =zhangxiangyu_conn.getConnection();
			String zhangxiangyu_sql="update user set zhangxiangyu_username=?,zhangxiangyu_password=? where zhangxiangyu_id=?";
			PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
			zhangxiangyu_pst.setString(1,user.getZhangxiangyu_username());
			zhangxiangyu_pst.setString(2,user.getZhangxiangyu_password());
			zhangxiangyu_pst.setInt(3, user.getZhangxiangyu_id());
			zhangxiangyu_rs =zhangxiangyu_pst.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return zhangxiangyu_rs;
	}
	


}
