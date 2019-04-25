package com.xh.entity;

public class CarOrder {
private Integer orderid;
private String  ordercarname;
private String ordercarhavename;
private String orderhavetel;
private String ordermoney;
private String ordername;
private String orderaddr;
private String ordertel;
private String orderbegintime;
private String orderendtime;
private String orderstaticid;
public Integer getOrderid() {
	return orderid;
}
public void setOrderid(Integer orderid) {
	this.orderid = orderid;
}
public String getOrdercarname() {
	return ordercarname;
}
public void setOrdercarname(String ordercarname) {
	this.ordercarname = ordercarname;
}
public String getOrdercarhavename() {
	return ordercarhavename;
}
public void setOrdercarhavename(String ordercarhavename) {
	this.ordercarhavename = ordercarhavename;
}
public String getOrderhavetel() {
	return orderhavetel;
}
public void setOrderhavetel(String orderhavetel) {
	this.orderhavetel = orderhavetel;
}
public String getOrdermoney() {
	return ordermoney;
}
public void setOrdermoney(String ordermoney) {
	this.ordermoney = ordermoney;
}
public String getOrdername() {
	return ordername;
}
public void setOrdername(String ordername) {
	this.ordername = ordername;
}
public String getOrderaddr() {
	return orderaddr;
}
public void setOrderaddr(String orderaddr) {
	this.orderaddr = orderaddr;
}
public String getOrdertel() {
	return ordertel;
}
public void setOrdertel(String ordertel) {
	this.ordertel = ordertel;
}
public String getOrderbegintime() {
	return orderbegintime;
}
public void setOrderbegintime(String orderbegintime) {
	this.orderbegintime = orderbegintime;
}
public String getOrderendtime() {
	return orderendtime;
}
public void setOrderendtime(String orderendtime) {
	this.orderendtime = orderendtime;
}
public String getOrderstaticid() {
	return orderstaticid;
}
public void setOrderstaticid(String orderstaticid) {
	this.orderstaticid = orderstaticid;
}
@Override
public String toString() {
	return "Order [orderid=" + orderid + ", ordercarname=" + ordercarname + ", ordercarhavename=" + ordercarhavename
			+ ", orderhavetel=" + orderhavetel + ", ordermoney=" + ordermoney + ", ordername=" + ordername
			+ ", orderaddr=" + orderaddr + ", ordertel=" + ordertel + ", orderbegintime=" + orderbegintime
			+ ", orderendtime=" + orderendtime + ", orderstaticid=" + orderstaticid + "]";
}



}
