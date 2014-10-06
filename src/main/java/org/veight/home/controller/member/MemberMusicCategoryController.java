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

/**
 * 歌单
 * @author Administrator
 */
@Controller
@RequestMapping("/v1/member")
public class MemberMusicCategoryController {
     /**
     * 显示会员的歌单列表
     */
    @RequestMapping("/music/category.xhtml")
    public String displayMusicCategory(ModelMap model) {

        return "/home/signin";
    }
     /**
     * 显示会员的歌单的详细信息
     */
    @RequestMapping("/music/category/deatail.xhtml")
    public String displayMusicCategoryDetail(String id, ModelMap model) {
        System.out.println("displayMusicCategoryDetail");
        return "/home/member/musicCategoryDetail";
    }
}
