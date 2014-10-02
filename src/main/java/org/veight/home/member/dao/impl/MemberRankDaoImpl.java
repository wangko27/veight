/*
 * 
 * 
 * 
 */
package org.veight.home.member.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.veight.admin.dao.impl.ABaseDaoImpl;
import org.veight.home.member.dao.MemberRankDao;
import org.veight.domain.member.MemberRank;

/**
 * Dao - 会员等级
 * 
 * 
 * 
 */
@Repository
public class MemberRankDaoImpl extends ABaseDaoImpl<MemberRank, String> implements MemberRankDao {

	public boolean nameExists(String name) {
		if (name == null) {
			return false;
		}
		String hql = "select count(*) from MemberRank memberRank where lower(memberRank.name) = lower(:name)";
		Long count =  (Long) getSession().createQuery(hql).setParameter("name", name).uniqueResult();
		return count > 0;
	}

	public boolean amountExists(BigDecimal amount) {
		if (amount == null) {
			return false;
		}
		String hql = "select count(*) from MemberRank memberRank where memberRank.amount = :amount";
		Long count = (Long) getSession().createQuery(hql).setParameter("amount", amount).uniqueResult();
		return count > 0;
	}

	public MemberRank findDefault() {
		try {
			String hql = "select memberRank from MemberRank memberRank where memberRank.isDefault = true";
			return  (MemberRank) getSession().createQuery(hql).uniqueResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * 处理默认并更新
	 * 
	 * @param memberRank
	 *            会员等级
	 * @return 会员等级
	 */
	public MemberRank merge(MemberRank memberRank) {
//		Assert.notNull(memberRank);
//		if (memberRank.getIsDefault()) {
//			String jpql = "update MemberRank memberRank set memberRank.isDefault = false where memberRank.isDefault = true and memberRank != :memberRank";
//			entityManager.createQuery(jpql).setFlushMode(FlushModeType.COMMIT).setParameter("memberRank", memberRank).executeUpdate();
//		}
//		return super.merge(memberRank);
            return null;
	}

	/**
	 * 忽略默认、清除会员价并删除
	 * 
	 * @param memberRank
	 *            会员等级
	 */
	public void remove(MemberRank memberRank) {
//		if (memberRank != null && !memberRank.getIsDefault()) {
//			String jpql = "select product from Product product join product.memberPrice memberPrice where index(memberPrice) = :memberRank";
//			List<Product> products = entityManager.createQuery(jpql, Product.class).setFlushMode(FlushModeType.COMMIT).setParameter("memberRank", memberRank).getResultList();
//			for (int i = 0; i < products.size(); i++) {
//				Product product = products.get(i);
//				product.getMemberPrice().remove(memberRank);
//				if (i % 20 == 0) {
//					super.flush();
//					super.clear();
//				}
//			}
//			super.remove(super.merge(memberRank));
//		}
	}

    public MemberRank findByAmount(BigDecimal amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}