<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知公告</title>
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
										<h2 style="background: #C7DEFC">
											<span class="titilebox"> <em> 通知公告 </em>
											</span>
										</h2>
										<div class="movebox_con">
											<table class="datelist" cellspacing="0" cellpadding="3"
												border="0" id="DataList1__ctl0_dataGrid1" width="100%">
												<tbody>
													<tr>
														<td>公告标题</td>
														<td>发布单位</td>
														<td>发布时间</td>
													</tr>
													<c:forEach var="news" items="${requestScope.list }">
														<tr>
															<form action="#" method="post">
															<td><c:out value="${news.news_name }" /></td>
															<td><c:out value="${news.news_danwei }" /></td>
															<td><c:out value="${news.news_time }" /> <c:if
																	test="${sessionScope.logoner.user_role == 1}">
																	<input type="hidden" name="id" value="${news.id }">
																	<input type="submit" value="删除"
																		style="float: right; margin-right: 2%;">
																</c:if></td>
															</form>
														</tr>
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