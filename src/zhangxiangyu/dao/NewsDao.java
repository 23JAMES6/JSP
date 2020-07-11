package zhangxiangyu.dao;

import java.util.List;

import zhangxiangyu.news.News;

public interface NewsDao {
	public List<News> zhangxiangyu_SelectAll() throws Exception;
	public int zhangxiangyu_Delete(int id) throws Exception;
	public int zhangxiangyu_AddNews(News news)  throws Exception;
	public List<News> zhangxiangyu_SelectId(int id) throws Exception;
	public int zhangxiangyu_newsupdate(News news) throws Exception;
	public List<News> zhangxiangyu_SelectOwn(String name) throws Exception;
	public int zhangxiangyu_updateown(News news)  throws Exception;
	public List <News> zhangxiangyu_Select(String word) throws Exception;
 	
}
