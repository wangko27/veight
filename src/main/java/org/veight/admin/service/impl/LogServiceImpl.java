package org.veight.admin.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.veight.admin.dao.LogDao;
import org.veight.admin.domain.Log;
import org.veight.admin.service.LogService;
/**
 * Service - 日志
 */
@Service("logServiceImpl")
public class LogServiceImpl extends ABaseServiceImpl<Log, Long> implements LogService {

	@Resource
	private LogDao logDao;

	@Resource
	public void setBaseDao(LogDao logDao) {
		super.setBaseDao(logDao);
	}

	public void clear() {
		logDao.removeAll();
	}

}