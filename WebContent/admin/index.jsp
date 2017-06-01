<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理首页</title>
<script type="text/javascript" src="../qeui141/jquery.min.js"></script>
<script type="text/javascript" src="../qeui141/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../qeui141/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<link href="../qeui141/themes/ui-sunny/easyui.css" rel="stylesheet">
<link href="../qeui141/themes/icon.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<div id="accordion" class="easyui-layout"
		style="width: 1000px; height: 650px; margin-right: auto; margin-left: auto; position: absolute; top: 50%; left: 50%; margin: -325px 0 0 -500px;">
		<div data-options="region:'north'" style="height: 100px;">
			<h2>植物资源后台管理系统</h2>
			<b>您好！${sessionScope.userBean.userName }&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="../UserServlet?way=exit"><span>退出</span></a>
			</b>
		</div>
		<div data-options="region:'west',title:'管理目录',split:true"
			style="width: 140px;">
			<ul id="acc" class="easyui-tree">
				<li state="closed"><span>用户管理</span>
					<ul>
						<li><a href="#" onclick="addTab('用户','user.jsp')">用户</a></li>
					</ul></li>
				<li state="closed"><span>植物管理</span>
					<ul>
						<li><a href="#" onclick="addTab('植物信息','plant.jsp')">植物信息</a></li>
					</ul></li>
				<li state="closed"><span>数据分析管理</span>
					<ul>
						<li><a href="#" onclick="addTab('植物问题','problem.jsp')">植物问题</a>
						</li>
					</ul></li>
				<li state="closed"><span>系统预测管理</span>
					<ul>
						<li><a href="#" onclick="addTab('存活率','survive.jsp')">存活率</a>
						</li>
					</ul></li>
				<li state="closed"><span>知识仓库管理</span>
					<ul>
						<li><a href="#" onclick="addTab('库资料','library.jsp')">库资料</a>
						</li>
					</ul></li>
			</ul>
		</div>
		<div data-options="region:'center'"
			style="padding: 5px; background: #eee;">
			<div id="tab" class="easyui-tabs">
				<div title="welcome" href="url" closable="true"
					style="padding: 0px; display: none;"></div>
			</div>
		</div>
		<div data-options="region:'south',split:true" style="height: 100px;">
			<jsp:include page="/common/copyRight.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>