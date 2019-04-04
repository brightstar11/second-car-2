package com.xh.service;

import java.util.List;

import com.xh.entity.UserLogin;

public interface User_LoginService {
	//用户登录判断
	public List<UserLogin> userloginquery(UserLogin userLogin);
	public Integer userloginregister(UserLogin userLogin);
	public Integer userloginupdate(UserLogin userLogin);
}
