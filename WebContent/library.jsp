<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<%@ page import="com.lhhy.bean.LibraryBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>植物资源知识仓库</title>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/functions.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>

<body>
	<div class="container">
		<div id="library_allthings">
			<jsp:include page="/common/logo.jsp"></jsp:include>
			<jsp:include page="/common/userBar.jsp"></jsp:include>
			<jsp:include page="/common/topBar.jsp"></jsp:include>
			<br>
			<form action="LibraryServlet?way=select" method="post" name="form"
				onsubmit="return checkLibrary()">
				<div id="table_style">
					<table id="lcx">
						<th style="text-align: left;" colspan="4">关键词&nbsp;&nbsp; <input
							type="text" name="libraryText"> <input type="submit"
							value="检索仓库">
						</th>
						<tr>
							<td><b>名称</b></td>
							<td><b>作者</b></td>
							<td width="500px"><b>关键字</b></td>
							<td><b>操作</b></td>
						</tr>
						<tr>
							<td colspan="4">${msg}</td>
						</tr>
						<c:forEach items="${list}" var="libraryBean">
							<tr>
								<td>${libraryBean.libraryName}</td>
								<td>${libraryBean.writer}</td>
								<td>${libraryBean.mainword}</td>
								<td><a
									href="LibraryServlet?way=detail&libraryId=${libraryBean.libraryId }"
									target="_blank">查看详情</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</form>
			<jsp:include page="/common/copyRight.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>