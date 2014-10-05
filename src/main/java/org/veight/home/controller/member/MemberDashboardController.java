/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.veight.home.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/v1/member")
public class MemberDashboardController {

    @RequestMapping(value = "/dashboard.xhtml", method = RequestMethod.GET)
    public String displayCustomerDashboard(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("会员中心首页");
        return "/home/member/dashboard";
    }
}
