<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<div id="userbar">
	<div id="login">
		<br> <br>
		<c:choose>
			<c:when test="${sessionScope.userBean.userName==null}">
				<a href="register.jsp"><span>注册新用户</span></a>
				<a href="login.jsp"><span>登录</span></a>
			</c:when>
			<c:when test="${sessionScope.userBean.userName!=null}">
				您好！${sessionScope.userBean.userName }
				<a href="UserServlet?way=exit"><span>退出</span></a>
				<!-- <a href="IndexServlet?way=exit"><span>退出</span></a> -->
				<!-- <a href="UserServlet?way=login"><span>去管理</span></a> -->
			</c:when>
		</c:choose>
	</div>
	<div id="timeshow">
		<br>
		<script type="text/javascript">
			$(document).ready(
					function() {
						window.setInterval(
								"$('#timeBar').load('common/timeBar.jsp',{});",
								1000);
					});
		</script>
		<div id="timeBar">正在获取时间...</div>
		<br>
	</div>
</div>