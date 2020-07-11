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
 * Servlet implementation class AddNews
 */
@WebServlet("/AddNews")
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("卡卡卡");
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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		System.out.println("get方法");
		int  zhangxiangyu_rs =0;
		try {
			NewsDao zhangxiangyu_dao =new NewsDaoimpl();
			String  zhangxiangyu_title =request.getParameter("zhangxiangyu_title");
			String  zhangxiangyu_author=request.getParameter("zhangxiangyu_author");
			String  zhangxiangyu_content =request.getParameter("zhangxiangyu_content");
			News zhangxiangyu_news =new News();
			zhangxiangyu_news.setZhangxiangyu_title(zhangxiangyu_title);
			zhangxiangyu_news.setZhangxiangyu_author(zhangxiangyu_author);
			zhangxiangyu_news.setZhangxiangyu_content(zhangxiangyu_content);
			zhangxiangyu_rs=zhangxiangyu_dao.zhangxiangyu_AddNews(zhangxiangyu_news);
			if(zhangxiangyu_rs!=0) {
				out.print("添加成功");
			}
			else {
				out.print("添加失败");
			}
			
		}catch(Exception e) {
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
