package com.xh.entity;

public class UserInfo {
    private Integer id;
    private String username;
    private String userrealname;
    public String getUserrealname() {
		return userrealname;
	}
	public void setUserrealname(String userrealname) {
		this.userrealname = userrealname;
	}
	private String usericon;
    public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	private String userphone;
    private String useraddress;
    private String usersex;
    @Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", usericon=" + usericon + ", userphone=" + userphone
				+ ", useraddress=" + useraddress + ", usersex=" + usersex + ", userpwd=" + userpwd + ", useremail="
				+ useremail + "]";
	}
	private String userpwd;
    private String useremail;
    public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsericon() {
		return usericon;
	}
	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	
}