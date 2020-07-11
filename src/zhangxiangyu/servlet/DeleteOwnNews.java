package zhangxiangyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhangxiangyu.dao.NewsDao;
import zhangxiangyu.daoimpl.NewsDaoimpl;

/**
 * Servlet implementation class DeleteOwnNews
 */
@WebServlet("/DeleteOwnNews")
public class DeleteOwnNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOwnNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("get方法");
		try {
		int zhangxiangyu_id =Integer.parseInt(request.getParameter("zhangxiangyu_id"));
		System.out.println(zhangxiangyu_id);
		NewsDao zhangxiangyu_dao =new NewsDaoimpl();
		int zhangxiangyu_rs =zhangxiangyu_dao.zhangxiangyu_Delete(zhangxiangyu_id);
		if(zhangxiangyu_rs!=0)
		{
			out.print("删除成功");
		}
		else {
			out.print("删除失败");
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
