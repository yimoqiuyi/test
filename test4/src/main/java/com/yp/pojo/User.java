package com.yp.pojo;

import java.util.List;

public class User {
private int id; 
private String name; 
private String password;
private  String picture; 
private String note;  
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String pasword) {
	this.password = pasword;
}
public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
public List<Message> getMessageList() {
	return MessageList;
}
public void setMessageList(List<Message> messageList) {
	MessageList = messageList;
}
private List<Message> MessageList;  
 }
