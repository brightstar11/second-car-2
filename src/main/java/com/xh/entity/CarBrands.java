package com.xh.entity;

public class CarBrands {
 private Integer carbrandid;
 private String brandname;
 
@Override
public String toString() {
	return "CarBrands [carbrandid=" + carbrandid + ", brandname=" + brandname + "]";
}
public Integer getCarbrandid() {
	return carbrandid;
}
public void setCarbrandid(Integer carbrandid) {
	this.carbrandid = carbrandid;
}
public String getBrandname() {
	return brandname;
}
public void setBrandname(String brandname) {
	this.brandname = brandname;
}
 
}
