package org.veight.member.service.impl;

import java.util.Date;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.veight.admin.service.impl.ABaseServiceImpl;
import org.veight.member.dao.MemberDao;
import org.veight.member.domain.Member;
import org.veight.member.service.MemberService;

import org.veight.utils.CommonUtil;
import org.veight.utils.MD5Utils;
/**
 * 会员 Service 实现
 * @author Administrator
 * @时间 2014-6-29 上午10:44:01
 * @开发团队  845885222@qq.com
 */
@Service
public class MemberServiceImpl extends ABaseServiceImpl<Member, String> implements MemberService {
	@Resource
	private MemberDao memberDao;

	@Resource
	public void setBaseDao(MemberDao userDao) {
		super.setBaseDao(userDao);
	}
	
	public boolean isExistByUsername(String username) {
		return memberDao.isExistByUsername(username);
	}
	
	public Member getMemberByUsername(String username) {
		return memberDao.getMemberByUsername(username);
	}
	
	public boolean verifyMember(String username, String password) {
		Member member = getMemberByUsername(username);
		if (member != null && member.getPassword().equals(MD5Utils.md5(password))) {
			return true;
		} else {
			return false;
		}
	}
	
	public String buildPasswordRecoverKey() {
		return System.currentTimeMillis() + Member.PASSWORD_RECOVER_KEY_SEPARATOR + CommonUtil.getUUID() + MD5Utils.md5(CommonUtil.getRandomString(10));
	}
	
	public Date getPasswordRecoverKeyBuildDate(String passwordRecoverKey) {
		long time = Long.valueOf(StringUtils.substringBefore(passwordRecoverKey, Member.PASSWORD_RECOVER_KEY_SEPARATOR));
		return new Date(time);
	}

}
