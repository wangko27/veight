package org.veight.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.veight.utils.CustomDateSerializer;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
/**
 * 后台管理员
 * @author Administrator
 *
 */
@Entity
@Table(name = "v_admin")
public class Admin extends ABaseEntity implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;// 用户名
	private String password;// 密码
	private String email;// E-mail
	private String name;// 姓名
	private String department;// 部门
	private Boolean isAccountEnabled;// 账号是否启用
	private Boolean isAccountLocked;// 账号是否锁定
	private Boolean isAccountExpired;// 账号是否过期
	private Boolean isCredentialsExpired;// 凭证是否过期
	private Integer loginFailureCount;// 连续登录失败的次数
	private Date lockedDate;// 账号锁定日期
	private Date loginDate;// 最后登录日期
	private String loginIp;// 最后登录IP
	/** 角色  JsonIgnore 防止json死循环*/
	@JsonIgnore
	private Set<Role> roles = new HashSet<Role>();
	private Collection<GrantedAuthority> authorities;// 角色信息
	/**
	 * 1 以下几个方法是继承自spring security 的UserDetails 
	 * 2 并不需要在数据生成相应的字段
	 * */
	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	@Transient
	public boolean isAccountNonExpired() {
		return !this.isAccountExpired;
	}
	@Transient
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !this.isAccountLocked;
	}
	@Transient
	public boolean isCredentialsNonExpired() {
		return !this.isCredentialsExpired;
		
	}
	@Transient
	public boolean isEnabled() {
		return !this.isAccountEnabled;
	}
	@NotEmpty(message="用户名不能为空")
	@Size(min = 4, max = 20,message="用户名长度限制在{2}到{1}位之间.")
	@Pattern(regexp = "^[0-9a-z_A-Z\\u4e00-\\u9fa5]+$",message="请输入正确的用户名.")
	@Length(min = 2, max = 20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@NotEmpty(message="密码不能为空.")
	@Size(min = 4, max = 20,message="密码长度限制在{2}到{1}位之间.")
	@Length(min = 2, max = 20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@NotEmpty(message="邮件不能为空.")
	@Email(message="请输入正确的邮件.")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@NotEmpty(message="姓名不能为空.")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Boolean getIsAccountEnabled() {
		return isAccountEnabled;
	}
	public void setIsAccountEnabled(Boolean isAccountEnabled) {
		this.isAccountEnabled = isAccountEnabled;
	}
	public Boolean getIsAccountLocked() {
		return isAccountLocked;
	}
	public void setIsAccountLocked(Boolean isAccountLocked) {
		this.isAccountLocked = isAccountLocked;
	}
	public Boolean getIsAccountExpired() {
		return isAccountExpired;
	}
	public void setIsAccountExpired(Boolean isAccountExpired) {
		this.isAccountExpired = isAccountExpired;
	}
	public Boolean getIsCredentialsExpired() {
		return isCredentialsExpired;
	}
	public void setIsCredentialsExpired(Boolean isCredentialsExpired) {
		this.isCredentialsExpired = isCredentialsExpired;
	}
	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}
	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}
	/**时间格式话 json*/
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getLockedDate() {
		return lockedDate;
	}
	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}
	/**时间格式话 json*/
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	/**
	 * 获取角色
	 * 
	 * @return 角色
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "v_admin_role")
	public Set<Role> getRoles() {
		return roles;
	}
	/**
	 * 设置角色
	 * 
	 * @param roles
	 *            角色
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
