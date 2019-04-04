package com.xh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xh.entity.UserInfo;

import com.xh.mapper.UserInfoMapper;
import com.xh.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{
@Autowired
UserInfoMapper UserInfo;
	
	@Override
	public Integer userinforegister(UserInfo userInfo) {
		UserInfo.userinforegister(userInfo);
		return UserInfo.userinforegister(userInfo);
	}
	@Override
	public List<UserInfo> usernameonly() {
		UserInfo.usernameonly();
		return UserInfo.usernameonly();
	}
	@Override
	public Integer userupdate(UserInfo userInfo) {
		UserInfo.userupdate(userInfo);
		return UserInfo.userupdate(userInfo);
	}
	@Override
	public List<com.xh.entity.UserInfo> pwdback(UserInfo userInfo) {
		UserInfo.pwdback(userInfo);
		return UserInfo.pwdback(userInfo);
	}
	@Override
	public Integer userpwdupdate(com.xh.entity.UserInfo userInfo) {
		UserInfo.userpwdupdate(userInfo);
		return UserInfo.userpwdupdate(userInfo);
	}

}
