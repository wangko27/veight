package org.veight.admin.domain;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
/**
 * 实体类 歌曲分类
 * @author Administrator
 * 时间 ：2014-7-27 下午06:31:38
 */
@Entity
public class SongCategory extends ABaseEntity {

	private static final long serialVersionUID = -6499561194993637501L;
	
	private String name;// 分类名称
	private String metaKeywords;// 页面关键词
	private String metaDescription;// 页面描述
	private Integer orderList;// 排序
	
	private SongCategory parent;// 上级分类
	private Set<SongCategory> children;// 下级分类
	private Set<Song> songSet;// 商品

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 5000)
	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	@Column(length = 5000)
	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	@Column(nullable = false)
	public Integer getOrderList() {
		return orderList;
	}

	public void setOrderList(Integer orderList) {
		this.orderList = orderList;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public SongCategory getParent() {
		return parent;
	}
	public void setParent(SongCategory parent) {
		this.parent = parent;
	}

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	@OrderBy("orderList asc")
	public Set<SongCategory> getChildren() {
		return children;
	}

	public void setChildren(Set<SongCategory> children) {
		this.children = children;
	}
	
	@OneToMany(mappedBy = "songCategory", fetch = FetchType.LAZY)
	public Set<Song> getSongSet() {
		return songSet;
	}
	public void setSongSet(Set<Song> songSet) {
		this.songSet = songSet;
	}

}
