/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.veight.home.member.service.security;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.veight.domain.member.Member;
import org.veight.home.member.service.MemberService;

/**
 * 前台的会员使用spring security登录验证
 *
 * @author Administrator
 */
@Service
public class MemberDetailsServiceImpl implements UserDetailsService {

    @Resource
    private MemberService memberService;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MemberDetailsServiceImpl.class);

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetails user = null;
        try {
            Member member = memberService.getByNick(userName);
            if (member == null) {
                return null;
            }
            List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
            authList.add(new SimpleGrantedAuthority("ROLE_MEMBER_AUTH"));
            user = new User(member.getUsername(), member.getPassword(), true, true, true, true, authList);
        } catch (Exception e) {
            LOGGER.error(userName+" UsernameNotFoundException");  
            throw new UsernameNotFoundException("Error in retrieving user");
        }
        LOGGER.info("当前会员：" + user.getUsername());
        return user;
    }

}
