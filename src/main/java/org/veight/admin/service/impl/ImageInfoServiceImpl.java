package org.veight.admin.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.veight.admin.dao.ImageInfoDao;
import org.veight.domain.ImageInfo;
import org.veight.admin.service.ImageInfoService;

/**
 * 图片服务实现
 *
 * @author Administrator 时间 ：2014-9-7 下午09:00:09
 */
@Service
public class ImageInfoServiceImpl extends ABaseServiceImpl<ImageInfo, String> implements ImageInfoService {

    @Resource
    private ImageInfoDao imageInfoDao;

    @Resource
    public void setBaseDao(ImageInfoDao imageInfoDao) {
        super.setBaseDao(imageInfoDao);
    }

    public void build(ImageInfo imageInfo) {

    }

    /**
     * 文件上传
     *
     * @param path 上传的物理路径
     * @param file 上传文件
     */
    public String upload(String path, MultipartFile multipartFile) {
        //path的格式要是/
        ImageInfo imageInfo = new ImageInfo();
        //上传保存的目录 按年月存储
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        String dateString = simpleDateFormat.format(new Date());
        String type = multipartFile.getOriginalFilename().split("\\.")[multipartFile.getOriginalFilename().split("\\.").length - 1];
        //上传保存的路径
        File uploadImagesDir = new File(path + "/" + ImageInfo.UPLOAD_IMAGE_DIR + "/" + dateString + "/source");
        if (!uploadImagesDir.exists()) {
             uploadImagesDir.mkdirs();
        }
        String uuid = UUID.randomUUID().toString();
        File targetFile = new File(uploadImagesDir, uuid + "." + type);
        try {
            //上传
            multipartFile.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //保存图片信息实体
        imageInfo.setName(multipartFile.getOriginalFilename());
        imageInfo.setSource(uploadImagesDir + "/source/" + uuid + "." + type);
        imageInfo.setLarge(uploadImagesDir + "/large/" + uuid + "." + type);
        imageInfo.setMedium(uploadImagesDir + "/medium/" + uuid + "." + type);
        imageInfo.setThumbnail(uploadImagesDir + "/thumbnail/" + uuid + "." + type);
        imageInfoDao.save(imageInfo);
        //返回图片的相对路径
        return ImageInfo.UPLOAD_IMAGE_DIR +"/" + dateString + "/source/" + uuid + "." + type;
    }

}
