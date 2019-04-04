package com.xh.service;

import java.util.List;

import com.xh.entity.UserInfo;

public interface UserInfoService {

	//注册
	 public Integer userinforegister(UserInfo userInfo);
	 //用户名重复判断
	 public List<UserInfo> usernameonly();
	 //修改个人信息
	 public Integer userupdate(UserInfo userInfo);
	 //密码找回
	 public List<UserInfo> pwdback(UserInfo userInfo);
	 public Integer userpwdupdate(UserInfo userInfo);
}
