package com.yp.pojo;

import java.util.List;

public class Message {
private int id;  
private String context;  
private String title; 
private String state; 
 private int  typeId; 
 private List<Type> typelist; 
 private String  note;
 private List<Commont> comList;//一个文章对应多个一级
 public String getState() {
	return state;
}
public List<Commont> getComList() {
	return comList;
}
public void setComList(List<Commont> comList) {
	this.comList = comList;
}
public void setState(String state) {
	this.state = state;
}
  public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
public int getTypeId() {
	return typeId;
}
public void setTypeId(int typeId) {
	this.typeId = typeId;
}
public List<Type> getTypelist() {
	return typelist;
}
public void setTypelist(List<Type> typelist) {
	this.typelist = typelist;
}
  
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getContext() {
	return context;
}
public void setContext(String context) {
	this.context = context;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
 
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
private String date;  
}
