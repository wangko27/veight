package org.veight.admin.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.veight.domain.Role;
import org.veight.admin.service.RoleService;
import org.veight.bean.Pager;
/**
 * Controller - 角色
 * 
 */
@Controller()
@RequestMapping("/admin/role")
public class RoleController extends ABaseController{
	@Resource
	private RoleService roleService;
	//角色显示页
	@RequestMapping("/list.xhtml")
	public String list() {
		return "/admin/role/role_list";
	}
	//角色列表内容
	@RequestMapping("/list.json")
	@ResponseBody
	public Map<String,Object> listJSON(int page,int rows){
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		Pager pager = new Pager();
		pager.setPageNumber(page);
		pager.setPageSize(rows);
		
		pager = roleService.findByPager(pager);
		jsonMap.put("total", pager.getTotalCount().toString());//total键 存放总记录数，必须的 
		//需要级联获取 先获取一下
		ArrayList<Role> al =new ArrayList<Role>();
		for(Object temp:pager.getList()){
			Role role= (Role)temp;
			al.add(role);
		}
		jsonMap.put("rows", al);
		return jsonMap;
	}
	/**
	 * 添加
	 */
	@RequestMapping(value = "/add.xhtml")
	public String add() {
		return "/admin/role/role_add";
	}
	/**
	 * 保存
	 */
	@RequestMapping(value = "/save.action", method = RequestMethod.POST)
	public String save(Role role, RedirectAttributes redirectAttributes) {
		role.setIsSystem(false);
		role.setAdmins(null);
		roleService.save(role);
		return "/admin/role/role_list";
	}
	//删除
	@RequestMapping(value = "/delete.action")
	@ResponseBody
	public Map<String, Object> delete(String[] ids,ModelMap model) {
		if (ids != null) {
			for (String id : ids) {
				Role role = roleService.get(id);
				if (role != null && (role.getIsSystem() || (role.getAdmins() != null && !role.getAdmins().isEmpty()))) {
					return ajaxJsonSuccessMessage("删除失败"+role.getName()+"是系统角色,或是该角色下存在管理员");
				}
			}
			roleService.delete(ids);
		}
		return ajaxJsonSuccessMessage("删除成功");
	}
}
