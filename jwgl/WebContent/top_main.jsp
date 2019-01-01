<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="bean.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 顶部 -->
<div class="head">
	<div class="logo">
		<img src="logo/main_jw.png" alt="图标">
	</div>
	<form>
		<div class="info">
			<c:choose>
				<c:when test="${sessionScope.logoner.user_role == 0}">
					<ul>
						<li>当前未登陆，是否登陆？</li>
						<li><a href="logout.jsp">立即登录</a></li>
					</ul>
					<ul id="time">
					</ul>
				</c:when>
				<c:otherwise>
					<ul>
						<li>欢迎您： <lable style="color:purple; font-weight:bold;">${sessionScope.logoner.user_name }</lable>
							&nbsp;&nbsp;!
						</li>
						<li><a href="logout.jsp" style="color: purple;">安全退出</a></li>
					</ul>
					<ul id="time">
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</form>
</div>

<!-- 导航 -->
<ul class="nav">
	<li class="top"><a class="top_link"> <span class="down">通知公告</span>
	</a></li>
	<c:choose>
		<c:when test="${sessionScope.logoner.user_role == 0}">
			<li class="top"><a href="logout.jsp" class="top_link"> <span class="down">立即登录</span>
			</a></li>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${sessionScope.logoner.user_role == 1}">
					<li class="top"><a href="#" class="top_link"> <span
							class="down">课程管理</span>
					</a>
						<ul class="sub">
							<li><a>公共选修课</a></li>
							<li><a>专业选修课</a></li>
						</ul></li>
				</c:when>
				<c:when test="${sessionScope.logoner.user_role == 2}">
					<li class="top"><a href="#" class="top_link"> <span
							class="down">成绩录入</span>
					</a>
						<ul class="sub">
							<li><a>公共选修课</a></li>
							<li><a>专业选修课</a></li>
						</ul></li>
				</c:when>
				<c:when test="${sessionScope.logoner.user_role == 3}">
					<li class="top"><a href="#" class="top_link"> <span
							class="down">网上选课</span>
					</a>
						<ul class="sub">
							<li><a>公共选修课</a></li>
							<li><a>专业选修课</a></li>
						</ul></li>
					<li class="top"><a href="#" class="top_link"> <span
							class="down">教务质量评价</span>
					</a>
						<ul class="sub">
							<li><a>教务质量评价</a></li>
						</ul></li>
				</c:when>
			</c:choose>

			<li class="top"><a href="#" class="top_link"> <span
					class="down">信息查询</span>
			</a>
				<ul class="sub">
					<c:choose>
						<c:when test="${sessionScope.logoner.user_role == 3}">
							<li><a>成绩查询</a></li>
							<li><a>选课情况查询</a></li>
							<li><a>临时调课查询</a></li>
						</c:when>
						<c:when test="${sessionScope.logoner.user_role == 2}">
							<li><a>教学任务查询</a></li>
							<li><a>教学质量评价查询</a></li>
						</c:when>
						<c:otherwise>
							<li><a>查询</a></li>
						</c:otherwise>
					</c:choose>
				</ul></li>
			<li class="top"><a href="#" class="top_link"> <span
					class="down">信息维护</span>
			</a>
				<ul class="sub">
					<c:choose>
						<c:when test="${sessionScope.logoner.user_role == 1}">
							<li><a>调课申请列表</a></li>
						</c:when>
						<c:otherwise>
							<li><a>个人信息修改</a></li>
							<li><a>密码修改</a></li>
							<c:choose>
								<c:when test="${sessionScope.logoner.user_role == 2}">
									<li><a>临时调课申请</a></li>
								</c:when>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</ul></li>
		</c:otherwise>
	</c:choose>


</ul>