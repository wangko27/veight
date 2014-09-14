package org.veight.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 后台登陆控制器
 * @author Administrator
 * 时间 ：2014-8-10 上午10:36:56 
 * 845885222@qq.com
 */
@Controller
@RequestMapping("/admin/login")
public class LoginController extends ABaseController{
	/**
	 * 进入登陆页面
	 * 
	 */
	@RequestMapping("/index.xhtml")
	public String index() throws Exception {

		return "admin/login/index";
	}
	// 登录错误处理
	@RequestMapping("/login.xhtml")
	public String login(String error,HttpServletRequest request,ModelMap model) {
		if (StringUtils.endsWithIgnoreCase(error, "captcha")) {
			System.out.println("验证码错误,请重新输入");
			model.addAttribute("errorMessage","验证码错误,请重新输入!");
		}
		if (StringUtils.endsWithIgnoreCase(error, "invalid")) {
			System.out.println("验证码已过期,请重新输入");
			model.addAttribute("errorMessage","验证码已过期,请重新输入!");
		}
		return "admin/login/index";
	}
}
