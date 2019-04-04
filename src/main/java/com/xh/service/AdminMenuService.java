package com.xh.service;

import java.util.List;


import com.xh.entity.AdminMenu;


public interface AdminMenuService {
	
		/**
		 * 根据用户id查询用户1级菜单列表
		 * @param userId
		 * @return
		 */
		public List<AdminMenu> findMenu1ByUserId(String adminId);
		
}