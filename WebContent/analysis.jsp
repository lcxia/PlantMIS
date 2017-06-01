<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<%@ page import="com.lhhy.bean.AnalysisBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据分析</title>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/functions.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<%-- <%
		List<AnalysisBean> list = (List<AnalysisBean>) request.getAttribute("list");
		AnalysisBean analysisBean = (AnalysisBean) request.getAttribute("analysisBean");
	%> --%>
	<div class="container">
		<div id="analysis_allthings">
			<jsp:include page="/common/logo.jsp"></jsp:include>
			<jsp:include page="/common/userBar.jsp"></jsp:include>
			<jsp:include page="/common/topBar.jsp"></jsp:include>
			<div id="table_style">
				<br>
				<table>
					<th style="text-align: left;">危害介绍</th>
					<tr>
						<td>
							<div id="big">
								<span>大</span> 多数侵害植物的害虫都很细小，比如螨，用放大镜放大几十倍才能看见它们，它们以吸吮植物液汁维生。
								这些小虫或蛾伤害植株，使植株叶片变黄变形。咀嚼类的昆虫嚼食叶缘，在叶片上蚕食成洞，也侵害茎和生长点。
								潜叶虫的蛆吃掉叶的内部组织，造成暗沟。 同时，其他种类的害虫在幼虫阶段，也可能侵害植物的土内部分，使植物枯萎。
								任何植物都可能被虫害侵袭，因此要经常检查植株，看看是否有发生病害的迹象。
								一旦发现，应根据植株病态，找到原因所在，及时采取补救措施。 换盆时，要注意根、茎和叶的连接处以及木质茎表皮的裂缝。
							</div>
						</td>
					</tr>
				</table>
				<br>
				<form action="AnalysisServlet?way=analysis" method="post"
					name="form" onsubmit="return checkProblem()">
					<table style="width: 1050px; height: 400px;">
						<th style="text-align: left;">植物病虫害： <select name="problemId"
							style="width: 200px;">
								<option value="0">${analysisBean.problemName==null?"请选择":analysisBean.problemName}</option>
								<c:forEach items="${list}" var="analysisBean">
									<option value="${analysisBean.problemId}">${analysisBean.problemName}</option>
								</c:forEach>
						</select> <input type="submit" value="分析">
						</th>
						<tr>
							<td>
								<div style="float: left; width: 450px">
									<img alt="正在载入" src="${analysisBean.picture }">
								</div>
								<div style="float: left; width: 500px">
									<div style="text-align: left; margin: 30px 0px 0px 0px">
										<b>描述：</b><br>${analysisBean.problemText}</div>
									<div style="text-align: left; margin: 50px 10px 10px 0px">
										<b>防治：</b><br>${analysisBean.solution}</div>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<jsp:include page="/common/copyRight.jsp"></jsp:include>
	</div>
</body>
</html>