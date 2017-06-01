<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>植物问题</title>
<script type="text/javascript" src="../qeui141/jquery.min.js"></script>
<script type="text/javascript" src="../qeui141/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../qeui141/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<link href="../qeui141/themes/default/easyui.css" rel="stylesheet">
<link href="../qeui141/themes/icon.css" rel="stylesheet">
</head>
<body>
	<!-- 数据表格 -->
	<table id="tableProblem" class="easyui-datagrid"
		style="width: auto; height: 410px"
		data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsProblem" url="AdminServlet?way=allProblem"
		singleSelect="true">
		<thead>
			<tr>
				<th data-options="field:'problemId',width:100">No</th>
				<th data-options="field:'problemName',width:100">问题</th>
				<th data-options="field:'problemText',width:100">描述</th>
				<th data-options="field:'solution',width:100">解决方案</th>
				<th data-options="field:'picture',width:100">解决方案</th>
			</tr>
		</thead>
	</table>
	<!-- 表格的工具栏 -->
	<div id="toolsProblem" style="height: 25px">
		<a id="btn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="addProblem()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true"
			onclick="deleteProblem()">删除</a> <a id="btn" href="#"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true" onclick="editProblem()">修改</a>
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgProblem" class="easyui-dialog"
		data-options="iconCls:'icon-save'"
		style="width: 400px; height: 400px; padding: 10px" closed="true"
		buttons="#dlgProblem-buttons">
		<form id="formProblem" method="post" style="margin: 35px 5px 5px 60px"
			novalidate>
			<div class="fitem">
				<label>问题：</label> <input name="problemName" class="easyui-textbox"
					required="true">
			</div>
			<br>
			<div class="fitem">
				<label>描述：</label> <input name="problemText" class="easyui-textbox"
					required="true">
			</div>
			<br>
			<div class="fitem">
				<label>解决方案：</label> <input name="solution" class="easyui-textbox"
					required="true">
			</div>
		</form>
	</div>
	<!-- 对话框的按钮 -->
	<div id="dlgProblem-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveProblem()" style="width: 90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlgProblem').dialog('close')"
			style="width: 90px">取消</a>
	</div>
</body>
</html>
