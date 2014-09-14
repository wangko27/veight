package org.veight.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前台曲风 搜索
 * @author Administrator
 * 时间 ：2014-8-23 下午02:10:02
 * 路径： HomeGenreController.java
 */
@Controller
public class HomeGenreController {
	/**
	 * 曲风点击
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/genre.xhtml")
	public String home(ModelMap model) {
        
        return "/home/genres";
	}

}
