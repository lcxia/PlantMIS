<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<%@ page import="com.lhhy.bean.LibraryBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库资料详情</title>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<%-- <%
		LibraryBean libraryBean = (LibraryBean) request.getAttribute("libraryBean");
	%> --%>
	<div class="container">
		<div id="library_detail_allthings">
			<jsp:include page="/common/logo.jsp"></jsp:include>
			<jsp:include page="/common/userBar.jsp"></jsp:include>
			<jsp:include page="/common/topBar.jsp"></jsp:include>
			<div style="margin: 10px 10px 10px 100px; width: 850px">
				<h2>${libraryBean.libraryName}</h2>
				<br> <b>发表时间：</b>${libraryBean.publish}<br> <b>更新时间：</b>${libraryBean.updateDate}<br>
				<b>作&nbsp;&nbsp;&nbsp;者&nbsp;&nbsp;&nbsp;&nbsp;：</b>${libraryBean.writer}<br>
				<b>主&nbsp;&nbsp;&nbsp;题&nbsp;&nbsp;&nbsp;&nbsp;：</b>${libraryBean.theme}<br>
				<b>关键字&nbsp;&nbsp;&nbsp;&nbsp;：</b>${libraryBean.mainword}<br>
				<b>摘&nbsp;&nbsp;&nbsp;要&nbsp;&nbsp;&nbsp;&nbsp;：</b>${libraryBean.abst}<br>
				<b>出&nbsp;&nbsp;&nbsp;处&nbsp;&nbsp;&nbsp;&nbsp;：</b>${libraryBean.come}<br>
				<br> <br>
				<div style="overflow-y: scroll; height: 300px; width: 850px">${libraryBean.libraryText}</div>
			</div>
			<jsp:include page="/common/copyRight.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>