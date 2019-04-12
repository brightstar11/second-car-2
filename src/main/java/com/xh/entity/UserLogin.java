package com.xh.entity;

public class UserLogin {
private Integer id;
private String username;
@Override
public String toString() {
	return "UserLogin [userid=" +id + ", username=" + username + ", userpwd=" + userpwd + "]";
}
private String userpwd;
public Integer getId() {
	return id;
}
public void setid(Integer id) {
	this.id = id;
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
