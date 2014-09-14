package org.veight.admin.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 资源管理 控制器
 * @author Administrator
 * 时间 ：2014-8-1 下午10:21:37
 */
@Controller
@RequestMapping("/admin/document")
public class DocumentController extends ABaseController{

	private static final String ROOT_DIR = "/upload/";

	//到文件列表页面
	@RequestMapping("/list.xhtml")
	public String list(String directory,HttpServletRequest request,ModelMap model){
		System.out.println("list:"+directory);
		model.addAttribute("directory", directory);
		return "admin/document/document_list";
	}
	//获取该目录下的所有文件
	@RequestMapping("/listFiles.json")
	@ResponseBody
	public List<Map<String,Object>> listFiles(String directory,HttpServletRequest request,ModelMap model){
		List<Map<String,Object>> listJSON=new ArrayList<Map<String,Object>>();
		
		String dirPath = request.getSession().getServletContext().getRealPath(ROOT_DIR+directory);
		File dir =new File(dirPath);
		File[] files = dir.listFiles();
		//  Arrays.sort(files, new FileComparator());     //按文件名排序
		for (File file : files) {
			if (!file.isDirectory()) {
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("id", file.getName());
				map.put("name", file.getName());
				map.put("type", file.getName().split("\\.")[file.getName().split("\\.").length - 1]);
				map.put("size", file.length());
				map.put("createDate", file.lastModified());
				listJSON.add(map);
			}
		}
		//return "admin/document/document_list";
		return listJSON;
	}

	/*
	 * 显示文件所有目录  以/upload为根目录
	 */
	@RequestMapping("/showDirectoryTree.json")
	@ResponseBody
	public List<Map<String,Object>> showDirectoryTree(String directory,HttpServletRequest request){

		List<Map<String,Object>> tree=new ArrayList<Map<String,Object>>();

		Map<String,Object> rootNode=new HashMap<String,Object>();

		String dirPath = request.getSession().getServletContext().getRealPath(directory);
		File dir = new File(dirPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		rootNode.put("id", 0);
		rootNode.put("text", "文件目录");
		rootNode.put("state", "closed");

		int rootFolderLength = dirPath.length();   //作用见listFolers函数

		listFolders(rootNode, dir, 0, rootFolderLength);

		tree.add(rootNode);
		return tree;
	}
	//新建文件夹
	@RequestMapping("/addFolder.do")
	@ResponseBody
	public Map<String,Object> addFolder(String directory,String folderName,HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		String dirPath = request.getSession().getServletContext().getRealPath(ROOT_DIR+directory);

		File sourceFolder = new File(dirPath,folderName);
		if(sourceFolder.exists()){
			map.put("success", false);
		}else{
			sourceFolder.mkdir();
			map.put("success", true);
		}
		map.put("relativePath", directory+File.separatorChar+folderName);
		return map;
	}
	//删除文件夹
	@RequestMapping("/romoveFolder.do")
	@ResponseBody
	public Map<String,Object> romoveFolder(String directory,String folderName,HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		String dirPath = request.getSession().getServletContext().getRealPath(ROOT_DIR+directory);
		File sourceFolder = new File(dirPath);
		if(!sourceFolder.exists()){
			map.put("success", false);
			map.put("message", "该目录不存在或已被删除.");
			return map;
		}
		if(sourceFolder.listFiles().length>0){
			map.put("success", false);
			map.put("message", "该目录下有文件或目录，不能被删除");
		}else{
			sourceFolder.delete();
			map.put("success", true);
		}
		return map;
	}
	/**
	 * 
	 * @param directory  
	 * 			传入相对路径也就是/upload 下的
	 * @param newFolderName  
	 * 			新文件的名字
	 * @param request
	 * @return
	 */
	@RequestMapping("/renameFolder.json")
	@ResponseBody
	public Map<String,Object> renameFolder(String directory,String newFolderName,HttpServletRequest request){
		String dirPath = request.getSession().getServletContext().getRealPath(ROOT_DIR+directory);
		String newDir = dirPath.substring(0, dirPath.lastIndexOf(File.separatorChar) + 1) + newFolderName;
		Map<String,Object> map=new HashMap<String,Object>();
		File sourceFolder = new File(dirPath);
		if(!sourceFolder.exists()){
			sourceFolder.mkdir();
		}
		map.put("success", sourceFolder.renameTo(new File(newDir)));
		return map;
	}

	/**
	 * 列出指定目录内的所有文件夹，并递归执行
	 * 调用者需要确保dir存在，而且必须为folder
	 * 专门为showDirectoryTree服务
	 * @param node 
	 * 		父节点
	 * @param dir  
	 * 		目录
	 * @param pid 
	 * 		父亲节点的id（dtree）
	 * @param rootFolderLength 
	 * 		计算相对路径的时候
	 */
	private void listFolders(Map<String,Object> node, File dir, int pid, int rootFolderLength) {
		List<Map<String,Object>> children=new ArrayList<Map<String,Object>>();
		//递归处理子目录
		File[] files = dir.listFiles();
		//  Arrays.sort(files, new FileComparator());     //按文件名排序
		for (File file : files) {
			if (file.isDirectory()) {
				Map<String,Object> nodeTemp=new HashMap<String,Object>();
				int nodeID = children.size() + 1; //计算新节点的id，按顺序递增
				nodeTemp.put("id", nodeID);
				nodeTemp.put("pid", pid);
				nodeTemp.put("text", file.getName());
				//计算相对rootFolder的路径作为树形目录每个节点的tooltip（title）
				//+1是为了去除开始的'/'，跟前边的listFiles函数设计一致
				String relativePath = file.getAbsolutePath().substring(rootFolderLength + 1);
				/*在windows平台，需要替换\，不然会在后边的listFiles中出错。在string中一个正斜杠用两个\表示，所以这里要用4个\
				 */
				Map<String,Object> attributes=new HashMap<String,Object>();

				relativePath = relativePath.replaceAll("\\\\", "/");     //在windows平台，需要替换\，
				attributes.put("relativePath", relativePath);
				//attributes 是为了在easyui tree中增加一个保存相对路径的属性
				nodeTemp.put("attributes", attributes);

				nodeTemp.put("url", "javascript:void(0)");
				children.add(nodeTemp);
				node.put("children",children);
				if (file.listFiles().length != 0) { //有子目录
					listFolders(nodeTemp, file, nodeID, rootFolderLength);   //递归
				}
			}
		}

	}
}
