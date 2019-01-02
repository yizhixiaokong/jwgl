package bean.vm;

import java.util.List;

import bean.UserBean;
import bean.CourseBean;

public class CourseVMBean {
	private CourseBean course;
	private List<UserBean> teachers;
	private List<UserBean> students;
	public CourseBean getCourse() {
		return course;
	}
	public void setCourse(CourseBean course) {
		this.course = course;
	}
	public List<UserBean> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<UserBean> teachers) {
		this.teachers = teachers;
	}
	public List<UserBean> getStudents() {
		return students;
	}
	public void setStudents(List<UserBean> students) {
		this.students = students;
	}
	
}
