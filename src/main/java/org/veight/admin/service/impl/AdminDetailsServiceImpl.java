package org.veight.admin.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.veight.admin.dao.AdminDao;
import org.veight.domain.Admin;
import org.veight.domain.Role;
/**
 * Service实现类 - 后台权限认证
 * @author Administrator
 * @date  2014-4-1 上午11:30:43
 */

@Service
@Transactional
public class AdminDetailsServiceImpl implements UserDetailsService {

	private static final long serialVersionUID = 2653636739190406891L;

	@Resource
	private AdminDao adminDao;

	public Admin loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		Admin admin = adminDao.getAdminByUsername(username);
		if (admin == null) {
			System.out.println("管理员[" + username + "]不存在!");
			throw new UsernameNotFoundException("管理员[" + username + "]不存在!");
		}else{
			System.out.println("admin.getIsAccountLocked:"+admin.getIsAccountLocked());
			if (admin.getIsAccountLocked() == true) {
						admin.setLoginFailureCount(0);
						admin.setIsAccountLocked(false);
						admin.setLockedDate(null);
						adminDao.update(admin);
			
			}
			admin.setAuthorities(getGrantedAuthorities(admin));
		}
		return admin;
	}


	// 获得管理角色数组
	public Collection<GrantedAuthority> getGrantedAuthorities(Admin admin) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		System.out.println(admin.getName()+"用户的权限列表：");
		for (Role role : admin.getRoles()) {
			//grantedAuthorities.add(new GrantedAuthorityImpl(role.getValue()));
			//grantedAuthorities.add(new GrantedAuthorityImpl(role.getValue()));
//			for(Module module:role.getModuleSet()){
//				System.out.print(module.getValue()+",");
//				grantedAuthorities.add(new GrantedAuthorityImpl(module.getValue()));
//			}
		}
		return grantedAuthorities;
	}


}