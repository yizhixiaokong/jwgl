<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="style/standard/jwgl.css" type="text/css" media="all">
<link rel="stylesheet" href="style/base/jwgl.css" type="text/css" media="all">
<script src="js/showtime.js"></script>
<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
</head>
<body class="login_bg" onload="showtime()">
	<%
	    Object message = request.getAttribute("message");
	    if(message!=null && !"".equals(message)){
	
	 %>
	     <script type="text/javascript">
	         alert("<%=message%>");
	     </script>
	 <% } %>
	<form action="Login" method="post" onsubmit="return check(this);">
		<div class="login_main">
			<c:import url="top1.jsp" />
			<div class="login_left">
				
			</div>
			<c:import url="login.jsp" />
			<c:import url="copyright.jsp" />
		</div>
	</form>
</body>
<script type="text/javascript">
	function check(form){
		if(form.RadioButtonList1.value!="访客"){
			if(form.userName.value==""||form.userPswd.value==""){
				alert("用户名或密码不能为空！");
				form.userName.focus();
				form.userPswd.focus();
				return false;
			}
			return true;
		}	
		return true;
	}
</script>
</html>
