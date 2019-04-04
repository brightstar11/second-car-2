package com.xh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.xh.entity.AdminMenu;



@Mapper
public interface AdminMenuMapper {
	/**
	 * 根据用户id查询用户一级菜单列表
	 * @param userId
	 * @return
	 */
	@Select("SELECT * FROM admin_menu WHERE id IN (SELECT menuid FROM admin_menu_r WHERE adminid=#{adminId}) AND parentid NOT IN (SELECT id FROM admin_menu)")
	public List<AdminMenu> findMenu1ByUserId(String adminId); 
	/**
	 * 根据1级菜单id查询二级菜单
	 * @param menuId
	 * @return
	 */
	@Select("SELECT * FROM admin_menu WHERE id IN (SELECT menuid FROM admin_menu_r WHERE adminid=#{adminId}) AND parentid=#{menuId}")
	public List<AdminMenu> findMenu2ByMenuId(@Param("adminId")String adminId,@Param("menuId")String menuId);
}
