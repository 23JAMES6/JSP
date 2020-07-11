package zhangxiangyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhangxiangyu.dao.Dao;
import zhangxiangyu.daoimpl.Daoimpl;
import zhangxiangyu.user.User;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("这里是修改");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		int zhangxiangyu_rs =0;
		try {
			Dao zhangxiangyu_dao =new Daoimpl();
			User zhangxiangyu_user =new User();
			int zhangxiangyu_id =Integer.parseInt(request.getParameter("zhangxiangyu_id"));
			zhangxiangyu_user.setZhangxiangyu_username(request.getParameter("zhangxiangyu_username"));
			zhangxiangyu_user.setZhangxiangyu_password(request.getParameter("zhangxiangyu_password"));
			zhangxiangyu_user.setZhangxiangyu_type(request.getParameter("zhangxiangyu_type"));
			zhangxiangyu_user.setZhangxiangyu_id(zhangxiangyu_id);
			zhangxiangyu_rs =zhangxiangyu_dao.zhangxiangyu_UpdateUser(zhangxiangyu_user);
			if(zhangxiangyu_rs!=0)
			{
				out.println("修改成功");
			}
			else {
				out.println("修改失败"); 
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
