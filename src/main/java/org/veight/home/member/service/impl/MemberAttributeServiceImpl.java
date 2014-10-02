package org.veight.home.member.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.veight.admin.service.impl.ABaseServiceImpl;
import org.veight.home.member.dao.MemberAttributeDao;
import org.veight.home.member.service.MemberAttributeService;
import org.veight.domain.member.MemberAttribute;

/**
 * Service - 会员注册项
 * 
 * 
 * 
 */
@Service
public class MemberAttributeServiceImpl extends ABaseServiceImpl<MemberAttribute, String> implements MemberAttributeService {

	@Resource
	private MemberAttributeDao memberAttributeDao;

	@Resource
	public void setBaseDao(MemberAttributeDao memberAttributeDao) {
		super.setBaseDao(memberAttributeDao);
	}

	@Transactional(readOnly = true)
	public Integer findUnusedPropertyIndex() {
		return memberAttributeDao.findUnusedPropertyIndex();
	}


}