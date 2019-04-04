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
		 public List<UserInfo> usermanage2(String id);
}
