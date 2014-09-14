package org.veight.utils;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.veight.bean.SystemConfig;
import org.veight.bean.SystemConfig.WatermarkPosition;;
/**
 * 工具类 - 系统配置
 * @author Administrator
 * @date  2014-4-18 下午04:10:10
 */

public class SystemConfigUtil {
	
	public static final String CONFIG_FILE_NAME = "settings.xml";// 系统配置文件名称
	public static final String SYSTEM_CONFIG_CACHE_KEY = "systemConfig";// systemConfig缓存Key

	/**
	 * 获取系统配置信息
	 * 
	 * @return SystemConfig对象
	 */
	public static SystemConfig getSystemConfig() {
		
		SystemConfig systemConfig;
//		SystemConfig systemConfig = (SystemConfig) OsCacheConfigUtil.getFromCache(SYSTEM_CONFIG_CACHE_KEY);
//		if (systemConfig != null) {
//			return systemConfig;
//		}
		File configFile = null;
		Document document = null;
		try {
			String configFilePath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath() + CONFIG_FILE_NAME;
			configFile = new File(configFilePath);
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(configFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * 系统设置   ---- 基本设置 Node
		 */
		Node systemNameNode = document.selectSingleNode("/system/systemConfig/systemName");
		Node versionNode = document.selectSingleNode("/system/systemConfig/version");
		Node systemDescriptionNode = document.selectSingleNode("/system/systemConfig/systemDescription");
		Node webNameNode = document.selectSingleNode("/system/systemConfig/webName");
		Node webUrlNode = document.selectSingleNode("/system/systemConfig/webUrl");
		Node webLogoNode = document.selectSingleNode("/system/systemConfig/webLogo");
		Node hotSearchNode = document.selectSingleNode("/system/systemConfig/hotSearch");
		Node metaKeywordsNode = document.selectSingleNode("/system/systemConfig/metaKeywords");
		Node metaDescriptionNode = document.selectSingleNode("/system/systemConfig/metaDescription");
		Node addressNode = document.selectSingleNode("/system/systemConfig/address");
		Node phoneNode = document.selectSingleNode("/system/systemConfig/phone");
		Node zipCodeNode = document.selectSingleNode("/system/systemConfig/zipCode");
		Node emailNode = document.selectSingleNode("/system/systemConfig/email");
		Node certtextNode = document.selectSingleNode("/system/systemConfig/certtext");
		
		/**
		 * 系统设置   ---- 显示设置 Node
		 */
		Node watermarkImagePathNode = document.selectSingleNode("/system/systemConfig/watermarkImagePath");
		Node watermarkPositionNode = document.selectSingleNode("/system/systemConfig/watermarkPosition");
		Node watermarkAlphaNode = document.selectSingleNode("/system/systemConfig/watermarkAlpha");
		Node bigImageWidthNode = document.selectSingleNode("/system/systemConfig/bigImageWidth");
		Node bigImageHeightNode = document.selectSingleNode("/system/systemConfig/bigImageHeight");
		Node smallImageWidthNode = document.selectSingleNode("/system/systemConfig/smallImageWidth");
		Node smallImageHeightNode = document.selectSingleNode("/system/systemConfig/smallImageHeight");
		Node thumbnailImageWidthNode = document.selectSingleNode("/system/systemConfig/thumbnailImageWidth");
		Node thumbnailImageHeightNode = document.selectSingleNode("/system/systemConfig/thumbnailImageHeight");
		Node defaultBigImagePathNode = document.selectSingleNode("/system/systemConfig/defaultBigImagePath");
		Node defaultSmallImagePathNode = document.selectSingleNode("/system/systemConfig/defaultSmallImagePath");
		Node defaultThumbnailImagePathNode = document.selectSingleNode("/system/systemConfig/defaultThumbnailImagePath");
		
		/**
		 * 系统设置   ---- 上传设置 Node
		 */
		Node uploadLimitNode = document.selectSingleNode("/system/systemConfig/uploadLimit");
		Node allowedUploadImageExtensionNode = document.selectSingleNode("/system/systemConfig/allowedUploadImageExtension");
		Node allowedUploadMediaExtensionNode = document.selectSingleNode("/system/systemConfig/allowedUploadMediaExtension");
		Node allowedUploadFileExtensionNode = document.selectSingleNode("/system/systemConfig/allowedUploadFileExtension");
		/**
		 * 系统设置   ---- 邮件设置 Node
		 */
		Node smtpFromMailNode = document.selectSingleNode("/system/systemConfig/smtpFromMail");
		Node smtpHostNode = document.selectSingleNode("/system/systemConfig/smtpHost");
		Node smtpPortNode = document.selectSingleNode("/system/systemConfig/smtpPort");
		Node smtpUsernameNode = document.selectSingleNode("/system/systemConfig/smtpUsername");
		Node smtpPasswordNode = document.selectSingleNode("/system/systemConfig/smtpPassword");
		/**
		 * 系统设置   ---- 安全设置 Node
		 */
		Node isLoginFailureLockNode = document.selectSingleNode("/system/systemConfig/isLoginFailureLock");
		Node loginFailureLockCountNode = document.selectSingleNode("/system/systemConfig/loginFailureLockCount");
		Node loginFailureLockTimeNode = document.selectSingleNode("/system/systemConfig/loginFailureLockTime");
		Node isRegisterNode = document.selectSingleNode("/system/systemConfig/isRegister");
		/**
		 * ——————————————————————————————————————————————————————————————————————————
		 * 创建systemConfig
		 * 系统设置   ---- 基本设置 赋值
		 * ——————————————————————————————————————————————————————————————————————————
		 */
		systemConfig = new SystemConfig();
		
		systemConfig.setSystemName(systemNameNode.getText());
		systemConfig.setVersion(versionNode.getText());
		systemConfig.setSystemDescription(systemDescriptionNode.getText());
		systemConfig.setWebName(webNameNode.getText());
		systemConfig.setWebUrl(webUrlNode.getText());
		systemConfig.setWebLogo(webLogoNode.getText());
		systemConfig.setHotSearch(hotSearchNode.getText());
		systemConfig.setMetaKeywords(metaKeywordsNode.getText());
		systemConfig.setMetaDescription(metaDescriptionNode.getText());
		systemConfig.setAddress(addressNode.getText());
		systemConfig.setPhone(phoneNode.getText());
		systemConfig.setZipCode(zipCodeNode.getText());
		systemConfig.setEmail(emailNode.getText());
		systemConfig.setCerttext(certtextNode.getText());
		/**
		 * 系统设置   ---- 显示设置 赋值  
		 */
		systemConfig.setWatermarkImagePath(watermarkImagePathNode.getText());
		systemConfig.setWatermarkPosition(WatermarkPosition.valueOf(watermarkPositionNode.getText()));
		systemConfig.setWatermarkAlpha(Integer.valueOf(watermarkAlphaNode.getText()));
		systemConfig.setBigImageWidth(Integer.valueOf(bigImageWidthNode.getText()));
		systemConfig.setBigImageHeight(Integer.valueOf(bigImageHeightNode.getText()));
		systemConfig.setSmallImageWidth(Integer.valueOf(smallImageWidthNode.getText()));
		systemConfig.setSmallImageHeight(Integer.valueOf(smallImageHeightNode.getText()));
		systemConfig.setThumbnailImageWidth(Integer.valueOf(thumbnailImageWidthNode.getText()));
		systemConfig.setThumbnailImageHeight(Integer.valueOf(thumbnailImageHeightNode.getText()));
		systemConfig.setDefaultBigImagePath(defaultBigImagePathNode.getText());
		systemConfig.setDefaultSmallImagePath(defaultSmallImagePathNode.getText());
		systemConfig.setDefaultThumbnailImagePath(defaultThumbnailImagePathNode.getText());
		
		/**
		 * 系统设置   ---- 上传设置   赋值
		 */
		systemConfig.setUploadLimit(Integer.valueOf(uploadLimitNode.getText()));
		systemConfig.setAllowedUploadImageExtension(allowedUploadImageExtensionNode.getText());
		systemConfig.setAllowedUploadMediaExtension(allowedUploadMediaExtensionNode.getText());
		systemConfig.setAllowedUploadFileExtension(allowedUploadFileExtensionNode.getText());
		/**
		 * 系统设置   ---- 邮件设置   赋值
		 */
		systemConfig.setSmtpFromMail(smtpFromMailNode.getText());
		systemConfig.setSmtpHost(smtpHostNode.getText());
		systemConfig.setSmtpPort(Integer.valueOf(smtpPortNode.getText()));
		systemConfig.setSmtpUsername(smtpUsernameNode.getText());
		systemConfig.setSmtpPassword(smtpPasswordNode.getText());
		/**
		 * 系统设置   ----安全设置   赋值
		 */
		systemConfig.setIsLoginFailureLock(Boolean.valueOf(isLoginFailureLockNode.getText()));
		systemConfig.setLoginFailureLockCount(Integer.valueOf(loginFailureLockCountNode.getText()));
		systemConfig.setLoginFailureLockTime(Integer.valueOf(loginFailureLockTimeNode.getText()));
		systemConfig.setIsRegister(Boolean.valueOf(isRegisterNode.getText()));
		
		
		
		//OsCacheConfigUtil.putInCache(SYSTEM_CONFIG_CACHE_KEY, systemConfig);
		return systemConfig;
	}
	
	/**
	 * 更新系统配置信息
	 * 
	 * @param systemConfig
	 *          SystemConfig对象
	 */
	public static void update(SystemConfig systemConfig) {
		File configFile = null;
		Document document = null;
		try {
			String configFilePath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath() + CONFIG_FILE_NAME;
			configFile = new File(configFilePath);
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(configFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Element rootElement = document.getRootElement();
		Element systemConfigElement = rootElement.element("systemConfig");
		Node systemNameNode = document.selectSingleNode("/system/systemConfig/systemName");
		Node versionNode = document.selectSingleNode("/system/systemConfig/systemVersion");
		Node systemDescriptionNode = document.selectSingleNode("/system/systemConfig/systemDescription");
		Node webNameNode = document.selectSingleNode("/system/systemConfig/webName");
		Node webUrlNode = document.selectSingleNode("/system/systemConfig/webUrl");
		Node webLogoNode = document.selectSingleNode("/system/systemConfig/webLogo");
		Node hotSearchNode = document.selectSingleNode("/system/systemConfig/hotSearch");
		Node metaKeywordsNode = document.selectSingleNode("/system/systemConfig/metaKeywords");
		Node metaDescriptionNode = document.selectSingleNode("/system/systemConfig/metaDescription");
		Node addressNode = document.selectSingleNode("/system/systemConfig/address");
		Node phoneNode = document.selectSingleNode("/system/systemConfig/phone");
		Node zipCodeNode = document.selectSingleNode("/system/systemConfig/zipCode");
		Node emailNode = document.selectSingleNode("/system/systemConfig/email");
		Node currencyTypeNode = document.selectSingleNode("/system/systemConfig/currencyType");
		Node currencySignNode = document.selectSingleNode("/system/systemConfig/currencySign");
		Node currencyUnitNode = document.selectSingleNode("/system/systemConfig/currencyUnit");
		Node priceScaleNode = document.selectSingleNode("/system/systemConfig/priceScale");
		Node priceRoundTypeNode = document.selectSingleNode("/system/systemConfig/priceRoundType");
		Node orderScaleNode = document.selectSingleNode("/system/systemConfig/orderScale");
		Node orderRoundTypeNode = document.selectSingleNode("/system/systemConfig/orderRoundType");
		Node certtextNode = document.selectSingleNode("/system/systemConfig/certtext");
		Node storeAlertCountNode = document.selectSingleNode("/system/systemConfig/storeAlertCount");
		Node storeFreezeTimeNode = document.selectSingleNode("/system/systemConfig/storeFreezeTime");
		Node uploadLimitNode = document.selectSingleNode("/system/systemConfig/uploadLimit");
		Node isLoginFailureLockNode = document.selectSingleNode("/system/systemConfig/isLoginFailureLock");
		Node loginFailureLockCountNode = document.selectSingleNode("/system/systemConfig/loginFailureLockCount");
		Node loginFailureLockTimeNode = document.selectSingleNode("/system/systemConfig/loginFailureLockTime");
		Node isRegisterNode = document.selectSingleNode("/system/systemConfig/isRegister");
		Node watermarkImagePathNode = document.selectSingleNode("/system/systemConfig/watermarkImagePath");
		Node watermarkPositionNode = document.selectSingleNode("/system/systemConfig/watermarkPosition");
		Node watermarkAlphaNode = document.selectSingleNode("/system/systemConfig/watermarkAlpha");
		Node bigImageWidthNode = document.selectSingleNode("/system/systemConfig/bigImageWidth");
		Node bigImageHeightNode = document.selectSingleNode("/system/systemConfig/bigImageHeight");
		Node smallImageWidthNode = document.selectSingleNode("/system/systemConfig/smallImageWidth");
		Node smallImageHeightNode = document.selectSingleNode("/system/systemConfig/smallImageHeight");
		Node thumbnailImageWidthNode = document.selectSingleNode("/system/systemConfig/thumbnailImageWidth");
		Node thumbnailImageHeightNode = document.selectSingleNode("/system/systemConfig/thumbnailImageHeight");
		Node defaultBigImagePathNode = document.selectSingleNode("/system/systemConfig/defaultBigImagePath");
		Node defaultSmallImagePathNode = document.selectSingleNode("/system/systemConfig/defaultSmallImagePath");
		Node defaultThumbnailImagePathNode = document.selectSingleNode("/system/systemConfig/defaultThumbnailImagePath");
		Node allowedUploadImageExtensionNode = document.selectSingleNode("/system/systemConfig/allowedUploadImageExtension");
		Node allowedUploadMediaExtensionNode = document.selectSingleNode("/system/systemConfig/allowedUploadMediaExtension");
		Node allowedUploadFileExtensionNode = document.selectSingleNode("/system/systemConfig/allowedUploadFileExtension");
		Node smtpFromMailNode = document.selectSingleNode("/system/systemConfig/smtpFromMail");
		Node smtpHostNode = document.selectSingleNode("/system/systemConfig/smtpHost");
		Node smtpPortNode = document.selectSingleNode("/system/systemConfig/smtpPort");
		Node smtpUsernameNode = document.selectSingleNode("/system/systemConfig/smtpUsername");
		Node smtpPasswordNode = document.selectSingleNode("/system/systemConfig/smtpPassword");
		Node pointTypeNode = document.selectSingleNode("/system/systemConfig/pointType");
		Node pointScaleNode = document.selectSingleNode("/system/systemConfig/pointScale");
		
		if(systemNameNode == null){
			systemNameNode = systemConfigElement.addElement("systemName");
		}
		if(versionNode == null){
			versionNode = systemConfigElement.addElement("version");
		}
		if(systemDescriptionNode == null){
			systemDescriptionNode = systemConfigElement.addElement("systemDescription");
		}
		if(webNameNode == null){
			webNameNode = systemConfigElement.addElement("webName");
		}
		if(webUrlNode == null){
			webUrlNode = systemConfigElement.addElement("webUrl");
		}
		if(webLogoNode == null){
			webLogoNode = systemConfigElement.addElement("webLogo");
		}
		if(hotSearchNode == null){
			hotSearchNode = systemConfigElement.addElement("hotSearch");
		}
		if(metaKeywordsNode == null){
			metaKeywordsNode = systemConfigElement.addElement("metaKeywords");
		}
		if(metaDescriptionNode == null){
			metaDescriptionNode = systemConfigElement.addElement("metaDescription");
		}
		if(addressNode == null){
			addressNode = systemConfigElement.addElement("address");
		}
		if(phoneNode == null){
			phoneNode = systemConfigElement.addElement("phone");
		}
		if(zipCodeNode == null){
			zipCodeNode = systemConfigElement.addElement("zipCode");
		}
		if(emailNode == null){
			emailNode = systemConfigElement.addElement("email");
		}
		if(currencyTypeNode == null){
			currencyTypeNode = systemConfigElement.addElement("currencyType");
		}
		if(currencySignNode == null){
			currencySignNode = systemConfigElement.addElement("currencySign");
		}
		if(currencyUnitNode == null){
			currencyUnitNode = systemConfigElement.addElement("currencyUnit");
		}
		if(priceScaleNode == null){
			priceScaleNode = systemConfigElement.addElement("priceScale");
		}
		if(priceRoundTypeNode == null){
			priceRoundTypeNode = systemConfigElement.addElement("priceRoundType");
		}
		if(orderScaleNode == null){
			orderScaleNode = systemConfigElement.addElement("orderScale");
		}
		if(orderRoundTypeNode == null){
			orderRoundTypeNode = systemConfigElement.addElement("orderRoundType");
		}
		if(certtextNode == null){
			certtextNode = systemConfigElement.addElement("certtext");
		}
		if(storeAlertCountNode == null){
			storeAlertCountNode = systemConfigElement.addElement("storeAlertCount");
		}
		if(storeFreezeTimeNode == null){
			storeFreezeTimeNode = systemConfigElement.addElement("storeFreezeTime");
		}
		if(uploadLimitNode == null){
			uploadLimitNode = systemConfigElement.addElement("uploadLimit");
		}
		if(isLoginFailureLockNode == null){
			isLoginFailureLockNode = systemConfigElement.addElement("isLoginFailureLock");
		}
		if(loginFailureLockCountNode == null){
			loginFailureLockCountNode = systemConfigElement.addElement("loginFailureLockCount");
		}
		if(loginFailureLockTimeNode == null){
			loginFailureLockTimeNode = systemConfigElement.addElement("loginFailureLockTime");
		}
		if(isRegisterNode == null){
			isRegisterNode = systemConfigElement.addElement("isRegister");
		}
		if(watermarkImagePathNode == null){
			watermarkImagePathNode = systemConfigElement.addElement("watermarkImagePath");
		}
		if(watermarkPositionNode == null){
			watermarkPositionNode = systemConfigElement.addElement("watermarkPosition");
		}
		if(watermarkAlphaNode == null){
			watermarkAlphaNode = systemConfigElement.addElement("watermarkAlpha");
		}
		if(bigImageWidthNode == null){
			bigImageWidthNode = systemConfigElement.addElement("bigImageWidth");
		}
		if(bigImageHeightNode == null){
			bigImageHeightNode = systemConfigElement.addElement("bigImageHeight");
		}
		if(smallImageWidthNode == null){
			smallImageWidthNode = systemConfigElement.addElement("smallImageWidth");
		}
		if(smallImageHeightNode == null){
			smallImageHeightNode = systemConfigElement.addElement("smallImageHeight");
		}
		if(thumbnailImageWidthNode == null){
			thumbnailImageWidthNode = systemConfigElement.addElement("thumbnailImageWidth");
		}
		if(thumbnailImageHeightNode == null){
			thumbnailImageHeightNode = systemConfigElement.addElement("thumbnailImageHeight");
		}
		if(defaultBigImagePathNode == null){
			defaultBigImagePathNode = systemConfigElement.addElement("defaultBigImagePath");
		}
		if(defaultSmallImagePathNode == null){
			defaultSmallImagePathNode = systemConfigElement.addElement("defaultSmallImagePath");
		}
		if(defaultThumbnailImagePathNode == null){
			defaultThumbnailImagePathNode = systemConfigElement.addElement("defaultThumbnailImagePath");
		}
		if(allowedUploadImageExtensionNode == null){
			allowedUploadImageExtensionNode = systemConfigElement.addElement("allowedUploadImageExtension");
		}
		if(allowedUploadMediaExtensionNode == null){
			allowedUploadMediaExtensionNode = systemConfigElement.addElement("allowedUploadMediaExtension");
		}
		if(allowedUploadFileExtensionNode == null){
			allowedUploadFileExtensionNode = systemConfigElement.addElement("allowedUploadFileExtension");
		}
		if(smtpFromMailNode == null){
			smtpFromMailNode = systemConfigElement.addElement("smtpFromMail");
		}
		if(smtpHostNode == null){
			smtpHostNode = systemConfigElement.addElement("smtpHost");
		}
		if(smtpPortNode == null){
			smtpPortNode = systemConfigElement.addElement("smtpPort");
		}
		if(smtpUsernameNode == null){
			smtpUsernameNode = systemConfigElement.addElement("smtpUsername");
		}
		if(smtpPasswordNode == null){
			smtpPasswordNode = systemConfigElement.addElement("smtpPassword");
		}
		if(pointTypeNode == null){
			pointTypeNode = systemConfigElement.addElement("pointType");
		}
		if(pointScaleNode == null){
			pointScaleNode = systemConfigElement.addElement("pointScale");
		}
		
		systemNameNode.setText(systemConfig.getSystemName());
		versionNode.setText(systemConfig.getVersion());
		systemDescriptionNode.setText(systemConfig.getSystemDescription());

		webNameNode.setText(systemConfig.getWebName());
		webUrlNode.setText(StringUtils.removeEnd(systemConfig.getWebUrl(), "/"));
		hotSearchNode.setText(systemConfig.getHotSearch());
		metaKeywordsNode.setText(systemConfig.getMetaKeywords());
		metaDescriptionNode.setText(systemConfig.getMetaDescription());
		addressNode.setText(systemConfig.getAddress());
		phoneNode.setText(systemConfig.getPhone());
		zipCodeNode.setText(systemConfig.getZipCode());
		emailNode.setText(systemConfig.getEmail());
		certtextNode.setText(systemConfig.getCerttext());
		uploadLimitNode.setText(String.valueOf(systemConfig.getUploadLimit()));
		isLoginFailureLockNode.setText(String.valueOf(systemConfig.getIsLoginFailureLock()));
		loginFailureLockCountNode.setText(String.valueOf(systemConfig.getLoginFailureLockCount()));
		loginFailureLockTimeNode.setText(String.valueOf(systemConfig.getLoginFailureLockTime()));
		isRegisterNode.setText(String.valueOf(systemConfig.getIsRegister()));
		watermarkImagePathNode.setText(systemConfig.getWatermarkImagePath());
		watermarkPositionNode.setText(String.valueOf(systemConfig.getWatermarkPosition()));
		watermarkAlphaNode.setText(String.valueOf(systemConfig.getWatermarkAlpha()));
		bigImageWidthNode.setText(String.valueOf(systemConfig.getBigImageWidth()));
		bigImageHeightNode.setText(String.valueOf(systemConfig.getBigImageHeight()));
		smallImageWidthNode.setText(String.valueOf(systemConfig.getSmallImageWidth()));
		smallImageHeightNode.setText(String.valueOf(systemConfig.getSmallImageHeight()));
		thumbnailImageWidthNode.setText(String.valueOf(systemConfig.getThumbnailImageWidth()));
		thumbnailImageHeightNode.setText(String.valueOf(systemConfig.getThumbnailImageHeight()));
		defaultBigImagePathNode.setText(systemConfig.getDefaultBigImagePath());
		defaultSmallImagePathNode.setText(systemConfig.getDefaultSmallImagePath());
		defaultThumbnailImagePathNode.setText(systemConfig.getDefaultThumbnailImagePath());
		allowedUploadImageExtensionNode.setText(systemConfig.getAllowedUploadImageExtension());
		allowedUploadMediaExtensionNode.setText(systemConfig.getAllowedUploadMediaExtension());
		allowedUploadFileExtensionNode.setText(systemConfig.getAllowedUploadFileExtension());
		smtpFromMailNode.setText(systemConfig.getSmtpFromMail());
		smtpHostNode.setText(systemConfig.getSmtpHost());
		if (systemConfig.getSmtpPort() == null) {
			smtpPortNode.setText("25");
		} else {
			smtpPortNode.setText(String.valueOf(systemConfig.getSmtpPort()));
		}
		smtpUsernameNode.setText(systemConfig.getSmtpUsername());
		smtpPasswordNode.setText(systemConfig.getSmtpPassword());
	

		try {
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();// 设置XML文档输出格式
			outputFormat.setEncoding("UTF-8");// 设置XML文档的编码类型
			outputFormat.setIndent(true);// 设置是否缩进
			outputFormat.setIndent("	");// 以TAB方式实现缩进
			outputFormat.setNewlines(true);// 设置是否换行
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(configFile), outputFormat);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//OsCacheConfigUtil.flushEntry(SYSTEM_CONFIG_CACHE_KEY);
	}
	
	/**
	 * 刷新系统配置信息
	 * 
	 */
	public void flush() {
		//OsCacheConfigUtil.flushEntry(SYSTEM_CONFIG_CACHE_KEY);
	}
}