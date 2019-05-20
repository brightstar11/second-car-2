package com.xh.web.model;
/*
 * 订单编号 订单状态 处理人 处理人电话
 */
public class Sellpeople_Order {
 private Integer orderid;
 private String orderstatic;
 private String realname;
 private String adminphone;
 
@Override
public String toString() {
	return "Sellpeople_Order [orderid=" + orderid + ", orderstatic=" + orderstatic + ", realname=" + realname
			+ ", adminphone=" + adminphone + "]";
}
public Integer getOrderid() {
	return orderid;
}
public void setOrderid(Integer orderid) {
	this.orderid = orderid;
}
public String getOrderstatic() {
	return orderstatic;
}
public void setOrderstatic(String orderstatic) {
	this.orderstatic = orderstatic;
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
 
}
