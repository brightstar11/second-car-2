package com.xh.entity;

public class Carlevel {
 private Integer levelid;
 private String levelname;
 
@Override
public String toString() {
	return "Carlevel [levelid=" + levelid + ", levelname=" + levelname + "]";
}
public Integer getLevelid() {
	return levelid;
}
public void setLevelid(Integer levelid) {
	this.levelid = levelid;
}
public String getLevelname() {
	return levelname;
}
public void setLevelname(String levelname) {
	this.levelname = levelname;
}
 
}
