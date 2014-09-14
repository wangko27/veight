package org.veight.admin.service;
import org.springframework.web.multipart.MultipartFile;
import org.veight.admin.domain.ImageInfo;

/**
 * 图片上传服务接口
 * @author Administrator
 * 时间 ：2014-9-7 下午08:52:37
 */
public interface ImageInfoService {
	/**
	 * 文件上传
	 * 
	 * @param path
	 *            上传路径
	 * @param file
	 *            上传文件
	 */
	public String upload(String path,MultipartFile multipartFile);
	/**
	 * 生成图片
	 * 
	 * @param imageInfo
	 *            图片信息
	 */
	public void build(ImageInfo imageInfo);
}
