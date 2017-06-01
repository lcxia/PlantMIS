function GetAbsPosition(obj) {
	var curleft = 0, curtop = 0;
	do {
		curleft += obj.offsetLeft;
		curtop += obj.offsetTop;
	} while (obj = obj.offsetParent);
	return [ curleft, curtop ];
}
function ShowFloatingImage(image, width, height) {
	var id = "trailimageid";
	var newdiv = document.getElementById(id);
	if (newdiv == null) {
		newdiv = document.createElement('div');
		newdiv.setAttribute('id', id);
		newdiv.setAttribute('onmouseout', "HideElement('" + id + "');");
		document.body.appendChild(newdiv);
	}
	newdiv.innerHTML = '<img src=' + image.src + ' width='
			+ (image.width + width) + ' height=' + (image.height + height)
			+ ' />';
	var absPos = GetAbsPosition(image);
	newdiv.style.position = "absolute";
	newdiv.style.posLeft = absPos[0] - width / 2;
	newdiv.style.posTop = absPos[1] - height / 2;
	/*
	 * var imgleft = $(this).position().left; 
	 * var imgtop =$(this).position().top; 
	 * newdiv.style.posLeft = imgleft;
	 * newdiv.style.posTop = imgtop+300;
	 */
	newdiv.style.display = "block";
}
function HideElement(id) {
	var elem = document.getElementById(id);
	elem.style.display = "none";
}

function submitSelect() {
	if (form.text.value == "") {
		alert("查询内容不能为空");
		form.text.focus();
		return false;
	}
	/*if (form.text.value.length <= 1) {
		alert("查询内容至2少为个字符");
		form.text.focus();
		return false;
	} */else {
		document.form.action = "PlantServlet?way=select";
		document.form.submit();
		return true;
	}
}
function submitPrecise() {
	document.form.action = "PlantServlet?way=precise";
	document.form.submit();
}

/** ********************************************************************************************************** */
// 获取纲
function getClass() {
	$.ajax({
		url : "PlantServlet?way=class&nocache=" + new Date().getTime(),
		// 设置请求成功时执行的回调函数
		success : function(data) {
			classArr = data.split(","); // 将获取的纲名称字符串分隔为数组
			$("#class").empty(); // 清空下拉列表
			for (i = 0; i < classArr.length; i++) { // 通过循环将数组中的纲名称添加到下拉列表中
				$("#class").append(
						"<option value='" + classArr[i] + "'>" + classArr[i]
								+ "</option>");
			}
			if (classArr[0] != "") {
				getOrder(classArr[0]); // 获取目
			}
		}
	});
}

/** ********************************************************************************************************** */
// 获取目
function getOrder(selClass) {
	$.ajax({
		url : "PlantServlet?way=order&parClass=" + encodeURIComponent(selClass)
				+ "&nocache=" + new Date().getTime(),
		// 设置请求成功时执行的回调函数
		success : function(data) {
			orderArr = data.split(",");
			$("#order").empty(); // 清空下拉列表
			for (i = 0; i < orderArr.length; i++) { // 通过循环将数组中名称添加到下拉列表中
				$("#order").append(
						"<option value='" + orderArr[i] + "'>" + orderArr[i]
								+ "</option>");
			}
			if (orderArr[0] != "") {
				getFamily($("#class").val(), orderArr[0]); 
			}
		}
	});
}
/** ********************************************************************************************************** */
// 获取科
function getFamily(selClass, selOrder) {
	$.ajax({
		url : "PlantServlet?way=family&parClass="
				+ encodeURIComponent(selClass) + "&parOrder="
				+ encodeURIComponent(selOrder) + "&nocache="
				+ new Date().getTime(),
		// 设置请求成功时执行的回调函数
		success : function(data) {
			familyArr = data.split(","); // 将获取的名称字符串分隔为数组
			$("#family").empty(); // 清空下拉列表
			for (i = 0; i < familyArr.length; i++) { // 通过循环将数组中的名称添加到下拉列表中
				$("#family").append(
						"<option value='" + familyArr[i] + "'>" + familyArr[i]
								+ "</option>");
			}
			if (familyArr[0] != "") {
				getGenus($("#class").val(), $("#order").val(), familyArr[0]); 
			}
		}
	});
}
/** ************************************************************************* */
// 获取属
function getGenus(selClass, selOrder, selFamily) {
	$.ajax({
		url : "PlantServlet?way=genus&parClass=" + encodeURIComponent(selClass)
				+ "&parOrder=" + encodeURIComponent(selOrder) + "&parFamily="
				+ encodeURIComponent(selFamily) + "&nocache="
				+ new Date().getTime(),
		// 设置请求成功时执行的回调函数
		success : function(data) {
			genusArr = data.split(","); // 将获取的名称字符串分隔为数组
			$("#genus").empty(); // 清空下拉列表
			for (i = 0; i < genusArr.length; i++) { // 通过循环将数组中的名称添加到下拉列表中
				$("#genus").append(
						"<option value='" + genusArr[i] + "'>" + genusArr[i]
								+ "</option>");
			}
		}
	});
}

function checkProblem() {
	if (form.problemId.value == 0) {
		alert("请选择一项病虫害");
		form.problemId.focus();
		return false;
	} else {
		return true;
	}
}

function checkPredict() {
	if (form.plantId.value == 0) {
		alert("请选择一种农作物");
		form.plantId.focus();
		return false;
	} else {
		return true;
	}
}

function checkLibrary() {
	if (form.mainword.value == "") {
		alert("请输入关键字");
		form.mainword.focus();
		return false;
	} else {
		return true;
	}
}

function checkLogin() {
	if (form.username.value == "") {
		alert("用户名不能为空");
		form.username.focus();
		return false;
	}
	if (form.password.value == "") {
		alert("密码不能为空");
		form.password.focus();
		return false;
	} else {
		return true;
	}
}

function checkRegister() {
	if (form.username.value == "") {
		alert("用户名不能为空");
		form.username.focus();
		return false;
	}
	if (form.password.value == "") {
		alert("密码不能为空");
		form.password.focus();
		return false;
	}
	if (form.passwordConfirm.value == "") {
		alert("确认密码不能为空");
		form.passwordConfirm.focus();
		return false;
	}
	/*if (form.passwordConfirm.value.equals(form.password.value)==false) {
		alert("密码不一致");
		form.passwordConfirm.focus();
		return false;
	}*/
	if (form.statusId.value == 0) {
		alert("请选择一种身份");
		form.statusId.focus();
		return false;
	}
	if (form.phone.value == "") {
		alert("手机号不能为空");
		form.phone.focus();
		return false;
	}
	if (form.phone.value != "") {
		var p = /^1[34578]\d{9}$/;
		var phone = form.phone.value;
		if (p.test(phone) == false) {
			alert("手机号错误");
			form.phone.focus();
			return false;
		}
	}
	if (form.mail.value == "") {
		alert("邮箱不能为空");
		form.mail.focus();
		return false;
	} else {
		return true;
	}
}

function checkUpdate() {
	if (form.username.value == "") {
		alert("用户名不能为空");
		form.username.focus();
		return false;
	} else {
		return true;
	}
}

// 定义1个记录地址的全局变量
var url;
/**
 * 添加tabs
 */
function addTab(title, url) {
	if ($('#tab').tabs('exists', title)) {
		$('#tab').tabs('select', title);
	} else {
		$('#tab').tabs('add', {
			title : title,
			href : url,
			closable : true
		});
	}
}

/**
 * 添加用户dialog
 */
function addUser() {
	// 打开对话框
	$('#dlgUser').dialog('open').dialog('setTitle', '添加用户');
	// 清空表单的内容
	$('#formUser').form('clear');
	// 设置保存的地址
	url = "AdminServlet?way=addUser";
}
/**
 * 保存用户的函数
 */
function saveUser() {
	$('#formUser').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(data) {
			var result = eval('(' + data + ')');
			if (result.errorMsg) {
				$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});
			} else {
				// 关闭对话框
				$('#dlgUser').dialog('close');
				// 重载数据
				$('#tableUser').datagrid('reload');
			}
		}
	});
}

/**
 * 修改用户弹出对话框的信息
 */
function editUser() {
	var row = $('#tableUser').datagrid('getSelected');// 获得数据表中选中的数据行
	if (row) {
		$('#dlgUser').dialog('open').dialog('center')
				.dialog('setTitle', '修改用户');
		$('#formUser').form('load', row);// 选中行的信息，填充到表格中
		url = 'AdminServlet?way=editUser&userId=' + row.userId;// 将选中行的id传到指定地点
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要修改的数据'
		});
	}
}

/**
 * 删除用户弹出对话框的信息
 */
function deleteUser() {
	var row = $('#tableUser').datagrid('getSelected');
	if (row) {
		$.messager.confirm('confirm', '是否删除？', function(r) {
			if (r) {
				// $.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('AdminServlet?way=delUser', {
					userId : row.userId
				}, function(data) {
					if (data.success) {
						$.messager.show({
							title : '提示',
							msg : data.errorMsg
						});
						$('#tableUser').datagrid('reload');
					} else {
						$.messager.show({
							title : 'Error',
							msg : data.errorMsg
						});
					}
				}, 'json');
			}
		});
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要删除的数据'
		});
	}
}
/**
 * 添加存活率dialog
 */
function addSurvive() {
	// 打开对话框
	$('#dlgSurvive').dialog('open').dialog('setTitle', '添加存活率');
	// 清空表单的内容
	$('#formSurvive').form('clear');
	// 设置保存的地址
	url = "AdminServlet?way=addSurvive";
}
/**
 * 保存存活率的函数
 */
function saveSurvive() {
	$('#formSurvive').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(data) {
			var result = eval('(' + data + ')');
			if (result.errorMsg) {
				$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});
			} else {
				// 关闭对话框
				$('#dlgSurvive').dialog('close');
				// 重载数据
				$('#tableSurvive').datagrid('reload');
			}
		}
	});
}

/**
 * 修改存活率弹出对话框的信息
 */
function editSurvive() {
	var row = $('#tableSurvive').datagrid('getSelected');// 获得数据表中选中的数据行
	if (row) {
		$('#dlgSurvive').dialog('open').dialog('center').dialog('setTitle',
				'修改存活率');
		$('#formSurvive').form('load', row);// 选中行的信息，填充到表格中
		url = 'AdminServlet?way=editSurvive&surviveId=' + row.surviveId;// 将选中行的id传到指定地点
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要修改的数据'
		});
	}
}

/**
 * 删除存活率弹出对话框的信息
 */
function deleteSurvive() {
	var row = $('#tableSurvive').datagrid('getSelected');
	if (row) {
		$.messager.confirm('confirm', '是否删除？', function(r) {
			if (r) {
				// $.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('AdminServlet?way=delSurvive', {
					surviveId : row.surviveId
				}, function(data) {
					if (data.success) {
						$.messager.show({
							title : '提示',
							msg : data.errorMsg
						});
						$('#tableSurvive').datagrid('reload');
					} else {
						$.messager.show({
							title : 'Error',
							msg : data.errorMsg
						});
					}
				}, 'json');
			}
		});
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要删除的数据'
		});
	}
}
/**
 * 添加问题dialog
 */
function addProblem() {
	// 打开对话框
	$('#dlgProblem').dialog('open').dialog('setTitle', '添加问题');
	// 清空表单的内容
	$('#formProblem').form('clear');
	// 设置保存的地址
	url = "AdminServlet?way=addProblem";
}
/**
 * 保存问题的函数
 */
function saveProblem() {
	$('#formProblem').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(data) {
			var result = eval('(' + data + ')');
			if (result.errorMsg) {
				$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});
			} else {
				// 关闭对话框
				$('#dlgProblem').dialog('close');
				// 重载数据
				$('#tableProblem').datagrid('reload');
			}
		}
	})
}

/**
 * 修改问题弹出对话框的信息
 */
function editProblem() {
	var row = $('#tableProblem').datagrid('getSelected');// 获得数据表中选中的数据行
	if (row) {
		$('#dlgProblem').dialog('open').dialog('center').dialog('setTitle',
				'修改问题');
		$('#formProblem').form('load', row);// 选中行的信息，填充到表格中
		url = 'AdminServlet?way=editProblem&problemId=' + row.problemId;// 将选中行的id传到指定地点
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要修改的数据'
		});
	}
}

/**
 * 删除问题弹出对话框的信息
 */
function deleteProblem() {
	var row = $('#tableProblem').datagrid('getSelected');
	if (row) {
		$.messager.confirm('confirm', '是否删除？', function(r) {
			if (r) {
				// $.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('AdminServlet?way=delProblem', {
					problemId : row.problemId
				}, function(data) {
					if (data.success) {
						$.messager.show({
							title : '提示',
							msg : data.errorMsg
						});
						$('#tableProblem').datagrid('reload');
					} else {
						$.messager.show({
							title : 'Error',
							msg : data.errorMsg
						});
					}
				}, 'json');
			}
		});
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要删除的数据'
		});
	}
}
/**
 * 添加植物dialog
 */
function addPlant() {
	// 打开对话框
	$('#dlgPlant').dialog('open').dialog('setTitle', '添加植物');
	// 清空表单的内容
	$('#formPlant').form('clear');
	// 设置保存的地址
	url = "AdminServlet?way=addPlant";
}
/**
 * 保存植物的函数
 */
function savePlant() {
	$('#formPlant').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(data) {
			var result = eval('(' + data + ')');
			if (result.errorMsg) {
				$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});
			} else {
				// 关闭对话框
				$('#dlgPlant').dialog('close');
				// 重载数据
				$('#tablePlant').datagrid('reload');
			}
		}
	})
}

/**
 * 修改植物弹出对话框的信息
 */
function editPlant() {
	var row = $('#tablePlant').datagrid('getSelected');// 获得数据表中选中的数据行
	if (row) {
		$('#dlgPlant').dialog('open').dialog('center').dialog('setTitle',
				'修改植物');
		$('#formPlant').form('load', row);// 选中行的信息，填充到表格中
		url = 'AdminServlet?way=editPlant&plantId=' + row.plantId;// 将选中行的id传到指定地点
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要修改的数据'
		});
	}
}

/**
 * 删除植物弹出对话框的信息
 */
function deletePlant() {
	var row = $('#tablePlant').datagrid('getSelected');
	if (row) {
		$.messager.confirm('confirm', '是否删除？', function(r) {
			if (r) {
				// $.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('AdminServlet?way=delPlant', {
					plantId : row.plantId
				}, function(data) {
					if (data.success) {
						$.messager.show({
							title : '提示',
							msg : data.errorMsg
						});
						$('#tablePlant').datagrid('reload');
					} else {
						$.messager.show({
							title : 'Error',
							msg : data.errorMsg
						});
					}
				}, 'json');
			}
		});
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要删除的数据'
		});
	}
}
/**
 * 添加库资料dialog
 */
function addLibrary() {
	// 打开对话框
	$('#dlgLibrary').dialog('open').dialog('setTitle', '添加库资料');
	// 清空表单的内容
	$('#formLibrary').form('clear');
	// 设置保存的地址
	url = "AdminServlet?way=addLibrary";
}
/**
 * 保存库资料的函数
 */
function saveLibrary() {
	$('#formLibrary').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(data) {
			var result = eval('(' + data + ')');
			if (result.errorMsg) {
				$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});
			} else {
				// 关闭对话框
				$('#dlgLibrary').dialog('close');
				// 重载数据
				$('#tableLibrary').datagrid('reload');
			}
		}
	})
}

/**
 * 修改库资料弹出对话框的信息
 */
function editLibrary() {
	var row = $('#tableLibrary').datagrid('getSelected');// 获得数据表中选中的数据行
	if (row) {
		$('#dlgLibrary').dialog('open').dialog('center').dialog('setTitle',
				'修改库资料');
		$('#formLibrary').form('load', row);// 选中行的信息，填充到表格中
		url = 'AdminServlet?way=editLibrary&libraryId=' + row.libraryId;// 将选中行的id传到指定地点
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要修改的数据'
		});
	}
}

/**
 * 删除库资料弹出对话框的信息
 */
function deleteLibrary() {
	var row = $('#tableLibrary').datagrid('getSelected');
	if (row) {
		$.messager.confirm('confirm', '是否删除？', function(r) {
			if (r) {
				// $.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('AdminServlet?way=delLibrary', {
					libraryId : row.libraryId
				}, function(data) {
					if (data.success) {
						$.messager.show({
							title : '提示',
							msg : data.errorMsg
						});
						$('#tableLibrary').datagrid('reload');
					} else {
						$.messager.show({
							title : 'Error',
							msg : data.errorMsg
						});
					}
				}, 'json');
			}
		});
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要删除的数据'
		});
	}
}
/**
 * 添加区域dialog
 */
function addArea() {
	// 打开对话框
	$('#dlgArea').dialog('open').dialog('setTitle', '添加区域');
	// 清空表单的内容
	$('#formArea').form('clear');
	// 设置保存的地址
	url = "AdminServlet?way=addArea";
}
/**
 * 保存区域的函数
 */
function saveArea() {
	$('#formArea').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(data) {
			var result = eval('(' + data + ')');
			if (result.errorMsg) {
				$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});
			} else {
				// 关闭对话框
				$('#dlgArea').dialog('close');
				// 重载数据
				$('#tableArea').datagrid('reload');
			}
		}
	})
}

/**
 * 修改区域弹出对话框的信息
 */
function editArea() {
	var row = $('#tableArea').datagrid('getSelected');// 获得数据表中选中的数据行
	if (row) {
		$('#dlgArea').dialog('open').dialog('center')
				.dialog('setTitle', '修改区域');
		$('#formArea').form('load', row);// 选中行的信息，填充到表格中
		url = 'AdminServlet?way=editArea&areaId=' + row.areaId;// 将选中行的id传到指定地点
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要修改的数据'
		});
	}
}

/**
 * 删除区域弹出对话框的信息
 */
function deleteArea() {
	var row = $('#tableArea').datagrid('getSelected');
	if (row) {
		$.messager.confirm('confirm', '是否删除？', function(r) {
			if (r) {
				// $.post(url,传输的数据,结果的接收函数,传递的数据类型);
				$.post('AdminServlet?way=delArea', {
					areaId : row.areaId
				}, function(data) {
					if (data.success) {
						$.messager.show({
							title : '提示',
							msg : data.errorMsg
						});
						$('#tableArea').datagrid('reload');
					} else {
						$.messager.show({
							title : 'Error',
							msg : data.errorMsg
						});
					}
				}, 'json');
			}
		});
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择要删除的数据'
		});
	}
}