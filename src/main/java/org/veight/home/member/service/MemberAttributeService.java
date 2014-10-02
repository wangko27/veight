package org.veight.home.member.service;

import java.util.List;
import org.veight.admin.service.ABaseService;
import org.veight.domain.member.MemberAttribute;
/**
 * Service - 会员注册项
 */
public interface MemberAttributeService extends ABaseService<MemberAttribute, String> {

	/**
	 * 查找未使用的对象属性序号
	 * 
	 * @return 未使用的对象属性序号，若无可用序号则返回null
	 */
	Integer findUnusedPropertyIndex();
}