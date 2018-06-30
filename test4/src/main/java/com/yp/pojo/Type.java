package com.yp.pojo;

import java.util.List;

public class Type {
private int id; //类型ID
private int messageId;
private List<Message> messagelist;//文章列表
public int getMessageId() {
	return messageId;
}
public List<Message> getMessagelist() {
	return messagelist;
}
public void setMessagelist(List<Message> messagelist) {
	this.messagelist = messagelist;
}
public void setMessageId(int messageId) {
	this.messageId = messageId;
}
private String typeName; //类型名字
private String note;  //类型介绍
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTypeName() {
	return typeName;
}
public void setTypeName(String typeName) {
	this.typeName = typeName;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
}
