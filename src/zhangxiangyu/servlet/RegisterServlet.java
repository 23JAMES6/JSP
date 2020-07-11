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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("³õÊ¼»¯");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Ïú»Ù");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		try {
		Dao zhangxiangyu_Register =new Daoimpl();
		User zhangxiangyu_user =new User();
		zhangxiangyu_user.setZhangxiangyu_username(request.getParameter("zhangxiangyu_username"));
		zhangxiangyu_user.setZhangxiangyu_password(request.getParameter("zhangxiangyu_password"));
		zhangxiangyu_user.setZhangxiangyu_type(request.getParameter("zhangxiangyu_type"));
		int  zhangxiangyu_rs =zhangxiangyu_Register.zhangxiangyu_Register(zhangxiangyu_user);
		if(zhangxiangyu_rs!=0) 
		{
		 	out.println("×¢²á³É¹¦");
		}
		else {
			out.println("×¢²áÊ§°Ü");
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
