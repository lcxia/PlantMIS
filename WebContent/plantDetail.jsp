<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.lhhy.bean.PlantBean"%>
<%@ include file="/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>植物详情</title>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<%
		PlantBean plantBean = (PlantBean) request.getAttribute("plantBean");
	%>
	<div class="container">
		<div id="plant_detail_things">
			<jsp:include page="/common/logo.jsp"></jsp:include>
			<jsp:include page="/common/userBar.jsp"></jsp:include>
			<jsp:include page="/common/topBar.jsp"></jsp:include>
			<div style="margin: 10px 10px 10px 100px">
				<h2>${plantBean.plantName}</h2>
				<br>
				<div style="float: left; height: 300px">
					<img alt="正在载入" src="${plantBean.picture}">
				</div>
				<div
					style="float: left; height: 300px; margin: 30px 10px 10px 100px">
					<b>界：&nbsp;&nbsp;&nbsp;</b>植物界<br> <br> <b>门：&nbsp;&nbsp;&nbsp;</b>${plantBean.phylumName}<br>
					<br> <b>纲：&nbsp;&nbsp;&nbsp;</b>${plantBean.className}<br>
					<br> <b>目：&nbsp;&nbsp;&nbsp;</b>${plantBean.orderName}<br>
					<br> <b>科：&nbsp;&nbsp;&nbsp;</b>${plantBean.familyName}<br>
					<br> <b>属：&nbsp;&nbsp;&nbsp;</b>${plantBean.genusName}
				</div>
				<div style="overflow-y: scroll; height: 350px; width: 850px">${plantBean.plantText}</div>
			</div>
		</div>
		<jsp:include page="/common/copyRight.jsp"></jsp:include>
	</div>
</body>
</html>