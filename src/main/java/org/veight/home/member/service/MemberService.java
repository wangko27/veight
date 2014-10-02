package org.veight.home.member.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.veight.domain.Admin;
import org.veight.admin.service.ABaseService;
import org.veight.domain.member.Member;
/**
 * 会员 Service
 * @author Administrator
 * @时间 2014-6-29 上午10:40:40
 * @开发团队  845885222@qq.com
 */
public interface MemberService extends ABaseService<Member, String> {

	/**
	 * 判断用户名是否存在
	 * 
	 * @param username
	 *            用户名(忽略大小写)
	 * @return 用户名是否存在
	 */
	boolean usernameExists(String username);

	

	/**
	 * 判断E-mail是否存在
	 * 
	 * @param email
	 *            E-mail(忽略大小写)
	 * @return E-mail是否存在
	 */
	boolean emailExists(String email);

	/**
	 * 判断E-mail是否唯一
	 * 
	 * @param previousEmail
	 *            修改前E-mail(忽略大小写)
	 * @param currentEmail
	 *            当前E-mail(忽略大小写)
	 * @return E-mail是否唯一
	 */
	boolean emailUnique(String previousEmail, String currentEmail);
	/**
	 * 保存会员
	 * 
	 * @param member
	 *            会员
	 * @param operator
	 *            操作员
	 */
	List<Member> findListByEmail(String email);
}