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

/**
 * Servlet implementation class NewsDelete
 */
@WebServlet("/NewsDelete")
public class NewsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("hello");
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		try {
			NewsDao zhangxiangyu_newsdao =new NewsDaoimpl();
			int zhangxiangyu_id = Integer.parseInt(request.getParameter("zhangxiangyu_id"));
			int zhangxiangyu_rs =0;
			zhangxiangyu_rs=zhangxiangyu_newsdao.zhangxiangyu_Delete(zhangxiangyu_id);
			if(zhangxiangyu_rs!=0)
			{
				out.print("É¾³ý³É¹¦");
			}
			else {
				out.print("É¾³ýÊ§°Ü");
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
