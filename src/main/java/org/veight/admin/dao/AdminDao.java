package org.veight.admin.dao;

import org.veight.admin.domain.Admin;
/**
 *  Dao接口 - 管理员
 * @author Administrator
 * @date  2014-4-1 上午11:16:39
 */
public interface AdminDao extends ABaseDao<Admin, String> {
	
	/**
	 * 根据用户名判断此用户是否存在（不区分大小写）
	 * 
	 */
	public boolean isExistByUsername(String username);
	
	/**
	 * 根据用户名获取管理员对象，若管理员不存在，则返回null（不区分大小写）
	 * 
	 */
	public Admin getAdminByUsername(String username);

}