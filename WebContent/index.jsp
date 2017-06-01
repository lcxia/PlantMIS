<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<%@ page import="com.lhhy.bean.PlantBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>植物资源管理系统</title>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/functions.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
	<div class="container">
		<div id="allthings">
			<jsp:include page="/common/logo.jsp"></jsp:include>
			<jsp:include page="/common/userBar.jsp"></jsp:include>
			<jsp:include page="/common/topBar.jsp"></jsp:include>
			<div id="left">
				<div id="table_style">
					<br>
					<table>
						<th>植物欣赏</th>
						<tr>
							<td>
								<table>
									<tr>
										<c:forEach items="${list }" var="plantBean" varStatus="i">
											<td><a
												href="PlantServlet?way=detail&plantId=${plantBean.plantId }"
												target="_blank"> <img
													onmouseover="ShowFloatingImage(this, 150, 150);"
													width="260px" height="auto" alt="正在载入"
													src="${plantBean.picture }"> <br>
													${plantBean.plantName }
											</a></td>
											<c:if test="${i.count%3==0}">
									</tr>
									<tr>
										</c:if>
										</c:forEach>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div id="right_top">
				<div id="table_style">
					<jsp:include page="/common/consult.jsp"></jsp:include>
					<div id="right_bottom">
						<div id="table_style">
							<table>
								<th>相关网站</th>
								<tr>
									<td>
										<div>
											<a href="http://db.kib.ac.cn/eflora/Default.aspx"
												target="_blank">中国植物物种数据库</a>
										</div>
										<div>
											<a href="http://www.plantphoto.cn" target="_blank">中国植物图像库</a>
										</div>
										<div>
											<a href="http://www.ibcas.ac.cn" target="_blank">中国科学院植物研究所</a>
										</div>
										<div>
											<a href="http://www.iplant.cn" target="_blank">中国植物物种信息系统</a>
										</div>
										<div>
											<a href="http://www.bbioo.com/experiment/10-555-1.html"
												target="_blank">生物秀</a>
										</div>
									</td>
								</tr>
							</table>
						</div>
					</div>
					<div id="backtotop">
						<a href="javascript:scrollTo(0,0)"> <span>返回顶部</span></a>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/common/copyRight.jsp"></jsp:include>
	</div>
</body>
</html>