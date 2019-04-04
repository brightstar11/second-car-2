package com.xh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.xh.entity.AdminMenu;
import com.xh.mapper.AdminMenuMapper;
import com.xh.service.AdminMenuService;

@Service
public class AdminMenuServiceImpl implements AdminMenuService{
	@Autowired
	private AdminMenuMapper menuMapper;
	@Override
	public List<AdminMenu> findMenu1ByUserId(String adminId) {
		List<AdminMenu> list= menuMapper.findMenu1ByUserId(adminId);
		
		for (AdminMenu menu : list) {
			System.out.println(menu.getId());
			menu.setMenus(menuMapper.findMenu2ByMenuId(adminId, menu.getId()));
		}
		System.out.println(list.size()+"admin");
		return list;
	}
	
}
