package org.veight.admin.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.groups.Default;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import org.veight.utils.CustomDateSerializer;

/**
 * 实体类 - 基类
 * @author Administrator
 * @date  2014-3-31 下午05:06:01
 *
 */
@MappedSuperclass
public class ABaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;// ID
	private Date createDate;// 创建日期
	private Date modifyDate;// 修改日期

	/**
	 * 保存验证组
	 */
	public interface Save extends Default {

	}
	/**
	 * 更新验证组
	 */
	public interface Update extends Default {

	}
	
	@Id
	@Column(length = 32, nullable = true)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(updatable = false)
	//@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	@JsonSerialize(using = CustomDateSerializer.class)  
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	//@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
	@JsonSerialize(using = CustomDateSerializer.class)  
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public int hashCode() {
		return id == null ? System.identityHashCode(this) : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass().getPackage() != obj.getClass().getPackage()) {
			return false;
		}
		final ABaseEntity other = (ABaseEntity) obj;
		if (id == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!id.equals(other.getId())) {
			return false;
		}
		return true;
	}
}
