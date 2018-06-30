package com.yp.service;

import java.util.List;

import com.yp.pojo.Role;

public interface RoleService {
	public boolean save(Role role);
	public boolean update(Role role);
	public Role find(String userid);
	public List<Role> findAll(String userid);
	public List<Role> findByName(String userid);
	public boolean delete(String id);
	 
}
