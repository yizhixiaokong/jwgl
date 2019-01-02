<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上选课</title>
<link rel="stylesheet" href="style/standard/jwgl.css" type="text/css"
	media="all">
<link rel="stylesheet" href="style/base/jwgl.css" type="text/css"
	media="all">
</head>
<body>
	<div class="main_box">
		<div class="mid_box">
			<span class="formbox">
				<div class="portallet" style="WIDTH: 98%">
					<table id="DataList1" cellspacing="0" border="0" width="100%">
						<tbody>
							<tr>
								<td>
									<div class="movebox">
										<h2 style="background: #C7DEFC; opacity: 0.75;">
											<span class="titilebox"> <em> 查看课程 </em>
											</span>
										</h2>
										<div class="movebox_con">
											<table class="datelist" cellspacing="0" cellpadding="3"
												border="0" id="DataList1__ctl0_dataGrid1" width="100%">
												<tbody>
													<tr>
														<td>课程编号</td>
														<td>课程名称</td>
														<td>课程类型</td>
														<td>任课教师</td>
													</tr>
													<c:forEach var="courses" items="${requestScope.list }">
														<c:forEach var="tea" items="${courses.teachers }">
															<c:set var="s" value="true" />
															<c:forEach var="stu" items="${courses.students }">
																<c:if
																	test="${sessionScope.logoner.user_name == stu.user_name }">
																	<c:set var="s" value="false" />
																</c:if>
															</c:forEach>
															<c:if test="${s == true }">
																<tr>
																	<td><c:out value="${courses.course.num }" /></td>
																	<td><c:out value="${courses.course.name }" /></td>
																	<td><c:choose>
																			<c:when test="${courses.course.type==0}">
																				<c:out value="公共必修课" />
																			</c:when>
																			<c:when test="${courses.course.type==1}">
																				<c:out value="公共选修课" />
																			</c:when>
																			<c:when test="${courses.course.type==2}">
																				<c:out value="专业必修课" />
																			</c:when>
																			<c:when test="${courses.course.type==3}">
																				<c:out value="专业选修课" />
																			</c:when>
																			<c:otherwise>
																			</c:otherwise>
																		</c:choose></td>
																	<td><c:out value="${tea.user_name }" /></td>
																</tr>
															</c:if>
														</c:forEach>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</span>

		</div>
	</div>

</body>
</html>