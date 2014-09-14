package org.veight.admin.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * 歌曲类型(曲风)  实体类
 * @author Administrator
 * @时间 2014-5-20 下午10:25:12
 * @开发团队  845885222@qq.com
 * 
 */
@Entity
public class Genre extends ABaseEntity{
	private static final long serialVersionUID = -4248978769658450017L;

	private String name;
	private String description;
	private long songCount;
	private Set<Song> songSet;

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
	public Set<Song> getSongSet() {
		return songSet;
	}
	public void setSongSet(Set<Song> songSet) {
		this.songSet = songSet;
	}
	@Transient
	public long getSongCount() {
		this.songCount=songSet.size();
		return this.songCount;
	}
	public void setSongCount(long songCount) {
		this.songCount = songCount;
	}
}
