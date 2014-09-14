package org.veight.admin.dao.impl;
import org.springframework.stereotype.Repository;
import org.veight.admin.dao.AdminDao;
import org.veight.admin.domain.Admin;
/**
 * Dao实现类 - 管理员
 * @author Administrator
 * @date  2014-4-1 上午11:20:52
 */
@Repository
public class AdminDaoImpl extends ABaseDaoImpl<Admin, String> implements AdminDao {
	
	/**
	 * 判断用户名是否存在
	 */
	public boolean isExistByUsername(String username) {
		String hql = "from Admin admin where lower(admin.username) = lower(?)";
		Admin admin = (Admin) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
		if (admin != null) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 根据用户名返回用户对象
	 */
	public Admin getAdminByUsername(String username) {
		String hql = "from Admin admin where lower(admin.username) = lower(?)";
		return (Admin) getSession().createQuery(hql).setParameter(0, username).uniqueResult();
	}
	
}