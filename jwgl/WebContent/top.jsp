<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="login_logo">
				<img src="#" alt="教务管理系统">
				
		<div style="width:100%; text-align:center">
			<div id="top">
				<div id="greeting">
					<div  id="txt"></div>
				</div>
			</div>
		</div>		
</div>

<script language=JavaScript>
	var timerID = null;
	var timerRunning = false;
	function showtime() {
		var now = new Date();
		var h=now.getHours()
		var m=now.getMinutes()
		var s=now.getSeconds()
		var str=new String;
		if(h<5)str="凌晨";
		else if(h<8)str="早上";
		else if(h<11)str="上午";
		else if(h<13)str="中午";
		else if(h<17)str="下午";
		else str="晚上"
		document.getElementById('txt').innerHTML="您好，当前时间是"+str+h+"时"+m+"分"+s+"秒"
		timerID = setTimeout("showtime()", 1000);
		timerRunning = true;
	}
</script>