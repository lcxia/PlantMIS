<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户</title>
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
	<table id="tableUser" class="easyui-datagrid"
		style="width: auto; height: 410px"
		data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true"
		pagination="true" toolbar="#toolsUser" url="AdminServlet?way=allUser"
		singleSelect="true">
		<thead>
			<tr>
				<th data-options="field:'userId',width:100">No</th>
				<th data-options="field:'userName',width:100">用户名</th>
				<th data-options="field:'password',width:100">密码</th>
				<th data-options="field:'roleName',width:100">角色</th>
				<th data-options="field:'phone',width:100">电话</th>
			</tr>
		</thead>
	</table>
	<!-- 表格的工具栏 -->
	<div id="toolsUser" style="height: 25px">
		<a id="btn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true" onclick="addUser()">添加</a>
		<a id="btn" href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true"
			onclick="deleteUser()">删除</a> <a id="btn" href="#"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-edit',plain:true" onclick="editUser()">修改</a>
	</div>
	<!-- 弹出的对话框 -->
	<div id="dlgUser" class="easyui-dialog"
		data-options="iconCls:'icon-save'"
		style="width: 400px; height: 400px; padding: 10px" closed="true"
		buttons="#dlgUser-buttons">
		<form id="formUser" method="post" style="margin: 80px 5px 5px 60px"
			novalidate>
			<div class="fitem">
				<label>用户名：</label> <input name="userName" class="easyui-textbox"
					required="true">
			</div>
			<br>
			<div class="fitem">
				<label>密&nbsp;&nbsp;&nbsp;码：</label> <input name="password" type="password"
					class="easyui-textbox" data-options="required:true">
			</div>
			<br>
			<!-- <div class="fitem">
				<label>角色：</label> <input name="roleName" class="easyui-textbox"
					required="true">
					<select name="roleName">
						<option value="管理员">管理员</option>
						<option value="用户">用户</option>
					</select>
			</div> 
			<br>-->
			<div class="fitem">
				<label>电&nbsp;&nbsp;&nbsp;话：</label> <input name="phone" class="easyui-numberbox"
					required="true">
			</div>
		</form>
	</div>
	<!-- 对话框的按钮 -->
	<div id="dlgUser-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" onclick="saveUser()" style="width: 90px">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#dlgUser').dialog('close')"
			style="width: 90px">取消</a>
	</div>
</body>
</html>