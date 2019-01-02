<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>添加通知公告</title>
<style type="text/css">
ul {
	list-style: none; /*设置不显示项目符号*/
	margin: 0px; /*设置外边距*/
	padding: 5px; /*设置内边距*/
}

li {
	padding: 5px; /*设置内边距*/
}
</style>
</head>
<body>
	<form action="<c:url value="CourseServlet">
				<c:param name="action" value="add" />
			</c:url>" method="post">
		<ul>
			<li>课程编号：<input type="text" name="num" /></li>
			<li>课程名称：<input type="text" name="name" /></li>
			<li>课程类型：<select name="type">
				<option value="0">公共必修课</option>
				<option value="1">公共选修课</option>
				<option value="2">专业必修课</option>
				<option value="3">专业选修课</option>
			</select></li>
			<li>任课教师：<input type="text" name="tea_id" /></li>
			<li>课程描述：<textarea name = "description" style="width:300px;height:100px;"></textarea>
			<li>
				<input type="submit" value="添　加">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="返	回" onclick="location='<c:url value="CourseServlet">
				<c:param name="action" value="querynew" />
					</c:url>'">
			</li>
		</ul>
	</form>
</body>
</html>