package org.veight.admin.dao.impl;
import org.springframework.stereotype.Repository;
import org.veight.admin.dao.LogDao;
import org.veight.admin.domain.Log;
/**
 * Dao - 日志
 */
@Repository
public class LogDaoImpl extends ABaseDaoImpl<Log, Long> implements LogDao {

	public void removeAll() {
		String jpql = "delete from Log log";
		getSession().createQuery(jpql).executeUpdate();
	}

}