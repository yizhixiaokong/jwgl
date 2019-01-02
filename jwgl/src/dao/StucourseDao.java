package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import tools.Change;
import tools.DB;
import bean.StucourseBean;

public class StucourseDao {
	public List<StucourseBean> executeQuery(Object[] params) throws SQLException{
		List<StucourseBean> list = new ArrayList<>(); // 创建List
		String sql="select * from tb_stucourse";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			while(rs.next()){
				StucourseBean stucourse=new StucourseBean();
				stucourse.setId(rs.getInt(1));
				stucourse.setCourse_id(rs.getInt(2));
				stucourse.setStu_id(rs.getInt(3));
				list.add(stucourse);
			}
			rs.close();
		}
		mydb.closed();
		return list;
	}
	public List<StucourseBean> executeQueryBystu(Object[] params) throws SQLException{
		List<StucourseBean> list = new ArrayList<>(); // 创建List
		String sql="select * from tb_stucourse where stu_id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			while(rs.next()){
				StucourseBean stucourse=new StucourseBean();
				stucourse.setId(rs.getInt(1));
				stucourse.setCourse_id(rs.getInt(2));
				stucourse.setStu_id(rs.getInt(3));
				list.add(stucourse);
			}
			rs.close();
		}
		mydb.closed();
		return list;
	}
	public List<StucourseBean> executeQueryBycourse(Object[] params) throws SQLException{
		List<StucourseBean> list = new ArrayList<>(); // 创建List
		String sql="select * from tb_stucourse where course_id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			while(rs.next()){
				StucourseBean stucourse=new StucourseBean();
				stucourse.setId(rs.getInt(1));
				stucourse.setCourse_id(rs.getInt(2));
				stucourse.setStu_id(rs.getInt(3));
				list.add(stucourse);
			}
			rs.close();
		}
		mydb.closed();
		return list;
	}
	public void executeDelete(Object[] params) throws SQLException{
		String sql="DELETE FROM tb_stucourse WHERE id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
	public void executeUpdate(Object[] params) throws SQLException{
		String sql="UPDATE tb_stucourse SET  = ? WHERE id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
	public void executeAdd(Object[] params) throws SQLException{
		String sql="INSERT INTO tb_stucourse (course_id, stu_id) VALUES (?, ?)";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
}
