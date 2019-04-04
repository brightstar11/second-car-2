package com.xh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xh.entity.UserLogin;
import com.xh.mapper.User_LoginMapper;
import com.xh.service.User_LoginService;
@Service
public class User_LoginServiceImpl implements User_LoginService{
	//用户登录判断
	@Autowired
	private User_LoginMapper User_LoginMapper;
	@Override
	public List<UserLogin> userloginquery(UserLogin userLogin) {
        User_LoginMapper.userloginquery(userLogin);

		return User_LoginMapper.userloginquery(userLogin);
	}
	@Override
	public Integer userloginregister(UserLogin userLogin) {
        User_LoginMapper.userloginregister(userLogin);
		return User_LoginMapper.userloginregister(userLogin);
	}
	@Override
	public Integer userloginupdate(UserLogin userLogin) {
		User_LoginMapper.userloginupdate(userLogin);
		return User_LoginMapper.userloginupdate(userLogin);
	}

}
