package org.veight.domain.member;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.veight.domain.ABaseEntity;
import org.veight.domain.ABaseEntity;

/**
 * 会员等级实体类
 * @author Administrator
 * @时间 2014-6-29 下午5:51:48
 * @开发团队  845885222@qq.com
 */
@Entity
@Table(name = "v_member_rank")
public class MemberRank extends ABaseEntity {

	private static final long serialVersionUID = 3599029355500655209L;
	private String name;// 等級名称
	private Integer point;// 积分
	private Boolean isDefault;// 是否为默认等级
	private Set<Member> memberSet;// 会员

	@Column(nullable = false, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(nullable = false, unique = true)
	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Column(nullable = false)
	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	@OneToMany(mappedBy = "memberRank", fetch = FetchType.LAZY)
	public Set<Member> getMemberSet() {
		return memberSet;
	}

	public void setMemberSet(Set<Member> memberSet) {
		this.memberSet = memberSet;
	}

}