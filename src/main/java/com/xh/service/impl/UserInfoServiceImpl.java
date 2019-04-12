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
	public Integer userregister(UserInfo userInfo) {
		
		return UserInfo.userregister(userInfo);
	}
	@Override
	public List<UserInfo> usernameonly(String username) {
		
		return UserInfo.usernameonly(username);
	}
	@Override
	public Integer userupdate(UserInfo userInfo) {
		
		return UserInfo.userupdate(userInfo);
	}
	@Override
	public List<com.xh.entity.UserInfo> pwdback(UserInfo userInfo) {
		
		return UserInfo.pwdback(userInfo);
	}
	@Override
	public Integer userpwdupdate(com.xh.entity.UserInfo userInfo) {
		
		return UserInfo.userpwdupdate(userInfo);
	}

}
