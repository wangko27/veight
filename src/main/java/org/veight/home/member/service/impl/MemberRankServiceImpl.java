package org.veight.home.member.service.impl;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.veight.admin.service.impl.ABaseServiceImpl;
import org.veight.home.member.dao.MemberRankDao;
import org.veight.home.member.service.MemberRankService;
import org.veight.domain.member.MemberRank;

/**
 * Service - 会员等级
 * 
 * 
 * 
 */
@Service("memberRankServiceImpl")
public class MemberRankServiceImpl extends ABaseServiceImpl<MemberRank, String> implements MemberRankService {

	@Resource
	private MemberRankDao memberRankDao;

	@Resource
	public void setBaseDao(MemberRankDao memberRankDao) {
		super.setBaseDao(memberRankDao);
	}

	@Transactional(readOnly = true)
	public boolean nameExists(String name) {
		return memberRankDao.nameExists(name);
	}

	@Transactional(readOnly = true)
	public boolean nameUnique(String previousName, String currentName) {
		if (StringUtils.equalsIgnoreCase(previousName, currentName)) {
			return true;
		} else {
			if (memberRankDao.nameExists(currentName)) {
				return false;
			} else {
				return true;
			}
		}
	}
}