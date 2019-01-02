package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDao;
import tools.Change;
import bean.NewsBean;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if("query".equals(action)){
			try {
				this.query(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("add".equals(action)){
			try {
				this.add(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("delete".equals(action)){
			try {
				this.delete(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				this.query(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		NewsDao newsDao = new NewsDao();
		List<NewsBean> list = newsDao.executeQuery(null);
		request.setAttribute("list", list);
		request.getRequestDispatcher("tzgg.jsp").forward(request, response);		//重定向页面
	}
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name=Change.toChinese(request.getParameter("newsName"));
		String danwei=Change.toChinese(request.getParameter("newsDanwei"));
		String timee=Change.toChinese(request.getParameter("newsTime"));
		NewsDao newsDao = new NewsDao();
		newsDao.executeAdd(new Object[]{name,danwei,timee});
		this.query(request, response);
	}
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Integer id=Change.strToInt(request.getParameter("id"));
		NewsDao newsDao = new NewsDao();
		newsDao.executeDelete(new Object[]{id});
		this.query(request, response);
	}

}
