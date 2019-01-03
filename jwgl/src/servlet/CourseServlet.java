package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import tools.*;
import bean.*;
import dao.vm.*;
import bean.vm.*;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if ("query".equals(action)) {
			try {
				this.query(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("querytype".equals(action)){
			try {
				this.querytype(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("sc".equals(action)){
			try {
				this.addsc(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("xkqk".equals(action)){
			try {
				this.xkqk(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ("queryoldnew".equals(action)) {
			String oldnew = request.getParameter("oldnew");
			if ("old".equals(oldnew)) {
				try {
					this.queryold(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if ("new".equals(oldnew)) {
				try {
					this.querynew(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					this.query(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if ("add".equals(action)) {
			try {
				this.add(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				this.query(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		CourseVMDao coursevmdao = new CourseVMDao();
		List<CourseVMBean> list = coursevmdao.executeQuery(null);
		request.setAttribute("list", list);
		request.getRequestDispatcher("kcgl.jsp").forward(request, response); // 重定向页面
	}

	public void querynew(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		CourseVMDao coursevmdao = new CourseVMDao();
		List<CourseVMBean> list = coursevmdao.executeQueryOldNew(new Object[] { "new" });
		request.setAttribute("list", list);
		request.getRequestDispatcher("kcgl.jsp").forward(request, response); // 重定向页面
	}

	public void queryold(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		CourseVMDao coursevmdao = new CourseVMDao();
		List<CourseVMBean> list = coursevmdao.executeQueryOldNew(new Object[] { "old" });
		request.setAttribute("list", list);
		request.getRequestDispatcher("kcgl.jsp").forward(request, response); // 重定向页面
	}
	public void querytype(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		CourseVMDao coursevmdao = new CourseVMDao();
		Integer type = Change.strToInt(Change.toChinese(request.getParameter("type")));
		List<CourseVMBean> list = coursevmdao.executeQueryType(new Object[]{type});
		request.setAttribute("list", list);
		request.setAttribute("type", Change.toChinese(request.getParameter("type")));
		request.getRequestDispatcher("wsxk.jsp").forward(request, response); // 重定向页面
	}

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String num = Change.toChinese(request.getParameter("num"));
		String name = Change.toChinese(request.getParameter("name"));
		String description = Change.toChinese(request.getParameter("description"));
		Integer type = Change.strToInt(Change.toChinese(request.getParameter("type")));
		String tea_id = Change.toChinese(request.getParameter("tea_id"));
		CourseVMDao coursevmdao = new CourseVMDao();
		coursevmdao.executeAdd(new Object[] { num, name, description, type, tea_id });
		this.querynew(request, response);
	}
	
	public void addsc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String course_id = Change.toChinese(request.getParameter("course_id"));
		String stu_id = Change.toChinese(request.getParameter("stu_id"));
		StucourseDao stucoursedao = new StucourseDao();
		stucoursedao.executeAdd(new Object[]{course_id, stu_id});
		String type = Change.toChinese(request.getParameter("type"));
		request.setAttribute("type", type);
		this.querytype(request, response);
	}
	
	public void xkqk(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		CourseVMDao coursevmdao = new CourseVMDao();
		Integer stu_id = Change.strToInt(Change.toChinese(request.getParameter("stu_id")));
		System.out.println(stu_id);
		List<CourseVMBean> list = coursevmdao.executeQueryXkqk(new Object[]{stu_id});
		request.setAttribute("list", list);
		request.getRequestDispatcher("xkqk.jsp").forward(request, response); // 重定向页面
	}
}
