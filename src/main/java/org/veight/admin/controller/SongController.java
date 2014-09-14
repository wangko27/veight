package org.veight.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.veight.admin.domain.Artist;
import org.veight.admin.domain.Genre;
import org.veight.admin.domain.ImageInfo;
import org.veight.admin.domain.Song;
import org.veight.admin.service.ArtistService;
import org.veight.admin.service.GenreService;
import org.veight.admin.service.ImageInfoService;
import org.veight.admin.service.SongService;
import org.veight.bean.Pager;

/**
 * 歌曲 Controller
 * @author Administrator
 * 时间 ：2014-7-29 下午09:26:42
 */
@Controller
@RequestMapping("/admin/song")
public class SongController extends ABaseController {
	//注入
	@Resource
	private SongService songService;
	@Resource
	private ArtistService artistService;
	@Resource
	private GenreService genreService;
	@Resource
	private ImageInfoService imageInfoService;
	//歌曲列表页
	@RequestMapping("/list.xhtml")
	public String list(){
		return "admin/song/song_list";
	}
	//歌曲列表内容
	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String,Object> listJSON(int page,int rows){
		System.out.println("listJSON");
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		Pager pager = new Pager();
		pager.setPageNumber(page);
		pager.setPageSize(rows);
		
		pager = songService.findByPager(pager);
		jsonMap.put("total", pager.getTotalCount().toString());//total键 存放总记录数，必须的 
		//需要级联获取 先获取一下
		ArrayList<Song> al =new ArrayList<Song>();
		for(Object temp:pager.getList()){
			Song s = (Song)temp;
			s.getFavoriteMemberSet();
			al.add(s);
		}
		jsonMap.put("rows", al);
		return jsonMap;
	}
	//添加界面
	@RequestMapping("/add.xhtml")
	public String add(ModelMap model){
		List<Artist> artistListAll = artistService.getAll();
		List<Genre> genreListAll = genreService.getAll();
		
		model.addAttribute("artistListAll", artistListAll);
		model.addAttribute("genreListAll", genreListAll);
		
		return "admin/song/song_add";
	}
	//添加
	@RequestMapping("/save.xhtml")
	public String save(String genreId,Song song,BindingResult result,ModelMap model){
		
		Genre genre = genreService.get(genreId);
		song.setGenre(genre);
		songService.save(song);
		genre.getSongSet().add(song);
		return "admin/song/song_list";
	}
	@RequestMapping("/delete.do")
	@ResponseBody
	public Map<String, Object> delete(String[] ids,ModelMap model){
		songService.delete(ids);
		return ajaxJsonSuccessMessage("删除成功");
	}
	//上传歌曲封面
	@RequestMapping("/uploadImage.do")
	@ResponseBody
	public Map<String, Object> uploadImage(@RequestParam(value = "upload", required = false) MultipartFile multipartFile, HttpServletRequest request){
		System.out.println("uploadImage");
		String path=request.getSession().getServletContext().getRealPath("/");
		String savepath = imageInfoService.upload(path, multipartFile);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put(STATUS, SUCCESS);
		jsonMap.put("url", savepath);
		System.out.println("SongController line 107:"+savepath);
		return jsonMap;
	}
}
