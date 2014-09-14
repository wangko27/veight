<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>提示信息 - Powered By Veight TEAM</title>
<meta name="Author" content="Veight Team" />
<meta name="Copyright" content="SHOP++" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
</head>
<body class="error">
	<div class="body">
		<div class="errorBox">
			<div class="errorDetail">
				<div class="errorContent">
					<#if (errorMessages?size > 0)!>
						<#list errorMessages as list>${list}<br></#list>
					<#elseif (actionMessages?size > 0)!>
						<#list actionMessages as list>${list}<br></#list>
					<#elseif (fieldErrors?size > 0)!>
						<#list (fieldErrors?keys)! as key>
							${fieldErrors[key]?replace('^\\[', '', 'r')?replace('\\]$', '', 'r')}<br>
						</#list>
					<#else>
						您的操作出现错误!
					</#if>
				</div>
				<div class="errorUrl">
					<#if redirectionUrl??>
						点击<a href="${redirectionUrl}">确定</a>，或<a href="#" onclick="window.history.back(); return false;">返回</a>
					<#else>
						点击此处<a href="#" onclick="window.history.back(); return false;">返回</a>或回到<a href="${base}/">首页</a>
					</#if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>