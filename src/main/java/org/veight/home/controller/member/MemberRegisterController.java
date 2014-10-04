package org.veight.home.controller.member;

import com.octo.captcha.service.CaptchaService;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.veight.admin.controller.ABaseController;
import org.veight.home.member.service.MemberAttributeService;
import org.veight.home.member.service.MemberRankService;
import org.veight.home.member.service.MemberService;
import org.veight.domain.member.Member;

/**
 * Controller - 会员注册
 *
 *
 *
 */
@Controller
@RequestMapping("/v1/member")
public class MemberRegisterController extends ABaseController {

    @Resource
    private CaptchaService captchaService;

    @Resource
    private MemberService memberService;
    @Resource
    private MemberRankService memberRankService;
    @Resource
    private MemberAttributeService memberAttributeService;

    @RequestMapping(value = "/registration.xhtml", method = RequestMethod.GET)
    public String displayRegistration(Model model, HttpServletRequest request) throws Exception {

        return "/home/registration";
    }

    /**
     * 注册提交
     */
    @RequestMapping(value = "/register.xhtml", method = RequestMethod.POST)
    public String registerMember(String username, String password, String email, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Member member = new Member();
        System.out.println("username" + username);
        System.out.println("password" + password);
        System.out.println("email" + email);
       
        member.setUsername(username.toLowerCase());
        member.setPassword(DigestUtils.md5Hex(password));
        member.setEmail(email);
        member.setLoginFailureCount(0);
        member.setLockedDate(null);
        member.setRegisterIp(request.getRemoteAddr());
        member.setLoginIp(request.getRemoteAddr());
        member.setLoginDate(new Date());
        member.setMemberRank(memberRankService.findDefault());
        memberService.save(member);
        return "redirect:/v1/index.xhtml";
    }

}
