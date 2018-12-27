<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="login_right">
				<dl style="color: black;text-shadow:1px 1px 1px #FFFFFF,1px -1px 1px #FFFFFF,-1px 1px 1px #FFFFFF;-1px -1px 1px #FFFFFF";">
					<dt class="uesr">
						<label>用户名：</label>
					</dt>
					<dd>
						<input name="TextBox1" type="text" id="TextBox1" tabindex="1" class="text_nor">
					</dd>
					<dt class="passw">
						<label>密　码：</label>
					</dt>
					<dd class="yzm">
						<input name="TextBox2" type="password" id="TextBox2" tabindex="2" class="text_nor">
					</dd>
					<dd>
						<table id="RadioButtonList1" border="0">
							<tbody>
								<tr>
									<td>
										<input id="RadioButtonList1_0" type="radio" name="RadioButtonList1" value="管理员" tabindex="3">
										<label for="RadioButtonList1_0">管理员</label>
									</td>
									<td>
										<input id="RadioButtonList1_1" type="radio" name="RadioButtonList1" value="教师" tabindex="3">
										<label for="RadioButtonList1_1">教师</label>
									</td>
									<td>
										<input id="RadioButtonList1_2" type="radio" name="RadioButtonList1" value="学生" checked="checked" tabindex="3">
										<label for="RadioButtonList1_2">学生</label>
									</td>
									<td>
										<input id="RadioButtonList1_3" type="radio" name="RadioButtonList1" value="访客" tabindex="3">
										<label for="RadioButtonList1_3">访客</label>
									</td>
								</tr>
							</tbody>
						</table>
					</dd>
					<dd>
						<input type="submit" name="Button1" value="" id="Button1" class="btn_dl">
						<input type="reset" name="Button2" value="" id="Button2" class="btn_cz">
					</dd>
				</dl>
			</div>