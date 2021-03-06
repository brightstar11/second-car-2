package com.xh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xh.entity.Admin;
import com.xh.entity.Sellpeople_car;
import com.xh.entity.UserInfo;
import com.xh.mapper.AdminMapper;
import com.xh.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
 @Autowired
 private AdminMapper admindao;
	@Override
	public List<Admin> adminquery(Admin admin) {
		
		return admindao.adminquery(admin);
	}

	@Override
	public Integer adminregister(Admin admin) {
		
		return admindao.adminregister(admin);
	}

	@Override
	public List<Admin> adminnameonly() {
		
		return admindao.adminnameonly();
	}

	@Override
	public Integer adminupdate(Admin admin) {
		
		return admindao.adminupdate(admin);
	}

	@Override
	public List<UserInfo> usermanage() {
		
		return admindao.usermanage();
	}
	@Override
	public List<UserInfo> usermanage2(Integer id) {
		
		return admindao.usermanage2(id);
	}
	 //删除用户------------------------------------------------------------------------
	   
	 
	   
	@Override
	public Integer usermanagedelect1(String username) {
		
		return admindao.usermanagedelect1(username);
	}

	@Override
	public Integer usermanagedelect2(String username) {
		
		return admindao.usermanagedelect2(username);
	}
	//----------------------------------------------------------------------------
	//管理员查找显示在管理员页
	@Override
	public List<Admin> adminSeletAll(String adminPermission) {
		
		return admindao.adminSeletAll(adminPermission);
	}
//查找特定的管理员
	@Override
	public List<Admin> adminSeletOne(Integer adminId) {
		
		return admindao.adminSeletOne(adminId);
	}

	@Override
	public Integer adminUpdate(Admin admin) {
		
		return admindao.adminUpdate(admin);
	}

	@Override
	public Integer adminmanagedelect(String adminName) {
		
		return admindao.adminmanagedelect(adminName);
	}

	@Override
	public Integer adminmanageAdd(Admin admin) {
		
		return admindao.adminmanageAdd(admin);
	}

	@Override
	public List<Admin> adminSeletOne2(String adminName) {
		
		return admindao.adminSeletOne2(adminName);
	}

	@Override
	public List<UserInfo> SerarchUsermanage(String username) {
		
		return admindao.SerarchUsermanage(username);
	}

	@Override
	public List<Admin> searchAdminName(Admin admin) {
		
		return admindao.searchAdminName(admin);
	}

	@Override
	public List<Admin> adminquery_adminpermission4() {
		// TODO Auto-generated method stub
		return admindao.adminquery_adminpermission4();
	}

	@Override
	public Integer car_sellpeopleAdd(Sellpeople_car sellpeople_car) {
		// TODO Auto-generated method stub
		return admindao.car_sellpeopleAdd(sellpeople_car);
	}

	@Override
	public Integer adminmanagedelect2(String adminId) {
		// TODO Auto-generated method stub
		return admindao.adminmanagedelect2(adminId);
	}

	@Override
	public Integer adminmanageAdd2(Admin admin) {
		// TODO Auto-generated method stub
		return admindao.adminmanageAdd2(admin);
	}
}
