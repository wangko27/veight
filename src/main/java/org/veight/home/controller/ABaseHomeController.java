package org.veight.home.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 基础控制器
 * @author Administrator
 * 时间 ：2014-7-30 下午08:28:02
 */
public class ABaseHomeController extends MultiActionController{

	public static final String STATUS = "status";
	public static final String WARN = "warn";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String MESSAGE = "message";
	public static final String UPLOAD_IMAGE_ARTIST_DIR = "/upload/images/artist";
	// 输出JSON普通文本消息
	public Map<String,Object> ajaxJsonMessage(String message){
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		jsonMap.put(MESSAGE, message);
		return jsonMap;
	}
	
	// 输出JSON输出失败
	public Map<String,Object> ajaxJsonErrorMessage(String message){
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		jsonMap.put(STATUS, ERROR);
		jsonMap.put(MESSAGE, message);
		return jsonMap;
	}
	// 输出JSON警告消息
	public Map<String,Object> ajaxJsonWarnMessage(String message){
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		jsonMap.put(STATUS, WARN);
		jsonMap.put(MESSAGE, message);
		return jsonMap;
	}
	// 输出JSON成功消息
	public Map<String,Object> ajaxJsonSuccessMessage(String message){
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		jsonMap.put(STATUS, SUCCESS);
		jsonMap.put(MESSAGE, message);
		return jsonMap;
	}
	/**
	 * 获取当前登录用户名
	 * 
	 * @return 当前登录用户名,若不存在则返回null
	 */
	protected String getCurrentUsername(){
		//通过spring Secrity获取一个授权对象 然后取得username
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails  user= (UserDetails)auth.getPrincipal();
		return user.getUsername();
	}
}
