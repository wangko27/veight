<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>提示信息 - Powered By Veight TEAM</title>
<meta name="Author" content="Veight Team" />
<meta name="Copyright" content="Veight" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<#include "/WEB-INF/template/common/include.ftl">
<link href="${base}/template/common/css/message.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="center">
	<div id="messageBox" class="easyui-panel" title="提示信息" style="width:400px;padding:10px;"
	 data-options="iconCls:'icon-tip'">
		<div class="messageContent">
			<span class="icon success">&nbsp;</span>
			<span class="messageText">
				<#if (errorMessages?size > 0)!>
					<#list errorMessages as list>${list}<br></#list>
				<#elseif (actionMessages?size > 0)!>
					<#list actionMessages as list>${list}<br></#list>
				<#elseif (fieldErrors?size > 0)!>
					<#list (fieldErrors?keys)! as key>
						${fieldErrors[key]?replace('^\\[', '', 'r')?replace('\\]$', '', 'r')}<br>
					</#list>
				<#else>
					您的操作已成功!
				</#if>
			</span>
			<p style="margin-top:20px;">
			<a href="#"class="easyui-linkbutton" <#if redirectionUrl??>onclick="window.location.href='${redirectionUrl}'"<#else>onclick="window.history.back(); return false;"</#if> >确  定</a>
			</p>
		</div>
	</div>
<div>
</body>
</html>