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
	<form action="<c:url value="NewsServlet">
				<c:param name="action" value="add" />
			</c:url>" method="post">
		<ul>
			<li>公告标题：<input type="text" name="newsName" /></li>
			<li>发布单位：<input type="text" name="newsDanwei" /></li>
			<li>发布时间：<input type="text" name="newsTime" /></li>
			<li>
				<input type="submit" value="添　加">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="返	回" onclick="location='<c:url value="NewsServlet">
				<c:param name="action" value="query" />
					</c:url>'">
			</li>
		</ul>
	</form>
</body>
</html>