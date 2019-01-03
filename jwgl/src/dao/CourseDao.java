package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tools.Change;
import tools.DB;
import bean.CourseBean;

public class CourseDao {
	public List<CourseBean> executeQuery(Object[] params) throws SQLException{
		List<CourseBean> list = new ArrayList<>(); // 创建List
		String sql="select * from tb_course";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			while(rs.next()){
				CourseBean course=new CourseBean();
				course.setId(rs.getInt(1));
				course.setNum(rs.getString(2));
				course.setName(rs.getString(3));
				course.setDescription(rs.getString(4));
				course.setType(rs.getInt(5));
				course.setTime(rs.getString(6));
				list.add(course);
			}
			rs.close();
		}
		mydb.closed();
		return list;
	}
	public Integer executeGetId(Object[] params) throws SQLException{
		List<CourseBean> list = new ArrayList<>(); // 创建List
		String sql="select * from tb_course where num=? and name=? and description=? and type=? and time=?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			while(rs.next()){
				CourseBean course=new CourseBean();
				course.setId(rs.getInt(1));
				course.setNum(rs.getString(2));
				course.setName(rs.getString(3));
				course.setDescription(rs.getString(4));
				course.setType(rs.getInt(5));
				course.setTime(rs.getString(6));
				list.add(course);
			}
			rs.close();
		}
		mydb.closed();
		return list.get(0).getId();
	}
	public List<CourseBean> executeQueryOldNew(Object[] params) throws SQLException{
		List<CourseBean> list = new ArrayList<>(); // 创建List
		String sql="select * from tb_course where time = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			while(rs.next()){
				CourseBean course=new CourseBean();
				course.setId(rs.getInt(1));
				course.setNum(rs.getString(2));
				course.setName(rs.getString(3));
				course.setDescription(rs.getString(4));
				course.setType(rs.getInt(5));
				course.setTime(rs.getString(6));
				list.add(course);
			}
			rs.close();
		}
		mydb.closed();
		return list;
	}
	public List<CourseBean> executeQueryType(Object[] params) throws SQLException{
		List<CourseBean> list = new ArrayList<>(); // 创建List
		String sql="select * from tb_course where type = ? and time = 'new'";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			while(rs.next()){
				CourseBean course=new CourseBean();
				course.setId(rs.getInt(1));
				course.setNum(rs.getString(2));
				course.setName(rs.getString(3));
				course.setDescription(rs.getString(4));
				course.setType(rs.getInt(5));
				course.setTime(rs.getString(6));
				list.add(course);
			}
			rs.close();
		}
		mydb.closed();
		return list;
	}
	public List<CourseBean> executeQueryByid(Object[] params) throws SQLException{
		List<CourseBean> list = new ArrayList<>(); // 创建List
		String sql="select * from tb_course where id = ? and time = 'new'";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		ResultSet rs=mydb.getRs();
		if(rs!=null){
			while(rs.next()){
				CourseBean course=new CourseBean();
				course.setId(rs.getInt(1));
				course.setNum(rs.getString(2));
				course.setName(rs.getString(3));
				course.setDescription(rs.getString(4));
				course.setType(rs.getInt(5));
				course.setTime(rs.getString(6));
				list.add(course);
			}
			rs.close();
		}
		mydb.closed();
		return list;
	}
	public void executeDelete(Object[] params) throws SQLException{
		String sql="DELETE FROM tb_course WHERE id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
	public void executeUpdate(Object[] params) throws SQLException{
		String sql="UPDATE tb_course SET num = ? WHERE id = ?";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
	public void executeAdd(Object[] params) throws SQLException{
		String sql="INSERT INTO tb_course (num, name, description, type, time) VALUES (?, ?, ?, ?, ?)";
		DB mydb=new DB();
		mydb.doPstm(sql,params);
		return;
	}
}
