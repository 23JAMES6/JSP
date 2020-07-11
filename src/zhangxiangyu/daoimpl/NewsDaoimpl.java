package zhangxiangyu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zhangxiangyu.conn.Conn;
import zhangxiangyu.dao.NewsDao;
import zhangxiangyu.news.News;

public class NewsDaoimpl implements NewsDao{
	//��ѯ
	@Override
	public List<News> zhangxiangyu_SelectAll() throws Exception {
		// TODO Auto-generated method stub
		ResultSet zhangxiangyu_rs =null;
		List <News> zhangxiangyu_list =new ArrayList<News>();
		try {
		Conn  zhangxiangyu_conn =new Conn();
		Connection zhangxiangyu_c =zhangxiangyu_conn.getConnection();
		String zhangxiangyu_sql ="select * from news";
		PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
		zhangxiangyu_rs=zhangxiangyu_pst.executeQuery();
		while(zhangxiangyu_rs.next()) {
			News zhangxiangyu_news = new News();
			zhangxiangyu_news.setZhangxiangyu_id(zhangxiangyu_rs.getInt("id"));
			zhangxiangyu_news.setZhangxiangyu_title(zhangxiangyu_rs.getString("title"));
			zhangxiangyu_news.setZhangxiangyu_author(zhangxiangyu_rs.getString("author"));
			zhangxiangyu_news.setZhangxiangyu_content(zhangxiangyu_rs.getString("content"));
			zhangxiangyu_list.add(zhangxiangyu_news);
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return zhangxiangyu_list;
	}
	//ɾ��
	@Override
	public int zhangxiangyu_Delete(int id) throws Exception {
		int zhangxiangyu_rs =0;
		try {
			Conn  zhangxiangyu_conn =new Conn();
			Connection zhangxiangyu_c =zhangxiangyu_conn.getConnection();
			String zhangxiangyu_sql ="delete from news where id=?";
			PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
			zhangxiangyu_pst.setInt(1, id);
			zhangxiangyu_rs =zhangxiangyu_pst.executeUpdate();
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return zhangxiangyu_rs;
	}
	//���
	@Override
	public int zhangxiangyu_AddNews(News news) throws Exception {
		// TODO Auto-generated method stub
		int zhangxiangyu_rs =0;
		try {
			Conn zhangxiangyu_conn =new Conn();
			Connection zhangxiangyu_c =zhangxiangyu_conn.getConnection();
			String zhangxiangyu_sql ="insert into news(title,author,content) values(?,?,?)";
			PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
			zhangxiangyu_pst.setString(1, news.getZhangxiangyu_title());
			zhangxiangyu_pst.setString(2, news.getZhangxiangyu_author());
			zhangxiangyu_pst.setString(3, news.getZhangxiangyu_content());
			zhangxiangyu_rs=zhangxiangyu_pst.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return zhangxiangyu_rs;
	}
	//ͨ����Ų�ѯ
	@Override
	public List<News> zhangxiangyu_SelectId(int id) throws Exception {
		// TODO Auto-generated method stub
		ResultSet zhangxiangyu_rs =null;
		List <News> zhangxiangyu_list =new ArrayList<News>();
		try {
			Conn zhangxiangyu_conn =new Conn();
			Connection zhangxiangyu_c =zhangxiangyu_conn.getConnection();
			String  zhangxiangyu_sql ="select * from news where id=?";
			PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
			zhangxiangyu_pst.setInt(1, id);
			zhangxiangyu_rs =zhangxiangyu_pst.executeQuery();
			while(zhangxiangyu_rs.next())
			{
				News zhangxiangyu_news =new News();
				zhangxiangyu_news.setZhangxiangyu_id(zhangxiangyu_rs.getInt("id"));
				zhangxiangyu_news.setZhangxiangyu_title(zhangxiangyu_rs.getString("title"));
				zhangxiangyu_news.setZhangxiangyu_author(zhangxiangyu_rs.getString("author"));
				zhangxiangyu_news.setZhangxiangyu_content(zhangxiangyu_rs.getString("content"));
				zhangxiangyu_list.add(zhangxiangyu_news);	
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return zhangxiangyu_list;
	}
	//�����ݸ��������ݿ�
	@Override
	public int zhangxiangyu_newsupdate(News news) throws Exception {
		// TODO Auto-generated method stub
		int zhangxiangyu_rs =0;
		try {
			Conn zhangxiangyu_conn =new Conn();
			Connection zhangxiangyu_c = zhangxiangyu_conn.getConnection();
			String zhangxiangyu_sql ="update news set title=?,author=?,content=? where id=?";
			PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
			zhangxiangyu_pst.setString(1, news.getZhangxiangyu_title());
			zhangxiangyu_pst.setString(2, news.getZhangxiangyu_author());
			zhangxiangyu_pst.setString(3, news.getZhangxiangyu_content());
			zhangxiangyu_pst.setInt(4, news.getZhangxiangyu_id());
			zhangxiangyu_rs =zhangxiangyu_pst.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return zhangxiangyu_rs;
	}
	//ͨ�������ֶν��в�ѯ
	@Override
	public List<News> zhangxiangyu_SelectOwn(String name) throws Exception {
		// TODO Auto-generated method stub
		ResultSet zhangxiangyu_rs =null;
		List <News> zhangxiangyu_list =new ArrayList<News>();
		try {
			Conn zhangxiangyu_conn =new Conn();
			Connection zhangxiangyu_c =zhangxiangyu_conn.getConnection();
			String  zhangxiangyu_sql ="select * from news where author=?";
			PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
			zhangxiangyu_pst.setString(1, name);
			zhangxiangyu_rs =zhangxiangyu_pst.executeQuery();
			while(zhangxiangyu_rs.next())
			{
				News zhangxiangyu_news =new News();
				zhangxiangyu_news.setZhangxiangyu_id(zhangxiangyu_rs.getInt("id"));
				zhangxiangyu_news.setZhangxiangyu_title(zhangxiangyu_rs.getString("title"));
				zhangxiangyu_news.setZhangxiangyu_author(zhangxiangyu_rs.getString("author"));
				zhangxiangyu_news.setZhangxiangyu_content(zhangxiangyu_rs.getString("content"));
				zhangxiangyu_list.add(zhangxiangyu_news);	
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return zhangxiangyu_list;
		}
	//�������Ź����еĸ�����Ϣ�������ݿ�
	@Override
	public int zhangxiangyu_updateown(News news) throws Exception {
		int zhangxiangyu_rs =0;
		try {
			Conn zhangxiangyu_conn =new Conn();
			Connection zhangxiangyu_c = zhangxiangyu_conn.getConnection();
			String zhangxiangyu_sql ="update news set title=?,content=? where id=?";
			PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
			zhangxiangyu_pst.setString(1, news.getZhangxiangyu_title());
			zhangxiangyu_pst.setString(2, news.getZhangxiangyu_content());
			zhangxiangyu_pst.setInt(3, news.getZhangxiangyu_id());
			zhangxiangyu_rs =zhangxiangyu_pst.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return zhangxiangyu_rs;
	}
	//����ģ����ѯ
	@Override
	public List<News> zhangxiangyu_Select(String word) throws Exception {
		ResultSet zhangxiangyu_rs =null;
		List <News> zhangxiangyu_list =new ArrayList<News>();
		try {
			Conn zhangxiangyu_conn =new Conn();
			Connection zhangxiangyu_c =zhangxiangyu_conn.getConnection();
			String  zhangxiangyu_sql ="select * from news  where title like '%ţ%'";
			PreparedStatement zhangxiangyu_pst =zhangxiangyu_c.prepareStatement(zhangxiangyu_sql);
			zhangxiangyu_pst.setString(1, word);
			zhangxiangyu_rs =zhangxiangyu_pst.executeQuery();
			while(zhangxiangyu_rs.next())
			{
				News zhangxiangyu_news =new News();
				zhangxiangyu_news.setZhangxiangyu_id(zhangxiangyu_rs.getInt("id"));
				zhangxiangyu_news.setZhangxiangyu_title(zhangxiangyu_rs.getString("title"));
				zhangxiangyu_news.setZhangxiangyu_author(zhangxiangyu_rs.getString("author"));
				zhangxiangyu_news.setZhangxiangyu_content(zhangxiangyu_rs.getString("content"));
				zhangxiangyu_list.add(zhangxiangyu_news);	
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return zhangxiangyu_list;
	}

}
