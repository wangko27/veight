<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<!-- 导入jquery核心类库 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/template/admin/js/jquery-1.8.3.js"></script>
	<!-- 导入easyui类库 -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/template/admin/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/template/admin/js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/template/admin/js/easyui/ext/portal.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/template/admin/css/default.css">	
	<script type="text/javascript" src="${pageContext.request.contextPath}/template/admin/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/template/admin/js/easyui/ext/jquery.portal.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/template/admin/js/easyui/ext/jquery.cookie.js"></script>
	<script type="text/javascript"src="${pageContext.request.contextPath}/template/admin/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	</head>
</html>
