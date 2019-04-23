package com.xh.service;

import java.util.List;



import com.xh.entity.Admin;
import com.xh.entity.UserInfo;


public interface AdminService {
	//登录判断
	
		public List<Admin> adminquery(Admin admin);
		//注册
		 public Integer  adminregister(Admin admin);
		 //用户名重复判断
		 public List<Admin>  adminnameonly();
		 //修改个人信息
		 public Integer  adminupdate(Admin admin);
		 //注册用户管理
		 public List<UserInfo> usermanage();
		 
		 public List<UserInfo> SerarchUsermanage(String username);
		 
		 public List<UserInfo> usermanage2(Integer id);
		 
		  //删除用户------------------------------------------------------------------------
		   
		   public Integer usermanagedelect1(String username); 
		   public Integer usermanagedelect2(String username); 
		   //----------------------------------------------------------------------------
		   //管理员查找显示在管理员页
		   public List<Admin> adminSeletAll(String adminPermission);
		   
		   public List<Admin> searchAdminName(Admin admin);
		   
		 //查找单一管理员信息
		   public List<Admin> adminSeletOne(Integer adminId);
		   
		   public List<Admin> adminSeletOne2(String adminName);
		   
		   //修改管理员信息
		   public Integer adminUpdate(Admin admin);
		   //删除管理员信息
		   public Integer adminmanagedelect(String adminName);
		   //添加管理员
		   public Integer adminmanageAdd(Admin admin);
}
