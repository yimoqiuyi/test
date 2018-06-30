package com.yp.pojo;
import java.io.Serializable;
 public class Role implements Serializable{
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	private static final long serialVersionUID = 6219549870810185457L;
    
    private String id;
    private String userid;
    private String roleName;
     
}
