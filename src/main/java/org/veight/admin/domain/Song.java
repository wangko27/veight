package org.veight.admin.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.veight.member.domain.Member;

/**
 * 歌曲 实体类
 * @author 王坤
 * @时间 2014-5-20 下午10:02:17
 * @开发团队  845885222@qq.com
 * composer 作曲
 * lyricist 作词
 * 说明：mediaType(媒体类型)请参照SongMetaData.java下的enum MediaType
 * 
 * 修改 时间 ：2014-7-27 下午06:34:16
  */
@Entity
public class Song extends ABaseEntity{
	private static final long serialVersionUID = -1441177500277743997L;
	
	private String name;
	private Artist artist;
	private Album album;
	private String path;
	private boolean status;//状态 审核通过
	
	private String artist1;
	private String album1;

	private String mediaType; 
	private String year;//发行时间
	private Genre genre;
	private int playCount;
	private String lyrics;
	private boolean hasLyrics;
	
	private String smallImageUrl;
	private String mediumImageUrl;
	private String largeImageUrl;
	private String extraLargeImageUrl; //超大图
	
	private SongMetaData songMetaData;
	private String time;//这里显示 不是MP3真实时间长度,但需要与MP3元数据保持一致
	private int size;
	private String recordCompany;
	private String composer;
	private String lyricist;
	private String area;
	private String language;
	private String encoder = "";
	
	private Set<Member> favoriteMemberSet; // 收藏夹会员
	private SongCategory songCategory;// 歌曲分类
	
	// setter and getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
//		if (year != null && year.length() > 4) {
//			year = year.substring(0, 4);
//		}
//		this.year = isDigits(year) && toShort(year) > 1500 
//				? toShort(year) : null;
		this.year = year;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	public boolean isHasLyrics() {
		return hasLyrics;
	}
	public void setHasLyrics(boolean hasLyrics) {
		this.hasLyrics = hasLyrics;
	}
	@OneToOne
	public SongMetaData getSongMetaData() {
		return songMetaData;
	}
	public void setSongMetaData(SongMetaData songMetaData) {
		this.songMetaData = songMetaData;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getRecordCompany() {
		return recordCompany;
	}
	public void setRecordCompany(String recordCompany) {
		this.recordCompany = recordCompany;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public String getLyricist() {
		return lyricist;
	}
	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getEncoder() {
		return encoder;
	}
	public void setEncoder(String encoder) {
		this.encoder = encoder;
	}
	public int getPlayCount() {
		return playCount;
	}
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	public String getArtist1() {
		return artist1;
	}
	public void setArtist1(String artist1) {
		this.artist1 = artist1;
	}
	public String getAlbum1() {
		return album1;
	}
	public void setAlbum1(String album1) {
		this.album1 = album1;
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
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="favoriteSongSet")
	@JsonIgnore
	public Set<Member> getFavoriteMemberSet() {
		return favoriteMemberSet;
	}
	public void setFavoriteMemberSet(Set<Member> favoriteMemberSet) {
		this.favoriteMemberSet = favoriteMemberSet;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	public SongCategory getSongCategory() {
		return songCategory;
	}
	public void setSongCategory(SongCategory songCategory) {
		this.songCategory = songCategory;
	}
	
}
