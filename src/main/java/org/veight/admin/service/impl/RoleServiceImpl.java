package org.veight.admin.service.impl;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.veight.admin.dao.RoleDao;
import org.veight.domain.Role;
import org.veight.admin.service.RoleService;
/**
 * 角色 服务实现
 * @author Administrator
 *
 */
@Service()
public class RoleServiceImpl extends ABaseServiceImpl<Role, String> implements RoleService{
	
	@Resource
	public void setBaseDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
	}
}
