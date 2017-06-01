<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.lhhy.bean.PredictBean"%>
<%@ include file="/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统预测</title>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/functions.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<%-- <%
		List<PredictBean> list = (List<PredictBean>) request.getAttribute("list");
		PredictBean predictBean = (PredictBean) request.getAttribute("predictBean");
	%> --%>
	<div class="container">
		<div id="predict_allthings">
			<jsp:include page="/common/logo.jsp"></jsp:include>
			<jsp:include page="/common/userBar.jsp"></jsp:include>
			<jsp:include page="/common/topBar.jsp"></jsp:include>
			<form action="PredictServlet" method="post" name="form"
				onsubmit="return checkPredict()">
				<input type="hidden" name="way" value="predict"> <br>
				<div id="table_style">
					<table style="width: 1050px; height: 480px;">
						<th>农作物： <select name="plantName" style="width: 130px">
								<option value="0">${predictBean.plantName==null?"请选择":predictBean.plantName}</option>
								<c:forEach items="${list}" var="predictBean">
									<option value="${predictBean.plantName}">${predictBean.plantName}</option>
								</c:forEach>
						</select> <input type="submit" value="预测">
						</th>
						<tr>
							<td><img src="${graphURL}" border="0"></td>
						</tr>
					</table>
				</div>
			</form>
			<jsp:include page="/common/copyRight.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>