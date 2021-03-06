package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import tools.Change;
import tools.DB;
import bean.UserBean;

public class UserDao {

	public UserBean getLogoner(Object[] params) throws SQLException{
		UserBean logoner=null;
		String sql="select * from tb_user where user_name=? and user_password=? and user_role=?";
		List list=getList(sql,params);
		if(list!=null&&list.size()!=0)
			logoner=(UserBean)list.get(0);
		return logoner;		
	}
	
	public UserBean executeQuerybyId(Object[] params) throws SQLException{
		UserBean who=null;
		String sql="select * from tb_user where id=?";
		List list=getList(sql,params);
		if(list!=null&&list.size()!=0)
			who=(UserBean)list.get(0);
		return who;	
	}
	
	public List<UserBean> executeQuerybyRole(Object[] params) throws SQLException{
		String sql="select * from tb_user where user_role=?";
		List list=getList(sql,params);
		return list;
	}
	
	public void executeDelete(Object[] params) throws SQLException{
		String sql="DELETE FROM tb_user WHERE id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
	
	private List getList(String sql,Object[] params) throws SQLException{
		List list=null;
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			list=new ArrayList();
			while(rs.next()){
				UserBean user=new UserBean();
				user.setId(rs.getInt(1));
				user.setUser_name(rs.getString(2));
				user.setUser_password(rs.getString(3));
				user.setUser_role(rs.getInt(4));
				list.add(user);
			}
			rs.close();
		}
		mydb.closed();
		return list;
	}
	
}
