package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import tools.Change;
import bean.UserBean;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message="";
		HttpSession session=request.getSession();
		Object logoner=session.getAttribute("logoner");	
		
		UserBean be=new UserBean();
		be=(UserBean)logoner;
		if(logoner!=null&&(logoner instanceof UserBean)&&be.getUser_role()!=0)					//用户已经登录
		{
			message="您已经以用户名";
			message+=be.getUser_name();
			message+="登录！";
			session.setAttribute("logoner",logoner);
			session.setAttribute("sucess", message);
			response.sendRedirect("text.jsp");
		}
		else{																//用户没有登录
			String name=Change.toChinese(request.getParameter("userName"));
			String pswd=Change.toChinese(request.getParameter("userPswd"));
			String rol=Change.toChinese(request.getParameter("RadioButtonList1"));
			Integer rols=new Integer(-1);
			if("访客".equals(rol)){
				rols=0;
				name="fk";
				pswd="fk";
			}else if("管理员".equals(rol)){
				rols=1;
			}else if("教师".equals(rol)){
				rols=2;
			}else if("学生".equals(rol)){
				rols=3;
			}else {
				rols=-1;
			}
			message=validateLogon(name,pswd);								//进行表单验证
			if(message.equals("")){											//表单验证成功
				try {
					UserDao userDao=new UserDao();
					logoner=userDao.getLogoner(new Object[]{name,pswd,rols});
					if(logoner==null){
					//if(!"yizhixiaokong".equals(name)||!"hxxmlgb123@".equals(pswd)){
						message="用户名或密码不正确！";
						request.setAttribute("message",message);
						request.getRequestDispatcher("index.jsp").forward(request, response);		//重定向页面
					}
					else{
						message="登录成功！";
						session.setAttribute("logoner",logoner);
						if(rols==0){
							message+="访客您好！";
							session.setAttribute("sucess", message);
							response.sendRedirect("vis_main.jsp");
						}else if(rols==1){
							message+="管理员";
							message+=name;
							message+="您好！";
							session.setAttribute("sucess", message);
							response.sendRedirect("text.jsp");
						}else if(rols==2){
							message+="号码为：";
							message+=name;
							message+="的老师您好！";
							session.setAttribute("sucess", message);
							response.sendRedirect("text.jsp");
						}else {
							message+="号码为：";
							message+=name;
							message+="的同学您好！";
							session.setAttribute("sucess", message);
							response.sendRedirect("text.jsp");
						}	
					}
				}catch (SQLException e) {
					message="登录失败！";
					request.setAttribute("message",message);
					request.getRequestDispatcher("index.jsp").forward(request, response);		//重定向页面
					e.printStackTrace();
				}
			}			
		}	
		
	}

	private String validateLogon(String name,String pswd){
		String message="";
		if(name==null||name.equals(""))
			message="请输入用户名！";
		if(pswd==null||pswd.equals(""))
			message+="请输入密码";
		return message;
	}
	

}
