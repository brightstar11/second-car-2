package com.xh.web.model;

public class EvaluationModel {
  private String carband;
  private String carname;
  private String carlevel;
  private String carlntime;
  private String carmileages;
  private String useremail;
  private Integer carpassion;
  private Double carprice;
  private Integer count;
  
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public String getCarband() {
	return carband;
}
public void setCarband(String carband) {
	this.carband = carband;
}
public String getCarname() {
	return carname;
}
public void setCarname(String carname) {
	this.carname = carname;
}
public String getCarlevel() {
	return carlevel;
}
public void setCarlevel(String carlevel) {
	this.carlevel = carlevel;
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
public Integer getCarpassion() {
	return carpassion;
}
public void setCarpassion(Integer carpassion) {
	this.carpassion = carpassion;
}
public Double getCarprice() {
	return carprice;
}
public void setCarprice(Double carprice) {
	this.carprice = carprice;
}
@Override
public String toString() {
	return "EvaluationModel [carband=" + carband + ", carname=" + carname + ", carlevel=" + carlevel + ", carlntime="
			+ carlntime + ", carmileages=" + carmileages + ", useremail=" + useremail + ", carpassion=" + carpassion
			+ ", carprice=" + carprice + "]";
}
  
}