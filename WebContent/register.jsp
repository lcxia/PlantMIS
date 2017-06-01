<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<%@ page import="com.lhhy.bean.UserBean"%>
<!DOCTYPE HTML>
<html>
<head>
<title>植物资源管理系统</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="js/functions.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<%-- <%
		List<UserBean> list = (List<UserBean>) request.getAttribute("list");
	%> --%>
	<div id="login_allthings">
		<div id="table_style">
			<table width="400" height="300" border="0">
				<th colspan="2">注册信息</th>
				<tr>
					<td>
						<form action="UserServlet" method="post" name="form"
							onsubmit="return checkRegister()">
							<input type="hidden" name="way" value="register">
							<table style="border: 0; margin-left: 90px; line-height: 40px;">
								<tr>
									<td>用户名</td>
									<td><input name="username" type="text"></td>
								</tr>
								<tr>
									<td>密码</td>
									<td><input name="password" type="password"></td>
								</tr>
								<tr>
									<td>确认密码</td>
									<td><input name="passwordConfirm" type="password"></td>
								</tr>
								<tr>
									<td>手机号</td>
									<td><input name="phone" type="text"></td>
								</tr>
								<tr>
									<td align="center" colspan="2">
										<div id="loginandregist">
											<input type="submit" value="注册"> <span
												style="color: red">${msg}</span>
										</div> <a href="login.jsp">去登录</a>
									</td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>