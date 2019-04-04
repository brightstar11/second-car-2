package com.xh.entity;


import java.io.Serializable;
import java.util.List;

public class AdminMenu implements Serializable {
	@Override
	public String toString() {
		return "AdminMenu [id=" + id + ", menuName=" + menuName + ", menuUrl=" + menuUrl + ", menuIcon=" + menuIcon
				+ ", parentId=" + parentId + ", menus=" + menus + "]";
	}
	private static final long serialVersionUID = 2229386173863363976L;
	/**
	 * 菜单id
	 */
	private String id;
	/**
	 * 菜单名
	 */
	private String menuName;
	/**
	 * 菜单url
	 */
	private String menuUrl;
	/**
	 * 菜单图标
	 */
	private String menuIcon;
	/**
	 * 父id
	 */
	private String parentId;
	/**
	 *二级菜单集合 
	 */
	private List<AdminMenu> menus;
	
	public void setMenus(List<AdminMenu> menus) {
		this.menus = menus;
	}
	public List<AdminMenu> getMenus() {
		return menus;
	}
	
	
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentId() {
		return parentId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

}
