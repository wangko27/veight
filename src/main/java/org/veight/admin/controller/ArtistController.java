package org.veight.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.veight.domain.Artist;
import org.veight.admin.service.ArtistService;
import org.veight.bean.Pager;

/**
 * 歌手管理控制器
 * @author 845885222@qq.com
 * 路径： ArtistController.java
 * 时间 ：2014-8-9 下午07:25:53
 */
@Controller
@RequestMapping("/admin/artist")
public class ArtistController extends ABaseController{
	
	@Resource
	private ArtistService artistService;
	//歌手列表页
	@RequestMapping("/list.xhtml")
	public String list(){
		return "admin/artist/artist_list";
	}
	//歌手列表内容
	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String,Object> listJSON(int page,int rows){
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		Pager pager = new Pager();
		pager.setPageNumber(page);
		pager.setPageSize(rows);
		
		pager = artistService.findByPager(pager);
		jsonMap.put("total", pager.getTotalCount().toString());//total键 存放总记录数，必须的 
		//需要级联获取 先获取一下
		ArrayList<Artist> al =new ArrayList<Artist>();
		for(Object temp:pager.getList()){
			Artist artist= (Artist)temp;
			al.add(artist);
		}
		jsonMap.put("rows", al);
		return jsonMap;
	}
	//添加界面
	@RequestMapping("/add.xhtml")
	public String add(ModelMap model){
		return "admin/artist/artist_add";
	}
	//保存
	@RequestMapping("/save.xhtml")
	public String save(Artist artist,HttpServletRequest request,ModelMap model){
		String largeImageUrl = UPLOAD_IMAGE_ARTIST_DIR+"/0/default_large.jpg";
		String mediumImageUrl = UPLOAD_IMAGE_ARTIST_DIR+"/0/default_medium.jpg";
		String smallImageUrl = UPLOAD_IMAGE_ARTIST_DIR+"/0/default_thumbnail.jpg";
		//设置默认图片
		artist.setLargeImageUrl(largeImageUrl);
		artist.setMediumImageUrl(mediumImageUrl);
		artist.setSmallImageUrl(smallImageUrl);
		artistService.save(artist);
		return "admin/artist/artist_list";
	}
	//删除
	@RequestMapping("/delete.do")
	@ResponseBody
	public Map<String, Object> delete(String[] ids,ModelMap model){
		artistService.delete(ids);
		return ajaxJsonSuccessMessage("删除成功");
	}
}
