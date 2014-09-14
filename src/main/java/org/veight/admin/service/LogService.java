package org.veight.admin.service;

import org.veight.admin.domain.Log;

/**
 * Service - 日志
 */
public interface LogService extends ABaseService<Log, Long> {

	/**
	 * 清空日志
	 */
	void clear();

}