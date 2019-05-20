package com.xh.entity;



public class Car_Information {
 private Integer id;
 private String title;
 private String content;
 private String time;
 
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
@Override
public String toString() {
	return "Car_Information [id=" + id + ", title=" + title + ", content=" + content + "]";
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
 
}
