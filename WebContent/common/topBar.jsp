<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<div id="topbar">
	<ul>
		<li><div class="topbar_li">
				<a href="IndexServlet">首页</a>
			</div></li>
		<li><div class="topbar_li">
				<a href="PlantServlet?way=initial">植物界</a>
			</div></li>
		<li><div class="topbar_li">
				<a href="AnalysisServlet?way=initial">数据分析</a>
			</div></li>
		<li><div class="topbar_li">
				<a href="PredictServlet?way=initial">系统预测</a>
			</div></li>
		<li><div class="topbar_li">
				<a href="LibraryServlet?way=initial">知识仓库</a>
			</div></li>
	</ul>
</div>