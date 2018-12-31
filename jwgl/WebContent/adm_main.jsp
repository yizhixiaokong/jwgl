<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/standard/jwgl.css" type="text/css" media="all">
<link rel="stylesheet" href="style/base/jwgl.css" type="text/css" media="all">
<script src="js/showtime.js"></script>
<title>管理员登录</title>
</head>
<body  class="mainbody" onload="showtime()">
<%
    Object message = session.getAttribute("sucess");
    if(message!=null && !"".equals(message)){

 %>
     <script type="text/javascript">
         alert("<%=message%>");
     </script>
 <%} %>
	<div id="bodyDiv">
		<div id="headDiv">
			
		</div>
		<div id="mainDiv">
			
		</div>
		<div id="footerDiv">
			<div class="footer">
				<c:import url="copyright.jsp" />
			</div>
		</div>
	</div>
</body>
</html>