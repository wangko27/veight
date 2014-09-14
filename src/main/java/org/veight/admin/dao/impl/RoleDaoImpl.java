package org.veight.admin.dao.impl;

import org.springframework.stereotype.Repository;
import org.veight.admin.dao.RoleDao;
import org.veight.admin.domain.Role;
/**
 * 角色 DAO 实现
 * @author Administrator
 *
 */
@Repository
public class RoleDaoImpl extends ABaseDaoImpl<Role, String> implements RoleDao{

}
