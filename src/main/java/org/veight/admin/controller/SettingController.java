package org.veight.admin.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.veight.bean.SystemConfig;
import org.veight.bean.SystemConfig.WatermarkPosition;
import org.veight.utils.SystemConfigUtil;


/**
 * Controller - 系统设置
 * 
 * 
 * 
 */
@Controller("adminstingController")
@RequestMapping("/admin/settings")
public class SettingController extends ABaseController {

	private static final long serialVersionUID = -6200425957233641240L;

	private SystemConfig systemConfig;
	private File webLogo;
	private String webLogoFileName;
	private File defaultBigImage;
	private String defaultBigImageFileName;
	private File defaultSmallImage;
	private String defaultSmallImageFileName;
	private File defaultThumbnailImage;
	private String defaultThumbnailImageFileName;
	private File watermarkImage;
	private String watermarkImageFileName;
	private List<WatermarkPosition> allWatermarkPosition;
	// 编辑
	@RequestMapping("/edit.xhtml")
	public String edit(ModelMap model) {
		systemConfig = SystemConfigUtil.getSystemConfig();
		model.addAttribute("systemConfig", systemConfig);
		return "admin/settings/settings_edit";
	}
	// 获取所有WatermarkPosition值
	// 更新
	@RequestMapping("/update.do")
	public String update(HttpServletRequest request) throws Exception {
		SystemConfig persistent = SystemConfigUtil.getSystemConfig();
		
		if (webLogo != null || defaultBigImage != null || defaultSmallImage != null || defaultThumbnailImage != null || watermarkImage != null) {
			String allowedUploadImageExtension = getSystemConfig().getAllowedUploadImageExtension().toLowerCase();
			if (StringUtils.isEmpty(allowedUploadImageExtension)){
				//addActionError("不允许上传图片文件!");
				return ERROR;
			}
			String[] imageExtensionArray = allowedUploadImageExtension.split(SystemConfig.EXTENSION_SEPARATOR);
			if (defaultBigImage != null) {
				String defaultBigImageExtension =  StringUtils.substringAfterLast(defaultBigImageFileName, ".").toLowerCase();
				if (!ArrayUtils.contains(imageExtensionArray, defaultBigImageExtension)) {
					//addActionError("只允许上传图片文件类型: " + allowedUploadImageExtension + "!");
					return ERROR;
				}
			}
			if (defaultSmallImage != null) {
				String defaultSmallImageExtension =  StringUtils.substringAfterLast(defaultSmallImageFileName, ".").toLowerCase();
				if (!ArrayUtils.contains(imageExtensionArray, defaultSmallImageExtension)) {
					//addActionError("只允许上传图片文件类型: " + allowedUploadImageExtension + "!");
					return ERROR;
				}
			}
			if (defaultThumbnailImage != null) {
				String defaultThumbnailImageExtension =  StringUtils.substringAfterLast(defaultThumbnailImageFileName, ".").toLowerCase();
				if (!ArrayUtils.contains(imageExtensionArray, defaultThumbnailImageExtension)) {
					//addActionError("只允许上传图片文件类型: " + allowedUploadImageExtension + "!");
					return ERROR;
				}
			}
			if (watermarkImage != null) {
				String watermarkImageExtension =  StringUtils.substringAfterLast(watermarkImageFileName, ".").toLowerCase();
				if (!ArrayUtils.contains(imageExtensionArray, watermarkImageExtension)) {
					//addActionError("只允许上传图片文件类型: " + allowedUploadImageExtension + "!");
					return ERROR;
				}
			}
		}
		
		int uploadLimit = systemConfig.getUploadLimit() * 1024;
		if (uploadLimit != 0) {
			if (webLogo != null && webLogo.length() > uploadLimit) {
				//addActionError("网店Logo文件大小超出限制!");
				return ERROR;
			}
			if (defaultBigImage != null && defaultBigImage.length() > uploadLimit) {
				//addActionError("默认商品图片（大）文件大小超出限制!");
				return ERROR;
			}
			if (defaultSmallImage != null && defaultSmallImage.length() > uploadLimit) {
				//addActionError("默认商品图片（小）文件大小超出限制!");
				return ERROR;
			}
			if (defaultThumbnailImage != null && defaultThumbnailImage.length() > uploadLimit) {
				//addActionError("默认缩略图文件大小超出限制!");
				return ERROR;
			}
			if (watermarkImage != null && watermarkImage.length() > uploadLimit) {
				//addActionError("水印图片文件大小超出限制!");
				return ERROR;
			}
		}
		if (StringUtils.isEmpty(systemConfig.getSmtpPassword())) {
			systemConfig.setSmtpPassword(persistent.getSmtpPassword());
		}
		if (systemConfig.getIsLoginFailureLock() == false) {
			systemConfig.setLoginFailureLockCount(3);
			systemConfig.setLoginFailureLockTime(10);
		}
		// 处理默认商品图片（大）
		if (defaultBigImage != null) {
			File oldDefaultBigProductImageFile = new File(request.getSession().getServletContext().getRealPath(persistent.getDefaultBigImagePath()));
			if (oldDefaultBigProductImageFile.exists()) {
				oldDefaultBigProductImageFile.delete();
			}
			String defaultBigProductImagePath = SystemConfig.UPLOAD_IMAGE_DIR + SystemConfig.DEFAULT_BIG_IMAGE_FILE_NAME + "." +  StringUtils.substringAfterLast(defaultBigImageFileName, ".").toLowerCase();
			File defaultBigProductImageFile = new File(request.getSession().getServletContext().getRealPath(defaultBigProductImagePath));
			FileUtils.copyFile(defaultBigImage, defaultBigProductImageFile);
			persistent.setDefaultBigImagePath(defaultBigProductImagePath);
		}
		// 处理默认商品图片（小）
		if (defaultSmallImage != null) {
			File oldDefaultSmallProductImageFile = new File(request.getSession().getServletContext().getRealPath(persistent.getDefaultSmallImagePath()));
			if (oldDefaultSmallProductImageFile.exists()) {
				oldDefaultSmallProductImageFile.delete();
			}
			String defaultSmallProductImagePath = SystemConfig.UPLOAD_IMAGE_DIR + SystemConfig.DEFAULT_SMALL_IMAGE_FILE_NAME + "." +  StringUtils.substringAfterLast(defaultSmallImageFileName, ".").toLowerCase();
			File defaultSmallProductImageFile = new File(request.getSession().getServletContext().getRealPath(defaultSmallProductImagePath));
			FileUtils.copyFile(defaultSmallImage, defaultSmallProductImageFile);
			persistent.setDefaultSmallImagePath(defaultSmallProductImagePath);
		}
		// 处理默认商品缩略图
		if (defaultThumbnailImage != null) {
			File oldDefaultThumbnailProductImageFile = new File(request.getSession().getServletContext().getRealPath(persistent.getDefaultThumbnailImagePath()));
			if (oldDefaultThumbnailProductImageFile.exists()) {
				oldDefaultThumbnailProductImageFile.delete();
			}
			String defaultThumbnailProductImagePath = SystemConfig.UPLOAD_IMAGE_DIR + SystemConfig.DEFAULT_THUMBNAIL_IMAGE_FILE_NAME + "."
					+  StringUtils.substringAfterLast(defaultThumbnailImageFileName, ".").toLowerCase();
			File defaultThumbnailProductImageFile = new File(request.getSession().getServletContext().getRealPath(defaultThumbnailProductImagePath));
			FileUtils.copyFile(defaultThumbnailImage, defaultThumbnailProductImageFile);
			persistent.setDefaultThumbnailImagePath(defaultThumbnailProductImagePath);
		}
		// 处理水印图片
		if (watermarkImage != null) {
			File oldWatermarkImageFile = new File(request.getSession().getServletContext().getRealPath(persistent.getWatermarkImagePath()));
			if (oldWatermarkImageFile.exists()) {
				oldWatermarkImageFile.delete();
			}
			String watermarkImagePath = SystemConfig.UPLOAD_IMAGE_DIR + SystemConfig.WATERMARK_IMAGE_FILE_NAME + "." +  StringUtils.substringAfterLast(watermarkImageFileName, ".").toLowerCase();
			File watermarkImageFile = new File(request.getSession().getServletContext().getRealPath(watermarkImagePath));
			FileUtils.copyFile(watermarkImage, watermarkImageFile);
			persistent.setWatermarkImagePath(watermarkImagePath);
		}
		BeanUtils.copyProperties(systemConfig, persistent, new String[] {"systemName", "version", "systemDescription", "defaultBigImagePath", "defaultSmallImagePath", "defaultThumbnailImagePath", "watermarkImagePath"});
		SystemConfigUtil.update(persistent);
		
		return SUCCESS;
	}
	
	//获取水印的添加位置
	public List<WatermarkPosition> getAllWatermarkPosition() {
		this.allWatermarkPosition = new ArrayList<WatermarkPosition>();
		for (WatermarkPosition watermarkPosition : WatermarkPosition.values()) {
			this.allWatermarkPosition.add(watermarkPosition);
		}
		return this.allWatermarkPosition;
	}
	public void setAllWatermarkPosition(List<WatermarkPosition> allWatermarkPosition) {
			this.allWatermarkPosition = allWatermarkPosition;
	}

	public SystemConfig getSystemConfig() {
		return systemConfig;
	}

	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

	public File getWebLogo() {
		return webLogo;
	}

	public void setWebLogo(File webLogo) {
		this.webLogo = webLogo;
	}

	public String getWebLogoFileName() {
		return webLogoFileName;
	}

	public void setWebLogoFileName(String webLogoFileName) {
		this.webLogoFileName = webLogoFileName;
	}

	public File getDefaultBigImage() {
		return defaultBigImage;
	}

	public void setDefaultBigImage(File defaultBigImage) {
		this.defaultBigImage = defaultBigImage;
	}

	public String getDefaultBigImageFileName() {
		return defaultBigImageFileName;
	}

	public void setDefaultBigImageFileName(String defaultBigImageFileName) {
		this.defaultBigImageFileName = defaultBigImageFileName;
	}

	public File getDefaultSmallImage() {
		return defaultSmallImage;
	}

	public void setDefaultSmallImage(File defaultSmallImage) {
		this.defaultSmallImage = defaultSmallImage;
	}

	public String getDefaultSmallImageFileName() {
		return defaultSmallImageFileName;
	}

	public void setDefaultSmallImageFileName(String defaultSmallImageFileName) {
		this.defaultSmallImageFileName = defaultSmallImageFileName;
	}

	public File getDefaultThumbnailImage() {
		return defaultThumbnailImage;
	}

	public void setDefaultThumbnailImage(File defaultThumbnailImage) {
		this.defaultThumbnailImage = defaultThumbnailImage;
	}

	public String getDefaultThumbnailImageFileName() {
		return defaultThumbnailImageFileName;
	}

	public void setDefaultThumbnailImageFileName(
			String defaultThumbnailImageFileName) {
		this.defaultThumbnailImageFileName = defaultThumbnailImageFileName;
	}

	public File getWatermarkImage() {
		return watermarkImage;
	}

	public void setWatermarkImage(File watermarkImage) {
		this.watermarkImage = watermarkImage;
	}

	public String getWatermarkImageFileName() {
		return watermarkImageFileName;
	}

	public void setWatermarkImageFileName(String watermarkImageFileName) {
		this.watermarkImageFileName = watermarkImageFileName;
	}

}