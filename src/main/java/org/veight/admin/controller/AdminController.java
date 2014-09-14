package org.veight.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.veight.admin.domain.Admin;
import org.veight.admin.domain.Role;
import org.veight.admin.service.AdminService;
import org.veight.admin.service.RoleService;
import org.veight.bean.Pager;

@Controller
@RequestMapping("/admin/admin")
public class AdminController extends ABaseController{
	@Resource
	private AdminService adminService;
	@Resource
	private RoleService roleService;
	//角色显示页
	@RequestMapping("/list.xhtml")
	public String list() {
		return "/admin/admin/admin_list";
	}
	//角色列表内容
	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String,Object> listJSON(int page,int rows){
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		Pager pager = new Pager();
		pager.setPageNumber(page);
		pager.setPageSize(rows);
		
		pager = adminService.findByPager(pager);
		jsonMap.put("total", pager.getTotalCount().toString());//total键 存放总记录数，必须的 
		//需要级联获取 先获取一下
		ArrayList<Admin> al =new ArrayList<Admin>();
		for(Object temp:pager.getList()){
			Admin admin= (Admin)temp;
			al.add(admin);
		}
		jsonMap.put("rows", al);
		return jsonMap;
	}
	/**
	 * 添加
	 */
	@RequestMapping(value = "/add.xhtml")
	public String add(@Valid @ModelAttribute("adminForm") Admin admin,BindingResult result,ModelMap model) {
		model.addAttribute("roles", roleService.getAll());
		return "/admin/admin/admin_add";
	}
	/**
	 * 保存
	 */
	@RequestMapping(value = "/save.action")
	public String save(String[] roleIds,@Valid @ModelAttribute("adminForm") Admin admin,BindingResult result) {
		if (result.hasErrors()) {
			return "/admin/admin/admin_add";
		}
		//if (adminService.isExistByUsername(admin.getUsername())) {
			//return ERROR_VIEW;
			System.out.println("已存在");
		//}
		
		//admin.setUsername(admin.getUsername().toLowerCase());
		//admin.setIsAccountEnabled(true);
		//admin.setLoginFailureCount(0);
		//admin.setIsAccountLocked(false);
		//admin.setIsAccountExpired(false);
		//admin.setIsCredentialsExpired(false);
		//admin.setLoginDate(new Date());
		//admin.setLoginIp(request.getRemoteAddr());
		//String passwordMd5 = DigestUtils.md5Hex(admin.getPassword());
		//admin.setPassword(passwordMd5);
		//角色
		//admin.setRoles(new HashSet<Role>(roleService.get(roleIds)));
		//adminService.save(admin);
		return "/admin/admin/admin_list";
	}
}
