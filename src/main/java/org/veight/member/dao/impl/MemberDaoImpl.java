package org.veight.member.dao.impl;

import org.springframework.stereotype.Repository;
import org.veight.admin.dao.impl.ABaseDaoImpl;
import org.veight.member.dao.MemberDao;
import org.veight.member.domain.Member;

/**
 * 会员 DAO实现类
 * @author Administrator
 * @时间 2014-6-29 上午10:49:36
 * @开发团队  845885222@qq.com
 */
@Repository
public class MemberDaoImpl extends ABaseDaoImpl<Member, String> implements MemberDao {

	public boolean isExistByUsername(String username) {
		String hql = "from Member members where lower(members.username) = lower(?)";
		Member member = (Member) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
		if (member != null) {
			return true;
		} else {
			return false;
		}
	}

	public Member getMemberByUsername(String username) {
		String hql = "from Member members where lower(members.username) = lower(?)";
		return (Member) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
	}

	// 关联处理
	@Override
	public void delete(Member member) {

		super.delete(member);
	}

	@Override
	public void delete(String id) {
		Member member = load(id);
		this.delete(member);
	}

	@Override
	public void delete(String[] ids) {
		for (String id : ids) {
			Member member = load(id);
			this.delete(member);
		}
	}
}
