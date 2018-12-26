<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link rel="stylesheet" href="style/standard/jwgl.css" type="text/css" media="all">
<link rel="stylesheet" href="style/base/jwgl.css" type="text/css" media="all">
</head>
<body class="login_bg" onload="showtime()">
	<form>
		<div class="login_main">
			<c:import url="top.jsp" />
			<div class="login_left">
				<img class="login_pic" src="#" alt="左半边">
			</div>
			<c:import url="login.jsp" />
			<c:import url="copyright.jsp" />
		</div>
	</form>
</body>
</html>