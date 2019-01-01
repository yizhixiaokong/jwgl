package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import tools.Change;
import tools.DB;
import bean.NewsBean;

public class NewsDao {
	public List<NewsBean> executeQuery(Object[] params) throws SQLException{
		List<NewsBean> list = new ArrayList<>(); // 创建List
		String sql="select * from tb_news";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			while(rs.next()){
				NewsBean user=new NewsBean();
				user.setId(rs.getInt(1));
				user.setNews_name(rs.getString(2));
				user.setNews_danwei(rs.getString(3));
				user.setNews_time(rs.getString(4));
				list.add(user);
			}
			rs.close();
		}
		mydb.closed();
		return list;
	}
	public void executeDelete(Object[] params) throws SQLException{
		String sql="DELETE FROM tb_news WHERE id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
	public void executeUpdate(Object[] params) throws SQLException{
		String sql="UPDATE tb_news SET news_name = ? WHERE id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
	public void executeAdd(Object[] params) throws SQLException{
		String sql="INSERT INTO tb_news (news_name, news_danwei, news_time) VALUES (?, ?, ?)";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
}
