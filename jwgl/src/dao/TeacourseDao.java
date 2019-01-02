package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import tools.Change;
import tools.DB;
import bean.TeacourseBean;

public class TeacourseDao {
	public List<TeacourseBean> executeQuery(Object[] params) throws SQLException{
		List<TeacourseBean> list = new ArrayList<>(); // 创建List
		String sql="select * from tb_teacourse";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			while(rs.next()){
				TeacourseBean teacourse=new TeacourseBean();
				teacourse.setId(rs.getInt(1));
				teacourse.setCourse_id(rs.getInt(2));
				teacourse.setTea_id(rs.getInt(3));
				list.add(teacourse);
			}
			rs.close();
		}
		mydb.closed();
		return list;
	}
	public List<TeacourseBean> executeQueryBytea(Object[] params) throws SQLException{
		List<TeacourseBean> list = new ArrayList<>(); // 创建List
		String sql="select * from tb_teacourse where tea_id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			while(rs.next()){
				TeacourseBean teacourse=new TeacourseBean();
				teacourse.setId(rs.getInt(1));
				teacourse.setCourse_id(rs.getInt(2));
				teacourse.setTea_id(rs.getInt(3));
				list.add(teacourse);
			}
			rs.close();
		}
		mydb.closed();
		return list;
	}
	public List<TeacourseBean> executeQueryBycourse(Object[] params) throws SQLException{
		List<TeacourseBean> list = new ArrayList<>(); // 创建List
		String sql="select * from tb_teacourse where course_id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			while(rs.next()){
				TeacourseBean teacourse=new TeacourseBean();
				teacourse.setId(rs.getInt(1));
				teacourse.setCourse_id(rs.getInt(2));
				teacourse.setTea_id(rs.getInt(3));
				list.add(teacourse);
			}
			rs.close();
		}
		mydb.closed();
		return list;
	}
	public void executeDelete(Object[] params) throws SQLException{
		String sql="DELETE FROM tb_teacourse WHERE id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
	public void executeUpdate(Object[] params) throws SQLException{
		String sql="UPDATE tb_teacourse SET  = ? WHERE id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
	public void executeAdd(Object[] params) throws SQLException{
		String sql="INSERT INTO tb_teacourse (course_id, tea_id) VALUES (?, ?)";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
}
