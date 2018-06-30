package com.yp.pojo;

import java.io.Serializable;
import java.util.List;

public class Function implements Serializable{
    private static final long serialVersionUID = -5672703215254288650L;
    
    
    private String id;
    private String userid;
    private String url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    
    
    
}
 
