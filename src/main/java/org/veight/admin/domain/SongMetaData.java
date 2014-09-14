package org.veight.admin.domain;

import javax.persistence.Entity;

/**
 * 声音元数据  普通bean
 * @author 王坤
 * @时间 2014-5-19 下午11:00:14
 * @开发团队  845885222@qq.com
 * 说明：具体介绍 请查看document下的《doc-002-声音的元数据mp3 metadata.doc》文件
 */
@Entity
public class SongMetaData extends ABaseEntity{
	private static final long serialVersionUID = 6085673236595385191L;
	
	private String title;
	//媒体文件头信息
	private String mediaType;//文件类型
	private long bitRate;//比特率
	private String format;
	private boolean variableBitRate;//比特率是否可变
	private String duration;//TrackLength 字符串表示
	private int size;//TrackLength 时长 （秒显示）
	//媒体文件信息
	private String artist;
	private int artistId;
	private String albumArtist;
	private String composer;
	private String album;
	private int albumId;
	private Short trackNr;
	private Short trackNrs;
	private Short discNr;
	private Short discNrs;
	private Short year;
	private String genre;
	private String lyrics;
	private boolean hasLyrics;
	private boolean isCoverArtEmbedded;
	private String path;
	private String artworkPath;
	private long modified;
	
	private String artistSort;
	private String albumArtistSort;

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public long getBitRate() {
		return bitRate;
	}
	public void setBitRate(long bitRate) {
		this.bitRate = bitRate;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public boolean isVariableBitRate() {
		return variableBitRate;
	}
	public void setVariableBitRate(boolean variableBitRate) {
		this.variableBitRate = variableBitRate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getAlbumArtist() {
		return albumArtist;
	}
	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public Short getTrackNr() {
		return trackNr;
	}
	public void setTrackNr(Short trackNr) {
		this.trackNr = trackNr;
	}
	public Short getTrackNrs() {
		return trackNrs;
	}
	public void setTrackNrs(Short trackNrs) {
		this.trackNrs = trackNrs;
	}
	public Short getDiscNr() {
		return discNr;
	}
	public void setDiscNr(Short discNr) {
		this.discNr = discNr;
	}
	public Short getDiscNrs() {
		return discNrs;
	}
	public void setDiscNrs(Short discNrs) {
		this.discNrs = discNrs;
	}
	public Short getYear() {
		return year;
	}
	public void setYear(Short year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
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
	public boolean isCoverArtEmbedded() {
		return isCoverArtEmbedded;
	}
	public void setCoverArtEmbedded(boolean isCoverArtEmbedded) {
		this.isCoverArtEmbedded = isCoverArtEmbedded;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getArtworkPath() {
		return artworkPath;
	}
	public void setArtworkPath(String artworkPath) {
		this.artworkPath = artworkPath;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public long getModified() {
		return modified;
	}
	public void setModified(long modified) {
		this.modified = modified;
	}
	public String getArtistSort() {
		return artistSort;
	}
	public void setArtistSort(String artistSort) {
		this.artistSort = artistSort;
	}
	public String getAlbumArtistSort() {
		return albumArtistSort;
	}
	public void setAlbumArtistSort(String albumArtistSort) {
		this.albumArtistSort = albumArtistSort;
	}

}