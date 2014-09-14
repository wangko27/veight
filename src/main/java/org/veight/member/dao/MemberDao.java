package org.veight.member.dao;

import org.veight.admin.dao.ABaseDao;
import org.veight.member.domain.Member;

/**
 * 会员 dao 接口
 * @author Administrator
 * @时间 2014-6-29 上午10:46:41
 * @开发团队  845885222@qq.com
 */
public interface MemberDao extends ABaseDao<Member, String>{
	/**
	 * 根据用户名判断此用户是否存在（不区分大小写）
	 * 
	 */
	public boolean isExistByUsername(String username);
	
	/**
	 * 根据用户名获取会员对象，若会员不存在，则返回null（不区分大小写）
	 * 
	 */
	public Member getMemberByUsername(String username);
	
}
