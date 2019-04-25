package com.xh.entity;

public class SellCar {
private Integer id;
private Integer carid;
private Integer userinfoid;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getCarid() {
	return carid;
}
public void setCarid(Integer carid) {
	this.carid = carid;
}
public Integer getUserinfoid() {
	return userinfoid;
}
public void setUserinfoid(Integer userinfoid) {
	this.userinfoid = userinfoid;
}
@Override
public String toString() {
	return "SellCar [id=" + id + ", carid=" + carid + ", userinfoid=" + userinfoid + "]";
}

}
