/*
 * 
 * 
 * 
 */
package org.veight.home.member.service.impl;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.LockModeType;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.veight.admin.service.impl.ABaseServiceImpl;
import org.veight.bean.Setting;
import org.veight.home.member.dao.MemberDao;
import org.veight.home.member.service.MemberService;
import org.veight.domain.member.Member;

/**
 * Service - 会员
 *
 *
 *
 */
@Service("memberServiceImpl")
public class MemberServiceImpl extends ABaseServiceImpl<Member, String> implements MemberService {

    @Resource
    private MemberDao memberDao;

    @Resource
    public void setBaseDao(MemberDao memberDao) {
        super.setBaseDao(memberDao);
    }

    @Transactional(readOnly = true)
    public boolean usernameExists(String username) {
        return memberDao.usernameExists(username);
    }

    @Transactional(readOnly = true)
    public boolean emailExists(String email) {
        return memberDao.emailExists(email);
    }

    @Transactional(readOnly = true)
    public boolean emailUnique(String previousEmail, String currentEmail) {
        if (StringUtils.equalsIgnoreCase(previousEmail, currentEmail)) {
            return true;
        } else {
            if (memberDao.emailExists(currentEmail)) {
                return false;
            } else {
                return true;
            }
        }
    }

    @Transactional(readOnly = true)
    public Member findByUsername(String username) {
        return memberDao.findByUsername(username);
    }

    @Transactional(readOnly = true)
    public List<Member> findListByEmail(String email) {
        return memberDao.findListByEmail(email);
    }

    public Member getByNick(String nick) {
        return memberDao.findByUsername(nick);
    }

}
