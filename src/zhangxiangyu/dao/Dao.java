package zhangxiangyu.dao;

import java.util.List;

import zhangxiangyu.user.User;
import zhangxiangyu.user.User;

public interface Dao {
	public List<User> zhangxiangyu_Login(User user) throws Exception;
	public int zhangxiangyu_Register(User user)  throws Exception;
	public List<User> zhangxiangyu_SelectAllUser() throws Exception;
	public int zhangxiangyu_DeleteUser(int id) throws Exception;
	public List<User> zhangxiangyu_SelectId(int id) throws Exception;
	public int zhangxiangyu_UpdateUser(User user)  throws Exception; 
	public int zhangxiangyu_own(User user)  throws Exception;
}
