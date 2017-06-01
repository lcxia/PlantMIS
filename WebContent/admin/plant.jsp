<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>植物</title>
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
	<table id="tablePlant" class="easyui-datagrid"
		style="width: auto; height: 410px"
		data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsPlant" url="AdminServlet?way=allPlant"
		singleSelect="true">
		<thead>
			<tr>
				<th data-options="field:'plantId',width:100">No</th>
				<th data-options="field:'plantName',width:100">植物</th>
				<th data-options="field:'plantText',width:100">简介</th>
				<th data-options="field:'phylumName',width:100">门</th>
				<th data-options="field:'className',width:100">纲</th>
				<th data-options="field:'orderName',width:100">目</th>
				<th data-options="field:'familyName',width:100">科</th>
				<th data-options="field:'genusName',width:100">属</th>
				<th data-options="field:'picture',width:100">图片</th>
			</tr>
		</thead>
	</table>
	<!-- 表格的工具栏 -->
	<div id="toolsPlant" style="height: 25px">
		<a id="btn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="addPlant()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true"
			onclick="deletePlant()">删除</a> <a id="btn" href="#"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true" onclick="editPlant()">修改</a>
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgPlant" class="easyui-dialog"
		data-options="iconCls:'icon-save'"
		style="width: 400px; height: 400px; padding: 10px" closed="true"
		buttons="#dlgPlant-buttons">
		<form id="formPlant" method="post" style="margin: 10px 5px 5px 60px"
			novalidate>
			<div class="fitem">
				<label>植物：</label> <input name="plantName" class="easyui-textbox"
					required="true">
			</div>
			<br>
			<div class="fitem">
				<label>简介：</label> <input name="plantText" class="easyui-textbox"
					required="true">
			</div>
			<br>
			<div class="fitem">
				<label>门&nbsp;&nbsp;：</label> <input name="phylumName" class="easyui-textbox"
					required="true">
			</div>
			<br>
			<div class="fitem">
				<label>纲&nbsp;&nbsp;：</label> <input name="className" class="easyui-textbox"
					required="true">
			</div>
			<br>
			<div class="fitem">
				<label>目&nbsp;&nbsp;：</label> <input name="orderName" class="easyui-textbox"
					required="true">
			</div>
			<br>
			<div class="fitem">
				<label>科&nbsp;&nbsp;：</label> <input name="familyName" class="easyui-textbox"
					required="true">
			</div>
			<br>
			<div class="fitem">
				<label>属&nbsp;&nbsp;：</label> <input name="genusName" class="easyui-textbox"
					required="true">
			</div>
			<br>
			<div class="fitem">
				<label>图片：</label> <input name="picture" class="easyui-textbox"
					required="true">
			</div>
		</form>
	</div>
	<!-- 对话框的按钮 -->
	<div id="dlgPlant-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="savePlant()" style="width: 90px">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlgPlant').dialog('close')"
			style="width: 90px">取消</a>
	</div>
</body>
</html>
