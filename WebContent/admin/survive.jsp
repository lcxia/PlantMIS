<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>存活率</title>
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
	<table id="tableSurvive" class="easyui-datagrid"
		style="width: auto; height: 410px"
		data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsSurvive" url="AdminServlet?way=allSurvive"
		singleSelect="true">
		<thead>
			<tr>
				<th data-options="field:'surviveId',width:100">No</th>
				<th data-options="field:'surviveRate',width:100">存活率</th>
				<th data-options="field:'plantName',width:100">植物</th>
				<th data-options="field:'areaName',width:100">区域</th>
			</tr>
		</thead>
	</table>
	<!-- 表格的工具栏 -->
	<div id="toolsSurvive" style="height: 25px">
		<a id="btn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="addSurvive()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true"
			onclick="deleteSurvive()">删除</a> <a id="btn" href="#"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true" onclick="editSurvive()">修改</a>
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgSurvive" class="easyui-dialog"
		data-options="iconCls:'icon-save'"
		style="width: 400px; height: 400px; padding: 10px" closed="true"
		buttons="#dlgSurvive-buttons">
		<form id="formSurvive" method="post" style="margin: 35px 5px 5px 60px"
			novalidate>
			<div class="fitem">
				<label>存活率：</label> <input name="surviveRate"
					class="easyui-numberbox" required="true">
			</div>
			<br>
			<div class="fitem">
				<label>植物：</label> <input name="plantName" class="easyui-numberbox"
					required="true">
			</div>
			<br>
			<div class="fitem">
				<label>区域：</label> <input name="areaName" class="easyui-textbox"
					required="true">
			</div>
		</form>
	</div>
	<!-- 对话框的按钮 -->
	<div id="dlgSurvive-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveSurvive()" style="width: 90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlgSurvive').dialog('close')"
			style="width: 90px">取消</a>
	</div>
</body>
</html>