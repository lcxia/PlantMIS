<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.lhhy.bean.UserBean"%>
<%@ include file="/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
<script src="js/functions.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<%-- <%
		UserBean userBean = (UserBean) request.getAttribute("userBean");
	%> --%>
	<div id="login_allthings">
		<div id="table_style">
			<table width="400" height="300">
				<th colspan="2">忘记密码</th>
				<tr>
					<td>
						<form action="UserServlet" method="post" name="form"
							onsubmit="return checkUpdate()">
							<input type="hidden" name="way" value="update">
							<table style="border: 0; margin-left: 90px; line-height: 50px;">
								<tr>
									<td>用户名:</td>
									<td><input type="text" name="username"
										value="${userBean.userName }"></td>
								</tr>
								<tr>
									<td align="center" colspan="2"><div id="loginandregist">
											<br> <input type="submit" value="获取新密码"> <a
												href="login.jsp">去登录</a>
										</div></td>
								</tr>
								<tr>
									<td align="center" colspan="2"><br> <span>${userBean.password }</span>
										<span style="color: red">${msg}</span></td>
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