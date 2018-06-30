package com.yp.mapper;

import java.util.List;

import com.yp.pojo.Role;

public interface RoleMapper {
	public boolean save(Role role);//
	public boolean update(Role role);//
	public Role find(String userid);//я╟ур╫ги╚
	public List<Role> findAll(String userid);//
	public List<Role> findByName(String userid);//
	public boolean delete(String id);//
 }
