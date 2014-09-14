package org.veight.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 普通对象 - 系统配置
 * @author Administrator
 * @date  2014-4-18 下午02:56:40
 */
public class SystemConfig {

	// 水印位置（无、左上、右上、居中、左下、右下）
	public enum WatermarkPosition {
		no, topLeft, topRight, center, bottomLeft, bottomRight
	}

	// 积分获取方式（禁用积分获取、按订单总额计算、为商品单独设置）
	public enum PointType {
		disable, orderAmount, productSet
	}

	public static final String HOT_SEARCH_SEPARATOR = ",";// 热门搜索分隔符
	public static final String EXTENSION_SEPARATOR = ",";// 文件扩展名分隔符

	public static final String LOGO_UPLOAD_NAME = "logo";// Logo图片文件名称(不包含扩张名)
	public static final String DEFAULT_BIG_IMAGE_FILE_NAME = "default_big_product_image";// 默认图片（大）文件名称(不包含扩展名)
	public static final String DEFAULT_SMALL_IMAGE_FILE_NAME = "default_small_product_image";// 默认图片（小）文件名称(不包含扩展名)
	public static final String DEFAULT_THUMBNAIL_IMAGE_FILE_NAME = "default_thumbnail_product_image";// 缩略图文件名称(不包含扩展名)
	public static final String WATERMARK_IMAGE_FILE_NAME = "watermark";// 水印图片文件名称(不包含扩展名)

	public static final String UPLOAD_IMAGE_DIR = "/upload/image/";// 图片文件上传目录
	public static final String UPLOAD_SOURCE_DIR = "/upload/media/";// 媒体原文件上传保存目录（没有进行任何处理，包括未转码，未压制，未分割）
	public static final String UPLOAD_MEDIA_VIDEO_DIR = "/upload/video/";// 媒体文件上传目录(视频)
	public static final String UPLOAD_MEDIA_MUSIC_DIR = "/upload/music/";// 媒体文件上传目录(音乐)
	public static final String UPLOAD_FILE_DIR = "/upload/file/";// 其它文件上传目录

	private String systemName;// 系统名称
	private String version;// 系统版本
	private String systemDescription;// 系统描述

	private String webName;// 站点名称
	private String webUrl;// 站点网址
	private String webLogo;// 站点Logo
	private String hotSearch;// 热门搜索关键词

	private String metaKeywords;// 首页页面关键词
	private String metaDescription;// 首页页面描述

	private String address;// 联系地址
	private String phone;// 联系电话
	private String zipCode;// 邮编
	private String email;// 联系email
	

	private String certtext;// 备案号
	private Integer uploadLimit;// 文件上传最大值,0表示无限制,单位KB
	private Boolean isLoginFailureLock; // 是否开启登录失败锁定账号功能
	private Integer loginFailureLockCount;// 同一账号允许连续登录失败的最大次数，超出次数后将锁定其账号
	private Integer loginFailureLockTime;// 账号锁定时间(单位：分钟,0表示永久锁定)
	private Boolean isRegister;// 是否开放注册

	private String watermarkImagePath; // 水印图片路径
	private WatermarkPosition watermarkPosition; // 水印位置
	private Integer watermarkAlpha;// 水印透明度

	private Integer bigImageWidth;// 图片（大）宽度
	private Integer bigImageHeight;// 图片（大）高度
	private Integer smallImageWidth;// 图片（小）宽度
	private Integer smallImageHeight;// 图片（小）高度
	private Integer thumbnailImageWidth;// 缩略图宽度
	private Integer thumbnailImageHeight;// 缩略图高度

	private String defaultBigImagePath;// 默认图片（大）
	private String defaultSmallImagePath;// 默认图片（小）
	private String defaultThumbnailImagePath;// 默认缩略图

	private String allowedUploadImageExtension;// 允许上传的图片文件扩展名（为空表示不允许上传图片文件）
	private String allowedUploadMediaExtension;// 允许上传的媒体文件扩展名（为空表示不允许上传媒体文件）
	private String allowedUploadFileExtension;// 允许上传的文件扩展名（为空表示不允许上传文件）

	private String smtpFromMail;// 发件人邮箱
	private String smtpHost;// SMTP服务器地址
	private Integer smtpPort;// SMTP服务器端口
	private String smtpUsername;// SMTP用户名
	private String smtpPassword;// SMTP密码

	private PointType pointType;// 积分获取方式
	private Double pointScale;// 积分换算比率

	//stter and getter
	
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSystemDescription() {
		return systemDescription;
	}
	public void setSystemDescription(String systemDescription) {
		this.systemDescription = systemDescription;
	}


	public String getWebName() {
		return webName;
	}


	public void setWebName(String webName) {
		this.webName = webName;
	}


	public String getWebUrl() {
		return webUrl;
	}


	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}


	public String getWebLogo() {
		return webLogo;
	}


	public void setWebLogo(String webLogo) {
		this.webLogo = webLogo;
	}


	public String getHotSearch() {
		return hotSearch;
	}


	public void setHotSearch(String hotSearch) {
		this.hotSearch = hotSearch;
	}


	public String getMetaKeywords() {
		return metaKeywords;
	}


	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}


	public String getMetaDescription() {
		return metaDescription;
	}


	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCerttext() {
		return certtext;
	}


	public void setCerttext(String certtext) {
		this.certtext = certtext;
	}


	public Integer getUploadLimit() {
		return uploadLimit;
	}


	public void setUploadLimit(Integer uploadLimit) {
		this.uploadLimit = uploadLimit;
	}


	public Boolean getIsLoginFailureLock() {
		return isLoginFailureLock;
	}


	public void setIsLoginFailureLock(Boolean isLoginFailureLock) {
		this.isLoginFailureLock = isLoginFailureLock;
	}


	public Integer getLoginFailureLockCount() {
		return loginFailureLockCount;
	}


	public void setLoginFailureLockCount(Integer loginFailureLockCount) {
		this.loginFailureLockCount = loginFailureLockCount;
	}


	public Integer getLoginFailureLockTime() {
		return loginFailureLockTime;
	}


	public void setLoginFailureLockTime(Integer loginFailureLockTime) {
		this.loginFailureLockTime = loginFailureLockTime;
	}


	public Boolean getIsRegister() {
		return isRegister;
	}


	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
	}


	public String getWatermarkImagePath() {
		return watermarkImagePath;
	}


	public void setWatermarkImagePath(String watermarkImagePath) {
		this.watermarkImagePath = watermarkImagePath;
	}


	public WatermarkPosition getWatermarkPosition() {
		return watermarkPosition;
	}


	public void setWatermarkPosition(WatermarkPosition watermarkPosition) {
		this.watermarkPosition = watermarkPosition;
	}


	public Integer getWatermarkAlpha() {
		return watermarkAlpha;
	}


	public void setWatermarkAlpha(Integer watermarkAlpha) {
		this.watermarkAlpha = watermarkAlpha;
	}


	public Integer getBigImageWidth() {
		return bigImageWidth;
	}


	public void setBigImageWidth(Integer bigImageWidth) {
		this.bigImageWidth = bigImageWidth;
	}


	public Integer getBigImageHeight() {
		return bigImageHeight;
	}


	public void setBigImageHeight(Integer bigImageHeight) {
		this.bigImageHeight = bigImageHeight;
	}


	public Integer getSmallImageWidth() {
		return smallImageWidth;
	}


	public void setSmallImageWidth(Integer smallImageWidth) {
		this.smallImageWidth = smallImageWidth;
	}


	public Integer getSmallImageHeight() {
		return smallImageHeight;
	}


	public void setSmallImageHeight(Integer smallImageHeight) {
		this.smallImageHeight = smallImageHeight;
	}


	public Integer getThumbnailImageWidth() {
		return thumbnailImageWidth;
	}


	public void setThumbnailImageWidth(Integer thumbnailImageWidth) {
		this.thumbnailImageWidth = thumbnailImageWidth;
	}


	public Integer getThumbnailImageHeight() {
		return thumbnailImageHeight;
	}


	public void setThumbnailImageHeight(Integer thumbnailImageHeight) {
		this.thumbnailImageHeight = thumbnailImageHeight;
	}


	public String getDefaultBigImagePath() {
		return defaultBigImagePath;
	}


	public void setDefaultBigImagePath(String defaultBigImagePath) {
		this.defaultBigImagePath = defaultBigImagePath;
	}


	public String getDefaultSmallImagePath() {
		return defaultSmallImagePath;
	}


	public void setDefaultSmallImagePath(String defaultSmallImagePath) {
		this.defaultSmallImagePath = defaultSmallImagePath;
	}


	public String getDefaultThumbnailImagePath() {
		return defaultThumbnailImagePath;
	}


	public void setDefaultThumbnailImagePath(
			String defaultThumbnailImagePath) {
		this.defaultThumbnailImagePath = defaultThumbnailImagePath;
	}


	public String getAllowedUploadImageExtension() {
		return allowedUploadImageExtension;
	}


	public void setAllowedUploadImageExtension(String allowedUploadImageExtension) {
		this.allowedUploadImageExtension = allowedUploadImageExtension;
	}


	public String getAllowedUploadMediaExtension() {
		return allowedUploadMediaExtension;
	}


	public void setAllowedUploadMediaExtension(String allowedUploadMediaExtension) {
		this.allowedUploadMediaExtension = allowedUploadMediaExtension;
	}


	public String getAllowedUploadFileExtension() {
		return allowedUploadFileExtension;
	}


	public void setAllowedUploadFileExtension(String allowedUploadFileExtension) {
		this.allowedUploadFileExtension = allowedUploadFileExtension;
	}


	public String getSmtpFromMail() {
		return smtpFromMail;
	}


	public void setSmtpFromMail(String smtpFromMail) {
		this.smtpFromMail = smtpFromMail;
	}


	public String getSmtpHost() {
		return smtpHost;
	}


	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}


	public Integer getSmtpPort() {
		return smtpPort;
	}


	public void setSmtpPort(Integer smtpPort) {
		this.smtpPort = smtpPort;
	}


	public String getSmtpUsername() {
		return smtpUsername;
	}


	public void setSmtpUsername(String smtpUsername) {
		this.smtpUsername = smtpUsername;
	}


	public String getSmtpPassword() {
		return smtpPassword;
	}


	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}


	public PointType getPointType() {
		return pointType;
	}


	public void setPointType(PointType pointType) {
		this.pointType = pointType;
	}


	public Double getPointScale() {
		return pointScale;
	}


	public void setPointScale(Double pointScale) {
		this.pointScale = pointScale;
	}


	// 获取热门搜索关键词集合
	public List<String> getHotSearchList() {
		return StringUtils.isNotEmpty(hotSearch) ? Arrays.asList(hotSearch.split(HOT_SEARCH_SEPARATOR)) : new ArrayList<String>();
	}

}