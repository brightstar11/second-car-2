package com.xh.web.model;
/*
 * 汽车编号  汽车品牌 汽车名称 处理人  处理人电话 处理状态
 */
public class Sellpeople_car {
 private Integer id ;
 private String brandname;
 private String carname;
 private String realname;
 private String adminphone;
 private String carvalidate;
 
@Override
public String toString() {
	return "Sellpeople_car [id=" + id + ", brandname=" + brandname + ", carname=" + carname + ", realname=" + realname
			+ ", adminphone=" + adminphone + ", carvalidate=" + carvalidate + "]";
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getBrandname() {
	return brandname;
}
public void setBrandname(String brandname) {
	this.brandname = brandname;
}
public String getCarname() {
	return carname;
}
public void setCarname(String carname) {
	this.carname = carname;
}
public String getRealname() {
	return realname;
}
public void setRealname(String realname) {
	this.realname = realname;
}
public String getAdminphone() {
	return adminphone;
}
public void setAdminphone(String adminphone) {
	this.adminphone = adminphone;
}
public String getCarvalidate() {
	return carvalidate;
}
public void setCarvalidate(String carvalidate) {
	this.carvalidate = carvalidate;
}
 
}
