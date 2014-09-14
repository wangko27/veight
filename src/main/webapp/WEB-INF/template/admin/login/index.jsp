<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台登陆-管理系统</title> 
	<!-- 导入jquery核心类库 -->
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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/template/admin/css/login.css" />
	</head>
	<body class="input">
		<div id="win">
			<form action="<%=basePath%>/admin/login/loginVerify.action" method="post">
			<table table cellspacing="0" cellpadding="0" class="inputTable">
	              <tr>
	                  <td align="right">用户名:</td>
	                  <td><input class="easyui-validatebox" type="text" id="username" name="j_username" required="required"></input></td>
	              </tr>
	              <tr>
	                  <td align="right">密码:</td>
	                  <td><input class="easyui-validatebox" type="password" id="password"  name="j_password"></input></td>
	              </tr>
	               <tr>
	                  <td align="right">验证码:</td>
	                  <td>
	                  	<div class="formTextS">
                    		<input type="text" id="captcha" name="j_captcha" />
                    	</div>
                    	<div class="captchaImage">
                   			<img id="captchaImage" src="<%=basePath%>/captcha.jpg" alt="换一张" />
                   		</div>
			    	  </td>
	              </tr>
	              <tr>
	                  <td align="right">
	                  	<input type="submit" class="easyui-linkbutton" value="登陆"/>
	                  </td>
	                  <td>
	                    <input type="reset" class="easyui-linkbutton" value="取消"/>
	                 </td>
	              </tr>
	                <c:if test="errorMessage!=null">
	              	<tr>
	                  <td align="center" colspan="2" style="color: red;">错误信息:${errorMessage}</td>
	              	</tr>
	               </c:if>
	          </table>
			</form>
		</div>
	</body>
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
	//登陆窗口
	$('#win').window({
		title:'v8音乐网后台管理登录',
		width:450,
	    height:220,
	    top: ($(window).height() - 420) * 0.5,
	    iconCls: 'icon-cog',
	    resizable: false,
	    minimizable: false,
	    maximizable: false,
	    closable:false,
	    modal:true,
	    collapsible: false
	});

	$().ready( function() {
		var $username = $("#username");
		var $password = $("#password");
		var $captcha = $("#captcha");
		var $captchaImage = $("#captchaImage");
		var $isSaveUsername = $("#isSaveUsername");
		// 提交表单验证,记住登录用户名
		$("#loginForm").submit( function() {
			if ($username.val() == "") {
				alert("请输入您的用户名!");
				return false;
			}
			if ($password.val() == "") {
				$.message("请输入您的密码!");
				return false;
			}
			if ($captcha.val() == "") {
				alert("请输入您的验证码!");
				return false;
			}
		});
		// 刷新验证码
		$captchaImage.click( function() {
			var timestamp = (new Date()).valueOf();
			var imageSrc = $captchaImage.attr("src");
			if(imageSrc.indexOf("?") >= 0) {
				imageSrc = imageSrc.substring(0, imageSrc.indexOf("?"));
			}
			imageSrc = imageSrc + "?timestamp=" + timestamp;
			$captchaImage.attr("src", imageSrc);
		});
	});
</script>
</html>