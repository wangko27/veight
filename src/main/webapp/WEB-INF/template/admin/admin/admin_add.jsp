<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String base = request.getScheme() + "://" + request.getServerName()+ ":" + request.getServerPort() + path;
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=base%>">
		<title>添加管理员</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<jsp:include page="/WEB-INF/template/common/admin-include.jsp"></jsp:include>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/template/admin/css/input.css" />
		<script type="text/javascript">
	// 工具栏
	$(document).ready(function() {
		$(".inputTable tr td").mouseover(function() {
			$(this).parent().find("td").css("background-color", "#d5f4fe");
		});
	})
	/* 当鼠标在表格上移动时，离开的那一行背景恢复 */
	$(document).ready(function() {
		$(".inputTable tr td").mouseout(function() {
			var bgc = $(this).parent().attr("bg");
			$(this).parent().find("td").css("background-color", bgc);
		});
	})

	$(document).ready(function() {
		var color = "#f8f8f8"
		$(".inputTable tr:odd td").css("background-color", color); //改变偶数行背景色
			/* 把背景色保存到属性中 */
			$(".inputTable tr:odd").attr("bg", color);
			$(".inputTable tr:even").attr("bg", "#fff");
		})
	//密码校验
	$.extend($.fn.validatebox.defaults.rules, {
		equals : {
			validator : function(value, param) {
				return value == $(param[0]).val();
			},
			message : '密码输入不一致.'
		}
	});
	//表单提交之前校验
	/**
	$(function(){
		$('#inputForm').form({
				url:'',
				onSubmit:function(){
					return $(this).form('validate');
				},
				success:function(data){
					$.messager.alert('Info', data, 'info');
				}
			});
		});*/
</script>
		<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
	</head>
<body class="input">
<div class="easyui-panel" title="添加管理员" style="padding: 10px;">
	<form:form id="inputForm" action="${pageContext.request.contextPath}/admin/admin/save.action"
	method="post" commandName="adminForm">
	<table table cellspacing="0" cellpadding="0" class="inputTable">
		<tr>
			<td align="right">
				用户名:
			</td>
			<td>
				<form:input path="username" cssClass="easyui-validatebox" required="required" validType="length[4,20]"/>
				*<form:errors path="username" cssClass="error" />
			</td>
		</tr>
		<tr>
			<td align="right">
				密码:
			</td>
			<td>
				<form:password id="password" path="password"
					cssClass="easyui-validatebox" required="required"
					validType="length[4,20]" />
					<form:errors path="password" cssClass="error" />
			</td>
		</tr>
		<tr>
			<td align="right">
				确认密码:
			</td>
			<td>
				<input type="password" name="rePassword"
					cssClass="easyui-validatebox" required="required"
					validType="equals['#password']" />
			</td>
		</tr>
		<tr>
			<td align="right">
				E-mail:
			</td>
			<td>
				<form:input path="email" cssClass="easyui-validatebox"
					required="required" validType="email,length[0,20]" />
					<form:errors path="email" cssClass="error" />
			</td>
		</tr>
		<tr>
			<td align="right">
				部门：
			</td>
			<td>
				<form:input path="department" cssClass="easyui-validatebox"
					required="required" validType="length[0,20]" />
					<form:errors path="department" cssClass="error" />
			</td>
		</tr>
		<tr>
			<td align="right">
				姓名:
			</td>
			<td>
				<form:input path="name" cssClass="easyui-validatebox"
					required="required" validType="length[0,20]" />
				<form:errors path="name" cssClass="error" />
			</td>
		</tr>
		<tr class="roles">
			<td align="right">
				角色:
			</td>
			<td>
			<c:forEach items="${roles}" var="role">
				<label>
				<input type="checkbox" name="roleIds" value="${role.id}" />
					${role.name}
				</label>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td align="right">
				是否启用
			</td>
			<td>
				<label>
					<form:checkbox path="isAccountEnabled" value="true"
						checked="checked" />
				</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<input type="submit" class="easyui-linkbutton" value="保存" />
			</td>
			<td>
				<input type="reset" class="easyui-linkbutton" value="取消" />
			</td>
		</tr>
	</table>
</form:form>
</div>
</body>
</html>