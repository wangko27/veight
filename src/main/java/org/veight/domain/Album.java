package org.veight.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/**
 * 专辑 实体类
 * @author Administrator
 * @时间 2014-5-20 下午10:03:32
 * @开发团队  845885222@qq.com
 * cover 封面
 * genre 曲风
 */
@Entity
public class Album extends ABaseEntity{
	private static final long serialVersionUID = -5920308856880712793L;

	private String name;
	private Artist artist;
	private String year;  //发行年份
	private String coverArtistPath;
	private boolean coverArtistEmbedded;
	private String coverArtsistURL;
	private Set<Song> songSet;
	//专辑信息
	private String smallImageUrl;
	private String mediumImageUrl;
	private String largeImageUrl;
	private String extraLargeImageUrl;
	private int listeners;
	private int playCount;

	private String path;
	private int songCount;

	private String genre;
	private Date lastScanned;

	//setter and getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToOne
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCoverArtistPath() {
		return coverArtistPath;
	}
	public void setCoverArtistPath(String coverArtistPath) {
		this.coverArtistPath = coverArtistPath;
	}
	public boolean isCoverArtistEmbedded() {
		return coverArtistEmbedded;
	}
	public void setCoverArtistEmbedded(boolean coverArtistEmbedded) {
		this.coverArtistEmbedded = coverArtistEmbedded;
	}
	public String getCoverArtsistURL() {
		return coverArtsistURL;
	}
	public void setCoverArtsistURL(String coverArtsistURL) {
		this.coverArtsistURL = coverArtsistURL;
	}
	@OneToMany
	public Set<Song> getSongSet() {
		return songSet;
	}
	public void setSongSet(Set<Song> songSet) {
		this.songSet = songSet;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getSongCount() {
		return songCount;
	}
	public void setSongCount(int songCount) {
		this.songCount = songCount;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getLastScanned() {
		return lastScanned;
	}
	public void setLastScanned(Date lastScanned) {
		this.lastScanned = lastScanned;
	}
}