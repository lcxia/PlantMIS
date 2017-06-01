<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<%@ page import="com.lhhy.bean.PlantBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>植物界</title>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/functions.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript">
	$(document).ready(function() {
		getClass(); //获取纲
	});
</script>
</head>
<body>
	<div class="container">
		<div id="plantallthings">
			<jsp:include page="/common/logo.jsp"></jsp:include>
			<jsp:include page="/common/userBar.jsp"></jsp:include>
			<jsp:include page="/common/topBar.jsp"></jsp:include>
			<br>
			<div style="float: left;">
				<form action="PlantServlet" method="post" name="form">
					<table id="table_style">
						<th>按输入内容查找</th>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td><input type="text" name="text"> <input
								type="submit" value="查询" onclick="return submitSelect()">
							</td>
						</tr>
					</table>
					<br> <br> <br>
					<table id="table_style">
						<th>按条件查找</th>
						<tr>
							<td style="text-align: left"><br></td>
						</tr>
						<tr>
							<td style="text-align: left"><b>门：</b> <input type="text"
								value="被子植物门" disabled="true" style="width: 120px"></td>
						</tr>
						<tr>
							<td style="text-align: left"><b>纲：</b> <select name="class"
								id="class" style="width: 120px" onChange="getOrder(this.value)">
							</select></td>
						</tr>
						<tr>
							<td style="text-align: left"><b>目：</b> <select name="order"
								id="order" style="width: 120px"
								onChange="getFamily($('#class').val(),this.value)">
							</select></td>
						</tr>
						<tr>
							<td style="text-align: left"><b>科：</b> <select name="family"
								id="family" style="width: 120px"
								onChange="getGenus($('#class').val(),$('#order').val(),this.value)">
							</select></td>
						</tr>
						<tr>
							<td style="text-align: left"><b>属：</b> <select name="genus"
								id="genus" style="width: 120px"
								onChange="getPlant($('#class').val(),$('#order').val(),$('#family').val(),this.value)">
							</select></td>
						</tr>
						<tr>
							<td style="text-align: left"><input type="button" value="确定"
								style="margin: 10px 10px 10px 140px" onclick="submitPrecise()">
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div id="searchresult">
				<table id="table_style">
					<th colspan="4" width="900px">查找结果</th>
					<tr>
						<td>${msg}</td>
					</tr>
					<c:forEach items="${list}" var="plantBean">
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td rowspan="2"><a
								href="PlantServlet?way=detail&plantId=${plantBean.plantId}"
								target="_blank"> <img src="${plantBean.picture}" width="119"
									height="83" border="0" />
							</a></td>
							<td style="text-align: left"><a
								href="PlantServlet?way=detail&plantId=${plantBean.plantId}"
								target="_blank">${plantBean.plantName} </a></td>

						</tr>
						<tr>
							<td
								style="text-align: left; overflow: hidden; text-overflow: ellipsis; max-height: 200px;">
								<p id="plant_text">${plantBean.plantText}</p>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<br> <br>
		<jsp:include page="/common/copyRight.jsp"></jsp:include>
	</div>

</body>
</html>