/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.veight.home.controller.member;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.veight.admin.controller.ABaseController;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/login")
public class MemberLoginController extends ABaseController {

    /**
     * 登录页面
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(String redirectUrl, HttpServletRequest request, ModelMap model) {
       // Setting setting = SettingUtils.get();
       // if (redirectUrl != null && !redirectUrl.equalsIgnoreCase(setting.getSiteUrl()) && !redirectUrl.startsWith(request.getContextPath() + "/") && !redirectUrl.startsWith(setting.getSiteUrl() + "/")) {
       //     redirectUrl = null;
       // }
        //model.addAttribute("redirectUrl", redirectUrl);
        //model.addAttribute("captchaId", UUID.randomUUID().toString());
        return "/shop/login/index";
    }
}
