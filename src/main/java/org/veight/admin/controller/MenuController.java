package org.veight.admin.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 后台管理
 * @author Administrator
 * @date  2014-7-11 下午01:38:46
 */
@Controller
@RequestMapping("/admin/menu")
public class MenuController extends ABaseController{
	
	//后台首页
	@RequestMapping(value="/main.xhtml")
	public String main(ModelMap model) {
		model.addAttribute("username",getCurrentUsername());
		return "admin/menu/main";
	}
	
	//欢迎页
	@RequestMapping(value="/welcome.xhtml")
	public String welcome(ModelMap model,HttpServletRequest request) {
		ServletContext servletContext = request.getSession().getServletContext();
		model.addAttribute("javaVersion",  System.getProperty("java.version"));
		model.addAttribute("javaHome", System.getProperty("java.home"));
		model.addAttribute("osName", System.getProperty("os.name"));
		model.addAttribute("osVersion", System.getProperty("os.version"));
		model.addAttribute("osArch", System.getProperty("os.arch"));
		//服务器路径
		model.addAttribute("serverPath", System.getProperty("user.dir"));
		//获取容器信息和servlet版本
		model.addAttribute("serverInfo", servletContext.getServerInfo());
		model.addAttribute("servletVersion", servletContext.getMajorVersion() + "." + servletContext.getMinorVersion());
		return "admin/menu/welcome";
	}
		
}
