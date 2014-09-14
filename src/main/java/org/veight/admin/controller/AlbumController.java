package org.veight.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.veight.admin.domain.Album;
import org.veight.admin.domain.Artist;
import org.veight.admin.service.AlbumService;
import org.veight.admin.service.ArtistService;
import org.veight.bean.Pager;

/**
 * 控制器  专辑管理
 * @author Administrator
 * 时间 ：2014-8-19 下午07:47:29
 */
@Controller
@RequestMapping("/admin/album")
public class AlbumController extends ABaseController{
	
	@Resource
	private AlbumService albumService;
	@Resource
	private ArtistService artistService;
	//专辑列表页
	@RequestMapping("/list.xhtml")
	public String list(){
		return "admin/album/album_list";
	}
	//专辑列表内容
	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String,Object> listJSON(int page,int rows){
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		Pager pager = new Pager();
		pager.setPageNumber(page);
		pager.setPageSize(rows);
		pager = albumService.findByPager(pager);
		jsonMap.put("total", pager.getTotalCount().toString());//total键 存放总记录数，必须的 
		//需要级联获取 先获取一下
		ArrayList<Album> al =new ArrayList<Album>();
		for(Object temp:pager.getList()){
			Album album= (Album)temp;
			al.add(album);
		}
		jsonMap.put("rows", al);
		return jsonMap;
	}
	//添加
	@RequestMapping("/add.xhtml")
	public String add(ModelMap model){
		List<Artist>  artistListAll= artistService.getAll();
		model.addAttribute("artistListAll", artistListAll);
		return "admin/album/album_add";
	}
	//保存
	@RequestMapping("/save.xhtml")
	public String save(String artistId,Album album,HttpServletRequest request,ModelMap model){
		Artist artist =artistService.get(artistId);
		album.setArtist(artist);
		albumService.save(album);
		return "admin/album/album_list";
	}
	//删除
	@RequestMapping("/delete.do")
	@ResponseBody
	public Map<String, Object> delete(String[] ids,ModelMap model){
		albumService.delete(ids);
		return ajaxJsonSuccessMessage("删除成功");
	}
}
