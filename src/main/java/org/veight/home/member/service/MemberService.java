package org.veight.home.member.service;
import java.util.List;
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
	public boolean usernameExists(String username);

	

	/**
	 * 判断E-mail是否存在
	 * 
	 * @param email
	 *            E-mail(忽略大小写)
	 * @return E-mail是否存在
	 */
	public boolean emailExists(String email);

	/**
	 * 判断E-mail是否唯一
	 * 
	 * @param previousEmail
	 *            修改前E-mail(忽略大小写)
	 * @param currentEmail
	 *            当前E-mail(忽略大小写)
	 * @return E-mail是否唯一
	 */
	public boolean emailUnique(String previousEmail, String currentEmail);
	/**
	 * 保存会员
	 */
	public List<Member> findListByEmail(String email);
        /**
         * 根据用户获取该用户信息
         * @param nick
         * @return 
         */
        public Member getByNick(String nick);
}