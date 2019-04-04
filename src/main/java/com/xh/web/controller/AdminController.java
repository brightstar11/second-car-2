package com.xh.web.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.PageInfo;
import com.xh.common.GlobalConstant;
import com.xh.common.MD5Util;
import com.xh.common.ResultUtil;
import com.xh.common.anno.Permission;
import com.xh.entity.Admin;
import com.xh.entity.AdminMenu;
import com.xh.entity.UserInfo;
import com.xh.service.AdminMenuService;
import com.xh.service.AdminService;
import com.xh.web.model.PageModel;



@Controller
@RequestMapping("WebCar/admin")
public class AdminController {
@Autowired
private AdminService adminService;
@Autowired
private AdminMenuService ad;
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
	   System.out.println(admin.getAdminName()+""+admin.getAdminPwd());
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
			System.out.println(menus.size());
			admin2.setAdminMenus(menus);
			System.out.println(admin2.toString());
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
@RequestMapping(value="/usermanageupdate/{id}")
public String usermanageupdate(Model model,@PathVariable("id") String id) {
	
	List<UserInfo> list=adminService.usermanage2("1");
	UserInfo userInfo=(UserInfo)list.get(0);
	model.addAttribute("list",userInfo);
	return "usermanageupdate";
	
}
//注册-------------------------------------------------------------------------------
//@RequestMapping("/register")
//public String userRegister(UserInfo userInfo) {
//	   //判断用户名是否重复
//	   List<UserInfo> list=userInfoService.usernameonly();
//	 for(int i=0;i<list.size();i++) {
//		 UserInfo userInfo2=(UserInfo)list.get(i);
//		 if(userInfo2.getUsername().equals(userInfo.getUsername())) {
//			 System.out.println("用户名重复");
//		 }else {
//			System.out.println("用户名可以使用");
//		}
//	 }
//	   //把密码进行MD5转换
//	 String userpwd=  userInfo.getUserpwd();
//	 userInfo.setUserpwd(MD5Util.MD5(userpwd));
//	 //调用sql 获取添加结果返回值
//	 int count=userInfoService.userinforegister(userInfo);
//	 System.out.println(count);
//	 if(count==1) {
//		 return "添加成功界面";
//	 }else {
//		 return "添加失败界面";
//	}
//	
//	   
//}
//修改个人信息-----------------------------------------------------------------------
//@RequestMapping("/modifyInformation")
//public String modifyInformation(UserInfo userInfo){
//	   //把密码进行MD5转换
//		 String userpwd=  userInfo.getUserpwd();
//		 userInfo.setUserpwd(MD5Util.MD5(userpwd));
//		 //sql 修改个人信息 包括  密码 昵称 头像
//		 int count=userInfoService.userupdate(userInfo);
//		 //判断是否修改成功
//		 if (count==1) {
//			return "修改成功";
//		}else {
//			return "修改失败";
//		}
//}

}