package org.veight.admin.dao;

import org.veight.domain.Log;

/**
 * Dao - 日志
 * 
 */
public interface LogDao extends ABaseDao<Log, Long> {

	/**
	 * 删除所有日志
	 */
	void removeAll();

}