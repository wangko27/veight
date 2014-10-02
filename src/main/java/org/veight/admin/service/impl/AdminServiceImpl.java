package org.veight.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.veight.admin.dao.AdminDao;
import org.veight.domain.Admin;
import org.veight.admin.service.AdminService;
/**
 * Service实现类 - 管理员
 * @author Administrator
 * @date  2014-4-1 上午11:35:54
 */

@Service
public class AdminServiceImpl extends ABaseServiceImpl<Admin, String> implements AdminService {

	@Resource
	private AdminDao adminDao;

	@Resource
	public void setBaseDao(AdminDao adminDao) {
		super.setBaseDao(adminDao);
	}

	public Admin getLoginAdmin() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}
		Object principal = authentication.getPrincipal();
		if (principal == null || !(principal instanceof Admin)) {
			return null;
		} else {
			return (Admin) principal;
		}
	}

	public Admin loadLoginAdmin() {
		Admin admin = getLoginAdmin();
		if (admin == null) {
			return null;
		} else {
			return adminDao.load(admin.getId());
		}
	}
	
	public boolean isExistByUsername(String username) {
		return adminDao.isExistByUsername(username);
	}
	
	public Admin getAdminByUsername(String username) {
		return adminDao.getAdminByUsername(username);
	}

}