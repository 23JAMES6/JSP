package zhangxiangyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhangxiangyu.dao.NewsDao;
import zhangxiangyu.daoimpl.NewsDaoimpl;
import zhangxiangyu.news.News;

/**
 * Servlet implementation class UpdateOwnNews
 */
@WebServlet("/UpdateOwnNews")
public class UpdateOwnNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOwnNews() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post方法");
		PrintWriter out =response.getWriter();
		response.setContentType("text/html;charset=utf8");
		request.setCharacterEncoding("UTF-8");
		try {
		int zhangxiangyu_id =Integer.parseInt(request.getParameter("zhangxiangyu_id"));
		//out.print(zhangxiangyu_id);
		News zhangxiangyu_news =new News();
		zhangxiangyu_news.setZhangxiangyu_id(zhangxiangyu_id);
		zhangxiangyu_news.setZhangxiangyu_title(request.getParameter("zhangxiangyu_title"));
		zhangxiangyu_news.setZhangxiangyu_content(request.getParameter("zhangxiangyu_content"));
		NewsDao zhangxiangyu_dao =new NewsDaoimpl();
		int zhangxiangyu_rs=zhangxiangyu_dao.zhangxiangyu_updateown(zhangxiangyu_news);
		if(zhangxiangyu_rs!=0)
		{
			out.println("修改成功");
		}
		else {
			out.println("修改失败");
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
