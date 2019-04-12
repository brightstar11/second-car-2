package com.xh.entity;

import java.io.Serializable;
import java.util.List;

public class Admin implements Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String adminId;
  private String adminName;
  private String adminPwd;
  private String adminPhone;
  private String adminPermission;
  /**
	 * 用户的菜单集合
	 */
  private  List<AdminMenu> adminMenus;
	

  public List<AdminMenu> getAdminMenus() {
	return adminMenus;
}
public void setAdminMenus(List<AdminMenu> adminMenus) {
	this.adminMenus = adminMenus;
}

@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPwd=" + adminPwd + ", adminPhone="
			+ adminPhone + ", adminPermission=" + adminPermission + "]";
}
public String getAdminId() {
	return adminId;
}
public void setAdminId(String adminId) {
	this.adminId = adminId;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getAdminPwd() {
	return adminPwd;
}
public void setAdminPwd(String adminPwd) {
	this.adminPwd = adminPwd;
}
public String getAdminPhone() {
	return adminPhone;
}
public void setAdminPhone(String adminPhone) {
	this.adminPhone = adminPhone;
}
public String getAdminPermission() {
	return adminPermission;
}
public void setAdminPermission(String adminPermission) {
	this.adminPermission = adminPermission;
}

}
