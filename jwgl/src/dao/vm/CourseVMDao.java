package dao.vm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tools.*;
import bean.*;
import bean.vm.CourseVMBean;
import dao.*;

public class CourseVMDao {
	public List<CourseVMBean> executeQuery(Object[] params) throws SQLException{
		List<CourseVMBean> list = new ArrayList<>(); // 创建List
		CourseDao courseDao = new CourseDao();
		List<CourseBean> list2=courseDao.executeQuery(null);
		for (CourseBean courseBean : list2) {
			//创建一个CourseVMBean类型的对象用于接收查询结果
			CourseVMBean coursevm = new CourseVMBean();
			
			Integer id = courseBean.getId();
			
			//这里要查出这门课有哪些人选了
			StucourseDao stucoursedao = new StucourseDao();
			List<UserBean> stu = new ArrayList<>();
			List<StucourseBean> stuid = stucoursedao.executeQueryBycourse(new Object[]{id});
			for (StucourseBean stucourseBean : stuid) {
				UserDao s = new UserDao();
				stu.add(s.executeQuerybyId(new Object[]{stucourseBean.getStu_id()}));
			}
			//这里要查出这门课哪些老师教
			TeacourseDao teacoursedao = new TeacourseDao();
			List<UserBean> tea = new ArrayList<>();
			List<TeacourseBean> teaid = teacoursedao.executeQueryBycourse(new Object[]{id});
			for (TeacourseBean teacourseBean : teaid) {
				UserDao s = new UserDao();
				tea.add(s.executeQuerybyId(new Object[]{teacourseBean.getTea_id()}));
			}
			coursevm.setCourse(courseBean);
			coursevm.setStudents(stu);
			coursevm.setTeachers(tea);
			list.add(coursevm);
		}
		return list;
	}
	public List<CourseVMBean> executeQueryOldNew(Object[] params) throws SQLException{
		List<CourseVMBean> list = new ArrayList<>(); // 创建List
		CourseDao courseDao = new CourseDao();
		List<CourseBean> list2=courseDao.executeQueryOldNew(params);
		for (CourseBean courseBean : list2) {
			//创建一个CourseVMBean类型的对象用于接收查询结果
			CourseVMBean coursevm = new CourseVMBean();
			
			Integer id = courseBean.getId();
			
			//这里要查出这门课有哪些人选了
			StucourseDao stucoursedao = new StucourseDao();
			List<UserBean> stu = new ArrayList<>();
			List<StucourseBean> stuid = stucoursedao.executeQueryBycourse(new Object[]{id});
			for (StucourseBean stucourseBean : stuid) {
				UserDao s = new UserDao();
				stu.add(s.executeQuerybyId(new Object[]{stucourseBean.getStu_id()}));
			}
			//这里要查出这门课哪些老师教
			TeacourseDao teacoursedao = new TeacourseDao();
			List<UserBean> tea = new ArrayList<>();
			List<TeacourseBean> teaid = teacoursedao.executeQueryBycourse(new Object[]{id});
			for (TeacourseBean teacourseBean : teaid) {
				UserDao s = new UserDao();
				tea.add(s.executeQuerybyId(new Object[]{teacourseBean.getTea_id()}));
			}
			coursevm.setCourse(courseBean);
			coursevm.setStudents(stu);
			coursevm.setTeachers(tea);
			list.add(coursevm);
		}
		return list;
	}
	public void executeAdd(Object[] params) throws SQLException{
		String num = (String) params[0];
		String name = (String) params[1];
		String description = (String) params[2];
		Integer type = (Integer) params[3];
		String tea_id = (String) params[4];
		CourseDao coursedao = new CourseDao();
		coursedao.executeAdd(new Object[]{num,name,description,type,"new"});
		Integer course_id= coursedao.executeGetId(new Object[]{num,name,description,type,"new"});
		TeacourseDao teacoursedao = new TeacourseDao();
		teacoursedao.executeAdd(new Object[]{course_id, tea_id});
		return ;
	}
}
