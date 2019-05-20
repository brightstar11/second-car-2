package com.xh.web.model;

public class EvaluationModel {
  private String carband;
  private String carbirth;
  private String levelname;
  private String carlntime;
  private String carmileages;
  private String useremail;
public String getCarband() {
	return carband;
}
public void setCarband(String carband) {
	this.carband = carband;
}
public String getCarbirth() {
	return carbirth;
}
public void setCarbirth(String carbirth) {
	this.carbirth = carbirth;
}
public String getLevelname() {
	return levelname;
}
public void setLevelname(String levelname) {
	this.levelname = levelname;
}
public String getCarlntime() {
	return carlntime;
}
public void setCarlntime(String carlntime) {
	this.carlntime = carlntime;
}
public String getCarmileages() {
	return carmileages;
}
public void setCarmileages(String carmileages) {
	this.carmileages = carmileages;
}
public String getUseremail() {
	return useremail;
}
public void setUseremail(String useremail) {
	this.useremail = useremail;
}
@Override
public String toString() {
	return "EvaluationModel [carband=" + carband + ", carbirth=" + carbirth + ", levelname=" + levelname
			+ ", carlntime=" + carlntime + ", carmileages=" + carmileages + ", useremail=" + useremail + "]";
}
  
}
