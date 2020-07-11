package zhangxiangyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import zhangxiangyu.conn.Conn;
import zhangxiangyu.dao.Dao;
import zhangxiangyu.daoimpl.Daoimpl;
import zhangxiangyu.user.User;
import zhangxiangyu.user.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("��ʼ��");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("����");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//����out���������
		PrintWriter out =response.getWriter();
		//request.setCharacterEncoding("utf-8");
		List <User> zhangxiangyu_list =new ArrayList<User>();
		User zhangxiangyu_user =new User();
		zhangxiangyu_user.setZhangxiangyu_username(request.getParameter("zhangxiangyu_username"));
		zhangxiangyu_user.setZhangxiangyu_password(request.getParameter("zhangxiangyu_password"));
		zhangxiangyu_user.setZhangxiangyu_type(request.getParameter("zhangxiangyu_select"));
		Dao zhangxiangyu_login =new Daoimpl();
		try {
			zhangxiangyu_list=zhangxiangyu_login.zhangxiangyu_Login(zhangxiangyu_user);
			//System.out.println(zhangxiangyu_list.size());
			if(zhangxiangyu_list.size()!=0) {
				//System.out.println("success");
				
				  if(zhangxiangyu_list.get(0).getZhangxiangyu_type().equals("����Ա"))
				  {
					  HttpSession zhangxiangyu_ss =request.getSession();
			          zhangxiangyu_ss.setAttribute("zhangxiangyu_username",zhangxiangyu_list.get(0).getZhangxiangyu_username());	
				      response.sendRedirect("zhangxiangyu_administrator.jsp"); 
				  } 
				  if(zhangxiangyu_list.get(0).getZhangxiangyu_type().equals("��ͨ�û�"))
				  {
					  response.sendRedirect("zhangxiangyu_averageUser.jsp");
					  HttpSession zhangxiangyu_id =request.getSession();
					  zhangxiangyu_id.setAttribute("zhangxiangyu_id",zhangxiangyu_list.get(0).getZhangxiangyu_id());
				  }
				 
			}
			else {
				out.print("��¼ʧ��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post����");
	}

}
