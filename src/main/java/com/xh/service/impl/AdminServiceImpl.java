package com.xh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xh.entity.Admin;
import com.xh.entity.UserInfo;
import com.xh.mapper.AdminMapper;
import com.xh.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
 @Autowired
 private AdminMapper admindao;
	@Override
	public List<Admin> adminquery(Admin admin) {
		admindao.adminquery(admin);
		return admindao.adminquery(admin);
	}

	@Override
	public Integer adminregister(Admin admin) {
		admindao.adminregister(admin);
		return admindao.adminregister(admin);
	}

	@Override
	public List<Admin> adminnameonly() {
		admindao.adminnameonly();
		return admindao.adminnameonly();
	}

	@Override
	public Integer adminupdate(Admin admin) {
		admindao.adminupdate(admin);
		return admindao.adminupdate(admin);
	}

	@Override
	public List<UserInfo> usermanage() {
		admindao.usermanage();
		return admindao.usermanage();
	}
	@Override
	public List<UserInfo> usermanage2(String id) {
		admindao.usermanage2(id);
		return admindao.usermanage2(id);
	}
}
