package com.xh.service;

import java.util.List;



import com.xh.entity.UserInfo;

public interface UserInfoService {

	//注册
	 public Integer userregister(UserInfo userInfo);
	 //用户名重复判断
	 public List<UserInfo> usernameonly(String usename);
	 //修改个人信息
	 public Integer userupdate(UserInfo userInfo);
	 //密码找回
	 public List<UserInfo> pwdback(UserInfo userInfo);
	 public Integer userpwdupdate(UserInfo userInfo);
	 //判断是否存在该用户
	
	 public Integer userinfohave(String username,String userpwd);
	 //修改密码
	 public Integer userinfoupup1(String userpwd,String username);
	 public Integer userinfoupup2(String userpwd,String username);
	 public List<UserInfo> selectuserinfo(String username);
}
