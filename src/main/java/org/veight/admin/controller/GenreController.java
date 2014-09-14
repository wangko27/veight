package org.veight.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.veight.admin.domain.Genre;
import org.veight.admin.service.GenreService;
import org.veight.bean.Pager;

/**
 * 曲风管理控制器
 * @author Administrator
 * 时间 ：2014-7-31 下午10:12:46
 */
@Controller
@RequestMapping("/admin/genre")
public class GenreController extends ABaseController {
	
	@Resource
	private GenreService genreService;
	
	//曲风列表页
	@RequestMapping("/list.xhtml")
	public String list(){
		return "admin/genre/genre_list";
	}
	//列表内容
	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String,Object> listJSON(int page,int rows){
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		Pager pager = new Pager();
		pager.setPageNumber(page);
		pager.setPageSize(rows);
		
		pager = genreService.findByPager(pager);
		jsonMap.put("total", pager.getTotalCount().toString());//total键 存放总记录数，必须的 
		//需要级联获取 先获取一下
		ArrayList<Genre> al =new ArrayList<Genre>();
		for(Object temp:pager.getList()){
			Genre genre = (Genre)temp;
			al.add(genre);
		}
		jsonMap.put("rows", al);
		return jsonMap;
	}
	//添加
	@RequestMapping("/add.xhtml")
	public String add(){
		return "admin/genre/genre_add";
	}
	//保存
	@RequestMapping("/save.action")
	public String save(Genre genre,ModelMap model){
		genreService.save(genre);
		return "admin/genre/genre_list";
	}
	//删除
	@RequestMapping("/delete.do")
	@ResponseBody
	public Map<String, Object> delete(String[] ids,ModelMap model){
		for(String id :ids){
			System.out.println(id);
			Genre genre =genreService.get(id);
			if(genre.getSongSet().size()==0){
				genreService.delete(genre);
			}
		}
		return ajaxJsonSuccessMessage("删除成功");
	}
}
