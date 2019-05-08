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
	@Override
	public Integer userinfohave(String username, String userpwd) {
		// TODO Auto-generated method stub
		return UserInfo.userinfohave(username, userpwd);
	}
	@Override
	public Integer userinfoupup1(String userpwd, String username) {
		// TODO Auto-generated method stub
		return UserInfo.userinfoupup1(userpwd, username);
	}
	@Override
	public Integer userinfoupup2(String userpwd, String username) {
		// TODO Auto-generated method stub
		return UserInfo.userinfoupup2(userpwd, username);
	}
	@Override
	public List<com.xh.entity.UserInfo> selectuserinfo(String username) {
		// TODO Auto-generated method stub
		return UserInfo.selectuserinfo(username);
	}

}
