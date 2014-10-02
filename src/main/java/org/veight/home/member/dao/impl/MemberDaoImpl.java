/*
 * 
 * 
 * 
 */
package org.veight.home.member.dao.impl;

import java.util.Collections;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.veight.admin.dao.impl.ABaseDaoImpl;
import org.veight.home.member.dao.MemberDao;
import org.veight.domain.member.Member;
/**
 * Dao - 会员
 */
@Repository
public class MemberDaoImpl extends ABaseDaoImpl<Member, String> implements MemberDao {

    public boolean usernameExists(String username) {
        String hql = "from Member members where lower(members.username) = lower(?)";
        Member member = (Member) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
        if (member != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean emailExists(String email) {
        if (email == null) {
            return false;
        }
        String hql = "from Member members where lower(members.email) = lower(:email)";
        Long count = (Long) getSession().createQuery(hql).setParameter("email", email).uniqueResult();
        return count > 0;
    }

    public Member findByUsername(String username) {
        if (username == null) {
            return null;
        }
        try {
            String hql = "from Member members where lower(members.username) = lower(?)";
            return (Member) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
        } catch (NoResultException e) {
            
            
            return null;
        }
    }

    public List<Member> findListByEmail(String email) {
        if (email == null) {
            return Collections.<Member>emptyList();
        }
        String hql = "from Member members where lower(members.email) = lower(:email)";
        return  (List<Member>) getSession().createQuery(hql).setParameter("email", email).uniqueResult();
    }

}
