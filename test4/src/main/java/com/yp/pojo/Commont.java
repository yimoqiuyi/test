package com.yp.pojo;

import java.util.List;

public class Commont {
private int id;
private String context;
private int commontid;
private int userid;
private int mesid;
public int getMesid() {
	return mesid;
}
public void setMesid(int mesid) {
	this.mesid = mesid;
}
private List<Recommont> recomList;
public int getUserid() {
	return userid;
}
public List<Recommont> getRecomList() {
	return recomList;
}
public void setRecomList(List<Recommont> recomList) {
	this.recomList = recomList;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getCommontid() {
	return commontid;
}
public void setCommontid(int commontid) {
	this.commontid = commontid;
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
 
}
