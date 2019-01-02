<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="bean.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="rightDiv">
	<div >
		
		
		<iframe id="iframeautoheight" class="rightcontiframe" name="zhuti"
			allowtransparency src="
			<c:url value="NewsServlet">
			<c:param name="action" value="query" />
			</c:url>" 
			scrolling="yes" frameborder="0"
			marginwidth="0" marginheight="0" height="400" >
				
			 </iframe>
	</div>
</div>