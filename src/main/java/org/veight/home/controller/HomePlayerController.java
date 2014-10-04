package org.veight.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* mp3播放Action
* @author Administrator
* @时间 2014-6-19 下午8:34:26
* @开发团队  845885222@qq.com
*/
@Controller
@RequestMapping("/v1")
public class HomePlayerController extends ABaseHomeController{
	@RequestMapping(value="/play.xhtml")
	public String play(){
		
		return "/home/mp3player";
	}
}
