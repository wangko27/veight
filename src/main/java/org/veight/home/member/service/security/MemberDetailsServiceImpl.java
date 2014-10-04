/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.veight.home.member.service.security;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
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

        Member member = null;
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        try {
            member = memberService.getByNick(userName);

            if (member == null) {
                return null;
            }

            GrantedAuthority grantedAuthority = new GrantedAuthorityImpl("ROLE_MEMBER_AUTH");
            authorities.add(grantedAuthority);
        } catch (Exception e) {
            LOGGER.error("Exception while querrying customer", e);
            e.printStackTrace();
        }

        User authUser = new User(userName, member.getPassword(), true, true,true, true, authorities);

        return authUser;
    }

}
