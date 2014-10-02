package org.veight.home.member.dao.impl;

import java.util.List;
import javax.persistence.FlushModeType;
import org.springframework.stereotype.Repository;
import org.veight.admin.dao.impl.ABaseDaoImpl;
import org.veight.home.member.dao.MemberAttributeDao;
import org.veight.domain.member.Member;
import org.veight.domain.member.MemberAttribute;

/**
 * Dao - 会员注册项
 * 
 * 
 * 
 */
@Repository
public class MemberAttributeDaoImpl extends ABaseDaoImpl<MemberAttribute, String> implements MemberAttributeDao {

	public Integer findUnusedPropertyIndex() {
//		for (int i = 0; i < Member.ATTRIBUTE_VALUE_PROPERTY_COUNT; i++) {
//			String hql = "select count(*) from MemberAttribute memberAttribute where memberAttribute.propertyIndex = :propertyIndex";
//			Long count = getSession().createQuery(hql).setParameter("propertyIndex", i).uniqueResult();
//			if (count == 0) {
//				return i;
//			}
//		}
		return null;
	}

	public List<MemberAttribute> findList() {
		String hql = "select memberAttribute from MemberAttribute memberAttribute where memberAttribute.isEnabled = true order by memberAttribute.order asc";
		return (List<MemberAttribute>)getSession().createQuery(hql).list();
	}

	/**
	 * 清除会员注册项值
	 * 
	 * @param memberAttribute
	 *            会员注册项
	 */
//	@Override
//	public void remove(MemberAttribute memberAttribute) {
//		if (memberAttribute != null && (memberAttribute.getType() == Type.text || memberAttribute.getType() == Type.select || memberAttribute.getType() == Type.checkbox)) {
//			String propertyName = Member.ATTRIBUTE_VALUE_PROPERTY_NAME_PREFIX + memberAttribute.getPropertyIndex();
//			String jpql = "update Member members set members." + propertyName + " = null";
//			entityManager.createQuery(jpql).setFlushMode(FlushModeType.COMMIT).executeUpdate();
//			super.remove(memberAttribute);
//		}
//	}

}