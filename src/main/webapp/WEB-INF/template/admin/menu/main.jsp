<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>v8音乐网站-后台中心${base}</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript" src="<%=basePath%>/template/admin/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link id="easyuiTheme" rel="stylesheet" type="text/css" href="<%=basePath%>/template/admin/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"  href="<%=basePath%>/template/admin/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"  href="<%=basePath%>/template/admin/css/default.css">
<script type="text/javascript" src="<%=basePath%>/template/admin/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/template/admin/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	// 页面加载后 右下角 弹出窗口
	var oldFolderName;
	window.setTimeout(
		function() {
			$.messager
					.show({
						title : "消息提示",
						msg : '${username}欢迎登录，<a href="javascript:void" onclick="top.showAbout();">联系管理员</a>',
						timeout : 5000
					});
		}, 3000);
	/*************/
		// 修改密码取消按钮
		$("#btnCancel").click(function() {
			$('#editPwdWindow').window('close');
		});

		// 修改密码确定按钮
		$("#btnEp").click(function() {
			// js 表单校验 
			var txtNewPass = $('#txtNewPass').val(); // 获得输入框value属性
			var txtRePass = $('#txtRePass').val();
			// 判断密码不为空 
			if ($.trim(txtNewPass) == "") {
				// 密码空白
				$.messager.alert('警告', '密码不能为空', 'warning');
				return;
			}
			// 判断两次密码 一致
			if ($.trim(txtNewPass) != $.trim(txtRePass)) {
				// 两次密码不一致
				$.messager.alert('警告', '两次密码输入不一致', 'warning');
				return;
			}
			// 密码合法，提交ajax请求
			$.post("<%=basePath%>/user_editpassword.action", {
				password : txtNewPass
			}, function(data) {
				// 回调函数
				if (data.success == "true") {
					// 成功
					$.messager.alert('成功', data.msg, 'info');
				} else {
					// 失败
					$.messager.alert('失败', data.msg, 'error');
				}
				// 隐藏密码框
				$('#editPwdWindow').window('close');
			});
	});

	function onClick(event, treeId, treeNode, clickFlag) {
		if (treeNode.click != false) {
			open(treeNode.name, treeNode.page);
		}
	}

	// 开启一个新的tab页面
	function open(text, url) {
		if ($("#tabs").tabs('exists', text)) {
			$('#tabs').tabs('select', text);
		} else {
			var content = '<div style="width:100%;height:100%;overflow:hidden;">'
					+ '<iframe src="'
					+ url
					+ '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';

			$('#tabs').tabs('add', {
				title : text,
				content : content,
				//href : url
				closable : true
			});
		}
	}

	/*******顶部特效 *******/
	/**
	 * 更换EasyUI主题的方法
	 * @param themeName
	 * 主题名称
	 */
	changeTheme = function(themeName) {
		var $easyuiTheme = $('#easyuiTheme');
		var url = $easyuiTheme.attr('href');
		var href = url.substring(0, url.indexOf('themes')) + 'themes/'
				+ themeName + '/easyui.css';
		$easyuiTheme.attr('href', href);
		var $iframe = $('iframe');
		if ($iframe.length > 0) {
			for ( var i = 0; i < $iframe.length; i++) {
				var ifr = $iframe[i];
				$(ifr).contents().find('#easyuiTheme').attr('href', href);
			}
		}
	};
	// 退出登录
	function logoutFun() {
		$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(isConfirm) {
			if (isConfirm) {
				location.href = '<%=basePath%>/logout.xhtml';
			}
		});
	}
	// 修改密码
	function editPassword() {
		$('#editPwdWindow').window('open');
	}
	// 版权信息
	function showAbout() {
		$.messager.alert("联系管理员",
				"<p>管理员邮箱: 845885222@qq.com</p>");
	}
	
    //文件管理
	$(function(){
		  //初始化文件管理的树目录
	    $('#documentTree').tree({
	    	url: '<%=basePath%>/admin/document/showDirectoryTree.json?directory=upload',
	        method: 'post',
	        animate: true,
	        onClick: function(node){
	    	    if ($(this).tree('isLeaf', node.target)) {
	    	    	//跳转到一个ifram  target = main的页面
		   	 		window.parent.main.location.href="<%=basePath%>/admin/document/list.xhtml?directory="+node.attributes.relativePath;
			    }
			},
	        onDblClick: function(node){
	   	 		$(this).tree('beginEdit',node.target);
				 },
				 onAfterEdit:function(node){
				 	//修改节点(重命名)后发送数据到服务器真正修改
				 	renameFolder(node.attributes.relativePath,node.text);
				 },
	        onContextMenu: function(e,node){
	            e.preventDefault();
	            $(this).tree('select',node.target);
	            $('#documentContextMenu').menu('show',{
	                left: e.pageX,
	                top: e.pageY
	            });
	        }    
	    });
	});
	//文件浏览的右键菜单 新建目录
    function append(){
        var t = $('#documentTree');
        var node = t.tree('getSelected');
        $.post("<%=basePath%>/admin/document/addFolder.do",{
            directory : node.attributes.relativePath,
            folderName : "新建文件夹"
        },function(data){
            if(data.success){
            	 //追加节点
           	 t.tree('append', {
                    parent: (node?node.target:null),
                    data: [{
                        text: '新建文件夹',
                        attributes:{
                   	 	relativePath:data.relativePath
                   	 }
                    }]
                });
                t.reload();
             }else{
				alert("文件名重复");
                 }
      }, "json");
     }
    //删除目录
    function removeit(){
        var node = $('#documentTree').tree('getSelected');
        $.post("<%=basePath%>/admin/document/romoveFolder.do",{
            directory : node.attributes.relativePath,
            folderName : node.text
        },function(data){
            if(data.success){
            	 $('#documentTree').tree('remove', node.target);
             }else{
				alert(data.message);
                 }
      }, "json");
    }
    //右键重命名
     function reNameit(){
    	  var node = $('#documentTree').tree('getSelected');
    	  $('#documentTree').tree('beginEdit',node.target);
         }
  	//折叠
    function collapse(){
        var node = $('#documentTree').tree('getSelected');
        $('#documentTree').tree('collapse',node.target);
    }
    //展开
    function expand(){
        var node = $('#documentTree').tree('getSelected');
        $('#documentTree').tree('expand',node.target);
    }
    function refreshTree(){
    	 $('#documentTree').tree('reload');
    }
    //重命名文件夹的名字
    //dir是相对根目录的路径，newName只有最后一个文件夹名称
    function renameFolder(dir, newName) {
    	$.post("<%=basePath%>/admin/document/renameFolder.json",{
                directory:dir,
                newFolderName : newName
            },
            function(data){
                //如果重命名的目录正好是当前目录路径上，dir包括ROOT_FOLDER
                //refreshTree();
          }, "json");
    }
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height:60px;background:url('<%=basePath%>/template/admin/images/header_bg.png') no-repeat right;">
		<div>
			<img src="<%=basePath%>/template/admin/images/header_logo.png" border="0">
		</div>
		<div id="sessionInfoDiv"
			style="position: absolute;right: 20px;top:15px;">
			当前用户：[&nbsp;<strong style="font-size: 14px;">${username}</strong>&nbsp;]，欢迎你!
		</div>
		<div style="position: absolute; right: 20px; bottom: 5px; ">
			<a href="javascript:void(0);" class="easyui-menubutton"
				data-options="menu:'#layout_north_pfMenu',iconCls:'icon-ok'">更换皮肤</a>
			<a href="javascript:void(0);" class="easyui-menubutton"
				data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'">控制面板</a>
		</div>
		<div id="layout_north_pfMenu" style="width: 120px; display: none;">
			<div onclick="changeTheme('default');">default</div>
			<div onclick="changeTheme('gray');">gray</div>
			<div onclick="changeTheme('black');">black</div>
			<div onclick="changeTheme('bootstrap');">bootstrap</div>
			<div onclick="changeTheme('metro');">metro</div>
		</div>
		<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
			<div onclick="editPassword();">修改密码</div>
			<div onclick="showAbout();">联系管理员</div>
			<div class="menu-sep"></div>
			<div onclick="logoutFun();">退出系统</div>
		</div>
	</div>
	<div data-options="region:'west',split:true,title:'菜单导航'"
		style="width:200px">
		<div class="easyui-accordion" fit="true" border="false">
		<!-- spring security3 控制访问菜单 ROLE_表示需要的权限 -->
			<security:authorize ifAllGranted="ROLE_SONG">  
			<div title="音乐管理" data-options="iconCls:'icon-mini-add'" style="overflow:auto">
			<ul class="easyui-tree">
	            <li data-options="iconCls:'icon-book'">
	                <a href="<%=basePath%>/admin/song/list.xhtml" target="main">歌曲管理</a>
	            </li >
	            <li data-options="iconCls:'icon-add'">
	             	<a href="<%=basePath%>/admin/song/add.xhtml" target="main">添加歌曲</a>
	            </li>
	             <li><a href="<%=basePath%>/admin/album/list.xhtml" target="main">专辑管理</a></li>
	             <li><a href="<%=basePath%>/admin/genre/list.xhtml" target="main">分类管理</a></li>
	             <li><a href="<%=basePath%>/admin/artist/list.xhtml" target="main">歌手管理</a></li>
        	</ul>
			</div>
			</security:authorize>
			<security:authorize ifAllGranted="ROLE_SONG">  
			<div title="会员管理" data-options="iconCls:'icon-mini-add'"
				style="overflow:auto">
				<ul class="easyui-tree">
	            <li>
	                <a href="song!list.action" target="main">会员管理</a>
	            </li>
	             <li><a href="song!add.action" target="main">会员等级</a></li>
	             <li><a href="album!list.action" target="main">会员注册项</a></li>
	             <li><a href="genre!list.action" target="main">评论管理</a></li>
        	</ul>
			</div>
			</security:authorize>
			<security:authorize ifAllGranted="ROLE_SONG">  
			<div title="文件管理" data-options="iconCls:'icon-mini-add'" style="overflow:auto">
				<ul class="easyui-tree" id="documentTree"></ul>
			</div>
			 <div id="documentContextMenu" class="easyui-menu" style="width:120px;">
		        <div onclick="append()" data-options="iconCls:'icon-add'">新建目录</div>
		        <div onclick="removeit()" data-options="iconCls:'icon-remove'">删除目录</div>
		        <div onclick="reNameit()" data-options="iconCls:'icon-remove'">重命名</div>
		        <div class="menu-sep"></div>
		        <div onclick="expand()">展开</div>
		        <div onclick="collapse()">折叠</div>
		         <div onclick="refreshTree()">刷新</div>
		    </div>
		    </security:authorize>
			<security:authorize ifAllGranted="ROLE_SONG">
			<div title="系统管理" data-options="iconCls:'icon-mini-add'"
				style="overflow:auto">
				<ul class="easyui-tree">
	            <li>
	                <a href="<%=basePath%>/admin/settings/edit.xhtml" target="main">系统设置</a>
	            </li>
	             <li><a href="<%=basePath%>/admin/admin/list.xhtml" target="main">管理员</a></li>
	             <li><a href="<%=basePath%>/admin/role/list.xhtml" target="main">角色管理</a></li>
	             <li><a href="genre!list.action" target="main">日志管理</a></li>
        	</ul>
			</div>
			</security:authorize>
		</div>
	</div>
	<div data-options="region:'center'">
		<div title="操作面板" id="subWarp" style="width:100%;height:100%;overflow:hidden">
			<iframe src="<%=basePath%>/admin/menu/welcome.xhtml" name="main"
				style="width:100%;height:100%;border:0;"></iframe>
		</div>
	</div>
	<div data-options="region:'south',border:false"
		style="height:40px;padding:10px;background:url('<%=basePath%>/template/admin/images/header_bg.png') no-repeat right;">
		<table style="width: 100%;">
			<tbody>
				<tr>
					<td style="width: 300px;">
						<div style="color: #999; font-size: 8pt;">
							v8在线音乐网站 | 版权所有 <a href="#">veight.duapp.com</a>
						</div>
					</td>
					<td class="co1"><span id="online"
						style="background: url(<%=basePath%>/template/admin/images/online.png) no-repeat left;padding-left:18px;margin-left:3px;font-size:8pt;color:#005590;">在线人数:1</span>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!--修改密码窗口-->
	<div id="editPwdWindow" class="easyui-window" title="修改密码"
		collapsible="false" minimizable="false" modal="true" closed="true"
		resizable="false" maximizable="false" icon="icon-save"
		style="width: 300px; height: 160px; padding: 5px;
        background: #fafafa">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding=3>
					<tr>
						<td>新密码：</td>
						<td><input id="txtNewPass" type="Password" class="txt01" /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input id="txtRePass" type="Password" class="txt01" /></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
					href="javascript:void(0)">确定</a> <a id="btnCancel"
					class="easyui-linkbutton" icon="icon-cancel"
					href="javascript:void(0)">取消</a>
			</div>
		</div>
	</div>
</body>
</html>