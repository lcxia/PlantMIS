<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>库资料</title>
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
	<table id="tableLibrary" class="easyui-datagrid"
		style="width: auto; height: 410px"
		data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsLibrary" url="AdminServlet?way=allLibrary"
		singleSelect="true">
		<thead>
			<tr>
				<th data-options="field:'libraryId',width:100">No</th>
				<th data-options="field:'publish',width:100">发表时间</th>
				<th data-options="field:'updateDate',width:100">更新时间</th>
				<th data-options="field:'writer',width:100">作者</th>
				<th data-options="field:'theme',width:100">类别</th>
				<th data-options="field:'libraryText',width:100">内容</th>
				<th data-options="field:'abst',width:100">摘要</th>
				<th data-options="field:'mainword',width:100">关键字</th>
				<th data-options="field:'come',width:100">出处</th>
				<th data-options="field:'libraryName',width:100">名称</th>
			</tr>
		</thead>
	</table>
	<!-- 表格的工具栏 -->
	<div id="toolsLibrary" style="height: 25px">
		<a id="btn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="addLibrary()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true"
			onclick="deleteLibrary()">删除</a> <a id="btn" href="#"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true" onclick="editLibrary()">修改</a>
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgLibrary" class="easyui-dialog"
		data-options="iconCls:'icon-save'"
		style="width: 400px; height: 400px; padding: 10px" closed="true"
		buttons="#dlgLibrary-buttons">
		<form id="formLibrary" method="post" style="margin: 35px 5px 5px 60px"
			novalidate>
			<div class="fitem">
				<label>发表时间：</label> <input name="publish" class="easyui-datebox"
					required="true">
			</div>
			<div class="fitem">
				<label>更新时间：</label> <input name="updateDate" class="easyui-datebox"
					data-options="required:true">
			</div>
			<div class="fitem">
				<label>作者：</label> <input name="writer" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>类别：</label> <input name="theme" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>内容：</label> <input name="libraryText" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>摘要：</label> <input name="mainword" class="easyui-textbox"
					data-options="required:true">
			</div>
			<div class="fitem">
				<label>关键字：</label> <input name="abst" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>出处：</label> <input name="come" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>名称：</label> <input name="libraryName" class="easyui-textbox"
					required="true">
			</div>
		</form>
	</div>
	<!-- 对话框的按钮 -->
	<div id="dlgLibrary-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveLibrary()" style="width: 90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlgLibrary').dialog('close')"
			style="width: 90px">取消</a>
	</div>
</body>
</html>
