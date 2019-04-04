package com.xh.entity;

public class UserLogin {
private Integer userid;
private String username;
@Override
public String toString() {
	return "UserLogin [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + "]";
}
private String userpwd;
public Integer getUserid() {
	return userid;
}
public void setUserid(Integer userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpwd() {
	return userpwd;
}
public void setUserpwd(String userpwd) {
	this.userpwd = userpwd;
}
}
