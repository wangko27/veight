package org.veight.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * 专辑类型  实体类
 * @author Administrator
 * @时间 2014-5-19 下午10:20:34
 * @开发团队  845885222@qq.com
 * 说明：专辑类型说明详见document下的《doc-001-音乐专辑的专辑类型.doc》文件
 */
@Entity
public class AlbumType extends ABaseEntity{
	private static final long serialVersionUID = -4248978769658450017L;

	private String name;
	private String description;
	//该专辑类型下的专辑结合
	private Set<Album> ablumSet;

	//setter and getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@OneToMany
	public Set<Album> getAblumSet() {
		return ablumSet;
	}

	public void setAblumSet(Set<Album> ablumSet) {
		this.ablumSet = ablumSet;
	}


}
