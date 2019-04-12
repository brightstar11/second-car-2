package com.xh.web.controller;

import java.util.List;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.xh.common.GlobalConstant;
import com.xh.common.MD5Util;
import com.xh.common.ResultUtil;
import com.xh.common.anno.Permission;
import com.xh.entity.Admin;
import com.xh.entity.AdminMenu;
import com.xh.entity.UserInfo;
import com.xh.entity.UserLogin;
import com.xh.service.AdminMenuService;
import com.xh.service.AdminService;
import com.xh.service.UserInfoService;
import com.xh.service.User_LoginService;
import com.xh.web.model.PageModel;



@Controller
@RequestMapping("WebCar/admin")
public class AdminController {
@Autowired
private AdminService adminService;
@Autowired
private AdminMenuService ad;
@Autowired
private UserInfoService user;
@Autowired
private User_LoginService User_LoginService;
/**
 * 加载登录页
 */
@RequestMapping("/adminlogin")
public String index() {
	 return "adminlogin";
}
//返回首页--------------------------------------------------------------------
@RequestMapping("/returnindex")
public String index2() {
	return "index";
}
//登录------------------------------------------------------------------------------
@RequestMapping("/doLogin")
@Permission(checkLogin=false)
public String userinfoQuery(Admin admin,HttpSession session,Model model) {
	   //System.out.println(admin.getAdminName()+""+admin.getAdminPwd());
	   //把密码进行MD5加密装换
	   String userpwd=MD5Util.MD5(admin.getAdminPwd());
	   admin.setAdminPwd(userpwd);
	   List<Admin> list=adminService.adminquery(admin);
	   if(list==null||list.size()==0) {
		   model.addAttribute(GlobalConstant.ERROR_KEY, ResultUtil.error("登录失败!"));
			return "adminlogin";
	   }
		Admin admin2 = list.get(0);
		System.out.println(admin2.getAdminPermission());
		if (admin2.getAdminPermission().equals("2")) {
			
			// 登录成功,查询用户的菜单列表
			List<AdminMenu> menus = ad.findMenu1ByUserId(admin2.getAdminPermission());
			//System.out.println(menus.size());
			admin2.setAdminMenus(menus);
			//System.out.println(admin2.toString());
		    session.setAttribute(GlobalConstant.LOGIN_KEY, admin2);
		return "index";
		}else if(admin2.getAdminPermission().equals("1")) {
			// 登录成功,查询用户的菜单列表
						List<AdminMenu> menus = ad.findMenu1ByUserId(admin2.getAdminPermission()+"");
						admin2.setAdminMenus(menus);
					    session.setAttribute(GlobalConstant.LOGIN_KEY, admin2);
					    return "index";
		}
		return "adminlogin";
		
	
}
//注册用户管理
@RequestMapping("/usermanage")
  public String usermanage(HttpSession session,String pageNum,Model model) {
	List<UserInfo> list=adminService.usermanage();
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		try {
			num=Integer.parseInt(pageNum);
		} catch (Exception e) {
			num=1;
		}
		pm.setPageNum(num);
		pm.setPageNum(num);
		
		PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x+1)+"到"+(y+1)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	     model.addAttribute("list",list);
	return "usermanage";
	
}
//修改用户信息展示
@RequestMapping("/usermanageupdate")
public String usermanageupdate(Model model,Integer id) {
    List<UserInfo> list=adminService.usermanage2(id);
	UserInfo userInfo=(UserInfo)list.get(0);
	model.addAttribute("list",userInfo);
	return "usermanageupdate";
}
//修改用户信息
/*
 * 要同时修改用户信息和登录信息  加上事务回滚
 */
@Transactional
@RequestMapping("/usermanageupdate2")
public String usermanageupdate2(UserInfo userInfo) {
	System.out.println("进入修改");
	System.out.println(userInfo.toString());
		//修改用户信息
		String userpwd=MD5Util.MD5(userInfo.getUserpwd());
		userInfo.setUserpwd(userpwd);
		Integer index=user.userupdate(userInfo);
		//修改登录信息
		UserLogin userLogin=new UserLogin();
		userLogin.setUsername(userInfo.getUsername());
		userLogin.setUserpwd(userpwd);
		userLogin.setid(userInfo.getId());
		Integer index2=User_LoginService.userloginupdate(userLogin);
		
		if (index==index2) {
			return "usermanageupdatesuccess";
		}
		
	
	return "usermanageupdateerror";
	
}
//删除用户信息
/*
* 要同时修改用户信息和登录信息  加上事务回滚
*/
@Transactional
@RequestMapping("/usermanagedelect")
@ResponseBody
public Integer usermanagedelect(String username) {
	System.out.println("进入删除操作");
	System.out.println(username);
	
		//删除用户信息
		int count=adminService.usermanagedelect1(username);
		System.out.println(count);
		//删除登录信息
		int count2=adminService.usermanagedelect2(username);
		System.out.println(count2);
		
		if (count==1&&count2==1) {
			return 1;
		}
		
	
	return 0;
	
}
//注册-------------------------------------------------------------------------------
@RequestMapping("/usermanageAdd")
@ResponseBody
public Integer usermanageAdd(UserInfo userInfo) {
	   //判断用户名是否重复
	   List<UserInfo> list=user.usernameonly(userInfo.getUsername());
	 if(list.size()==0) {
		 System.out.println("用户名可以使用");
	  //把密码进行MD5转换
	 String userpwd=  userInfo.getUserpwd();
	 userInfo.setUserpwd(MD5Util.MD5(userpwd));
	 //调用sql 获取添加结果返回值
	 int count=user.userregister(userInfo);
	 
	 UserLogin userLogin=new UserLogin();
	 userLogin.setUsername(userInfo.getUsername());
	 userLogin.setUserpwd(userInfo.getUserpwd());
	 
	 int count2=User_LoginService.userloginregister(userLogin);
	 System.out.println(count);
	 if(count==count2&&count==1) {
		 return 1;
	 }
		 return 0;
	}
	else {
		return 2;
	}
	   
}


}



