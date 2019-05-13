package com.xh.web.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xh.common.MD5Util;
import com.xh.entity.Admin;
import com.xh.entity.UserInfo;
import com.xh.service.AdminService;
import com.xh.web.model.PageModel;



@Controller
@RequestMapping("WebCar/admin")
public class Admin_AdminManagerController {
	@Autowired
	private AdminService adminService;
	
	//页面跳转
	@RequestMapping("/adminmanageupdatesuccess")
	public String Index() {
		return "adminmanageupdatesuccess";
	}
	@RequestMapping("/adminmanageupdateerror")
	public String Index2() {
		return "adminmanageupdateerror";
	}
	
	
	
	//管理员管理
	@RequestMapping("/adminmanage")
	  public String usermanage(Integer pageNum,Model model) {
		
		
		//分页
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	    PageHelper.startPage(num, 5, true);
	    List<Admin> list=adminService.adminSeletAll("1");
		
			
			PageInfo pageinfo = new PageInfo(list);
			int x = pageinfo.getStartRow();
			int y = pageinfo.getEndRow();
			long z = pageinfo.getTotal();
			String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
			model.addAttribute("pageInfo",pageinfo);
			model.addAttribute("info",info);
		     model.addAttribute("list",list);
		return "adminmanage";
	}
	//管理员管理
		@RequestMapping("/searchAdminName")
		  public String searchAdminName(Integer pageNum,Model model,@RequestParam("name") String name) {
			Admin admin=new Admin();
			admin.setAdminName(name);
			admin.setAdminPermission("1");
			
			//分页
			 PageModel pm = new PageModel();
				Integer num = 1;
				if(pageNum != null && pageNum >= 0) {
					num = pageNum;
				}
				pm.setPageNum(num);
		    PageHelper.startPage(num, 5, true);
		    List<Admin> list=adminService.searchAdminName(admin);
			
				
				PageInfo pageinfo = new PageInfo(list);
				int x = pageinfo.getStartRow();
				int y = pageinfo.getEndRow();
				long z = pageinfo.getTotal();
				String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
				model.addAttribute("pageInfo",pageinfo);
				model.addAttribute("info",info);
			     model.addAttribute("list",list);
			return "adminmanage";
		}
	//修改管理员信息--------------------------------------------------------------------
	@RequestMapping("adminmanageupdate")
	public String adminmanageupdate(Integer adminId,Model model) {
		List<Admin> list=adminService.adminSeletOne(adminId);
		Admin admin=(Admin)list.get(0);
		model.addAttribute("list",admin);
		return "adminmanageupdate";
		
	}
	@Transactional
	@RequestMapping("/adminmanageupdate2")
	public String adminmanageupdate2(Admin admin) {
		System.out.println("进入修改");
		System.out.println(admin.toString());
			//修改管理员信息
			String userpwd=MD5Util.MD5(admin.getAdminPwd());
			admin.setAdminPwd(userpwd);
			Integer index=adminService.adminUpdate(admin);
			 System.out.println(index);
			
			if (index==1) {
				return "adminmanageupdatesuccess";
			}
			
		
		return "adminmanageupdateerror";
		
	}
	//删除管理员
	@RequestMapping("/adminmanagedelect")
	@ResponseBody
	public Integer adminmanagedelect(String adminName) {
		int count=adminService.adminmanagedelect(adminName);
		if(count==1) {
			return 1;
		}
		return 0;
		
	}
	//添加管理员
	@RequestMapping("/adminmanageAdd")
	@ResponseBody
	public Integer adminmanageAdd(Admin admin) {
		//判断名字唯一
		
		 String adminName=admin.getAdminName();
		 List<Admin> list=adminService.adminSeletOne2(adminName);
		 //list.size=1  表示存在该用户     
		 if(list.size()==0) {
			 System.out.println(admin.toString());
			 String userpwd=MD5Util.MD5(admin.getAdminPwd());
				admin.setAdminPwd(userpwd);
				int count=adminService.adminmanageAdd(admin);
				if(count==1) {
					return 1;
				}else {
					return 0;
				} 
		 }else {
			return 2;
		}
		
		
	}
	
}
