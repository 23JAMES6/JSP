package zhangxiangyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import zhangxiangyu.dao.Dao;
import zhangxiangyu.daoimpl.Daoimpl;
import zhangxiangyu.user.User;

/**
 * Servlet implementation class UpdateOwn
 */
@WebServlet("/UpdateOwn")
public class UpdateOwn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOwn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("我是初始化");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		try {
		System.out.println("post方法");
		Dao zhangxiangyu_dao =new Daoimpl();
		User zhangxiangyu_user =new User();
		int zhangxiangyu_id =Integer.parseInt(request.getParameter("zhangxiangyu_id"));
		String zhangxiangyu_username =request.getParameter("zhangxiangyu_username");
		String zhangxiangyu_password =request.getParameter("zhangxiangyu_password");
		zhangxiangyu_user.setZhangxiangyu_id(zhangxiangyu_id);
		zhangxiangyu_user.setZhangxiangyu_username(zhangxiangyu_username);
		zhangxiangyu_user.setZhangxiangyu_password(zhangxiangyu_password);
		int zhangxiangyu_rs  =zhangxiangyu_dao.zhangxiangyu_own(zhangxiangyu_user);
		if(zhangxiangyu_rs!=0) {
			 out.print("修改成功");
		}
		else {
			 out.print("修改失败");
		}
		}catch (Exception e) {
		  System.out.println(e);
		}
	}

}
