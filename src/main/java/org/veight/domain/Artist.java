package org.veight.domain;

import javax.persistence.Entity;

/**
 * 歌手（ 艺人）（ 乐队） -实体类
 * @author Administrator
 * @时间 2014-5-20 下午11:09:24
 * @开发团队  845885222@qq.com
 */
@Entity
public class Artist extends ABaseEntity{

	private static final long serialVersionUID = 1751033322748167837L;
	
	private String name;
	private String gender;
	private String sortName; //简写名
	private String smallImageUrl;
	private String mediumImageUrl;
	private String largeImageUrl;
	private String extraLargeImageUrl; //超大图
	private int listeners;
	private int playCount;
	private String bioSummary;  //个人简介描述
	private String bioContent;  //个人简介内容
	private int albumCount;
	
	
	//setter and getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public String getMediumImageUrl() {
		return mediumImageUrl;
	}
	public void setMediumImageUrl(String mediumImageUrl) {
		this.mediumImageUrl = mediumImageUrl;
	}
	public String getLargeImageUrl() {
		return largeImageUrl;
	}
	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}
	public String getExtraLargeImageUrl() {
		return extraLargeImageUrl;
	}
	public void setExtraLargeImageUrl(String extraLargeImageUrl) {
		this.extraLargeImageUrl = extraLargeImageUrl;
	}
	public int getListeners() {
		return listeners;
	}
	public void setListeners(int listeners) {
		this.listeners = listeners;
	}
	public int getPlayCount() {
		return playCount;
	}
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	public String getBioSummary() {
		return bioSummary;
	}
	public void setBioSummary(String bioSummary) {
		this.bioSummary = bioSummary;
	}
	public String getBioContent() {
		return bioContent;
	}
	public void setBioContent(String bioContent) {
		this.bioContent = bioContent;
	}
	public int getAlbumCount() {
		return albumCount;
	}
	public void setAlbumCount(int albumCount) {
		this.albumCount = albumCount;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}