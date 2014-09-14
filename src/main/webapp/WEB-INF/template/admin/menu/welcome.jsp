<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加歌曲</title> 
	<!-- 导入jquery核心类库 -->
	<script type="text/javascript" src="<%=basePath%>/template/admin/js/jquery-1.8.3.js"></script>
	<!-- 导入easyui类库 -->
	<link id="easyuiTheme" rel="stylesheet" type="text/css" href="<%=basePath%>/template/admin/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css"  href="<%=basePath%>/template/admin/js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css"  href="<%=basePath%>/template/admin/css/default.css">
	<script type="text/javascript" src="<%=basePath%>/template/admin/js/easyui/jquery.easyui.min.js"></script>
	<!-- 导入ztree类库 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/template/admin/js/ztree/zTreeStyle.css"/>
	<script type="text/javascript" src="<%=basePath%>/template/admin/js/ztree/jquery.ztree.all-3.5.js"></script>
	<script type="text/javascript" src="<%=basePath%>/template/admin/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/template/admin/css/input.css" />
	<script type="text/javascript" src="<%=basePath%>/template/common/js/ajaxupload.js"></script>
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
</script>
	</head>
	<body class="input">
		<div class="easyui-panel" title="系统信息" style="padding: 10px;" data-options="iconCls:'icon-cog'">
			<form action="song!save.action" method="post">
				<table table cellspacing="0" cellpadding="0" class="inputTable">
					<tr>
						<td colspan="4">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td align="right">
							系统名称:
						</td>
						<td>
							v8音乐分享网站
						</td>
						<td align="right">
							系统版本:
						</td>
						<td>
							version 0.8-alpha
						</td>
					</tr>
					<tr>
						<td align="right">
							官方网站:
						</td>
						<td>
							<a href="http://www.v8.com" target="_blank">http://www.v8.com</a>
						</td>
						<td align="right">
							官方论坛:
						</td>
						<td>
							<a href="http://bbs.v8.com" target="_blank">http://bbs.v8.com</a>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td align="right">
							JAVA版本:
						</td>
						<td>
							${javaVersion}
						</td>
						<td align="right">
							JAVA路径:
						</td>
						<td>
							${javaHome}
						</td>
					</tr>
					<tr>
						<td align="right">
							操作系统名称:
						</td>
						<td>
							${osName}
						</td>
						<td align="right">
							操作系统构架:
						</td>
						<td>
							${osArch}
						</td>
					</tr>
					<tr>
						<td align="right">
							操作系统版本:
						</td>
						<td>
							${osVersion}
						</td>
						<td align="right">
							服务器路径:
						</td>
						<td>
							${serverPath}
						</td>
					</tr>
					<tr>
						<td align="right">
							Servlet信息:
						</td>
						<td>
							${serverInfo}
						</td>
						<td align="right">
							Servlet版本:
						</td>
						<td>
							${servletVersion}
						</td>
					</tr>
					<tr>
						<td colspan="4">
							&nbsp;
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>