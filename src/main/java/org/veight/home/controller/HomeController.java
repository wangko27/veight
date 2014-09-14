package org.veight.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 首页控制器
 * @author Administrator
 * 时间 ：2014-8-23 上午08:59:46
 * 路径： HomeController.java
 */
@Controller
public class HomeController extends ABaseHomeController{
	/**
	 * 前台首页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index.xhtml")
	public String home(ModelMap model) {
        
        return "/home/index";
	}
	/**
	 * 随机 选择到首页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/random.xhtml")
	public String random(ModelMap model) {
        
        return "/home/random";
	}
	
}
