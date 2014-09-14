package org.veight.admin.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.veight.admin.domain.SongMetaData;
import org.veight.utils.Mp3Util;

/**
 * spr mvc上传文件
 * @author Administrator
 * 时间 ：2014-7-30 下午08:24:28
 */
@Controller
@RequestMapping("/admin/upload")
public class UploadController extends ABaseController{
	
	private static final String UPLOAD_IMAGE_DIR = "/upload/images";
	
	private static final String UPLOAD_MP3_DIR = "/upload/mp3/";
	//上传MP3
	@RequestMapping("/uploadMp3.json")
	@ResponseBody
	public Map<String, Object> uploadMp3(@RequestParam(value = "upload", required = false) MultipartFile multipartFile, HttpServletRequest request){
		System.out.println("line 34 uploadMp3");
		if (multipartFile == null) {
			//return ajaxJsonErrorMessage("请选择上传文件!");
		}
		//上传保存的目录
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		String dateString = simpleDateFormat.format(new Date());
		//上传保存的路径
		File uploadMp3Dir = new File(request.getSession().getServletContext().getRealPath(UPLOAD_MP3_DIR)+"/"+dateString);
		if (!uploadMp3Dir.exists()) {
			uploadMp3Dir.mkdirs();
		}
		File targetFile = new File(uploadMp3Dir,multipartFile.getOriginalFilename());
		 //保存  
        try {  
        	multipartFile.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
		SongMetaData songMetaData = Mp3Util.getSongMetaData(targetFile);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(STATUS, SUCCESS);
		jsonMap.put("jsonSongMetaData", songMetaData);
		jsonMap.put("url", UPLOAD_IMAGE_DIR+"/"+multipartFile.getOriginalFilename());
		
		return jsonMap;
	}
}
