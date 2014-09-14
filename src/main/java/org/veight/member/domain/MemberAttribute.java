package org.veight.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import org.veight.admin.domain.ABaseEntity;

/**
 * 会员注册项实体类 
 * @author Administrator
 * @时间 2014-6-29 上午9:08:03
 * @开发团队  845885222@qq.com
 */

@Entity
public class MemberAttribute extends ABaseEntity {

	private static final long serialVersionUID = 4513705276569738136L;
	
	// 注册项类型：
	public enum AttributeType {
		text, number, alphaint, email, select, checkbox, name, gender, date, area, address, zipCode, mobile, phone, qq, msn, wangwang, skype
	}

	private String name;// 注册项名称
	private AttributeType attributeType;// 注册项类型
	private Boolean isRequired;// 是否必填
	private Boolean isEnabled;// 是否启用
	private Integer orderList;// 排序
	private String attributeOptionStore;// 可选项储存

	@Column(nullable = false, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Enumerated
	@Column(nullable = false)
	public AttributeType getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}

	@Column(nullable = false)
	public Boolean getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	@Column(nullable = false)
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Column(nullable = false)
	public Integer getOrderList() {
		return orderList;
	}

	public void setOrderList(Integer orderList) {
		this.orderList = orderList;
	}
	
	public String getAttributeOptionStore() {
		return attributeOptionStore;
	}

	public void setAttributeOptionStore(String attributeOptionStore) {
		this.attributeOptionStore = attributeOptionStore;
	}
	

}