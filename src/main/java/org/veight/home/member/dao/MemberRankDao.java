/*
 * 
 * 
 * 
 */
package org.veight.home.member.dao;

import java.math.BigDecimal;
import org.veight.admin.dao.ABaseDao;
import org.veight.domain.member.MemberRank;


/**
 * Dao - 会员等级
 * 
 * 
 * 
 */
public interface MemberRankDao extends ABaseDao<MemberRank, String> {

	/**
	 * 判断名称是否存在
	 * 
	 * @param name
	 *            名称(忽略大小写)
	 * @return 名称是否存在
	 */
	boolean nameExists(String name);

	/**
	 * 查找默认会员等级
	 * 
	 * @return 默认会员等级，若不存在则返回null
	 */
	MemberRank findDefault();

	/**
	 * 根据消费金额查找符合此条件的最高会员等级
	 * 
	 * @param amount
	 *            消费金额
	 * @return 会员等级，不包含特殊会员等级，若不存在则返回null
	 */
	MemberRank findByAmount(BigDecimal amount);

}