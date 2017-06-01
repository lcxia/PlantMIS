<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>植物资源管理系统</title>
<script src="js/functions.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<div id="login_allthings">
		<div id="table_style">
			<table width="400" height="300">
				<th>登录信息</th>
				<tr>
					<td>
						<form method="post" action="UserServlet" name="form"
							onsubmit="return checkLogin()">
							<input type="hidden" name="way" value="login">
							<table style="border: 0; margin-left: 90px; line-height: 50px;">
								<tr>
									<td>用户名:</td>
									<td><input name="username" type="text" id="username"></td>
								</tr>
								<tr>
									<td align="right">密码:</td>
									<td><input name="password" type="password" id="password"></td>
								</tr>
							</table>
							<br>
							<div id="loginandregist">
								<input type="submit" value="登录"> <span
									style="color: red">${msg}</span>
							</div>
							<a href="register.jsp">注册新用户</a> <a
								href="update.jsp">忘记密码</a>
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>