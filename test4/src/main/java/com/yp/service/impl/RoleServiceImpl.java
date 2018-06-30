package com.yp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yp.mapper.RoleMapper;
import com.yp.pojo.Role;
import com.yp.service.RoleService;

public class RoleServiceImpl implements RoleService {
@Autowired
private RoleMapper roleMapper;
	public boolean save(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.save(role);
	}

	public boolean update(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.update(role);
	}

	public Role find(String userid) {
		// TODO Auto-generated method stub
		return roleMapper.find(userid);
	}

	public List<Role> findAll(String userid) {
		// TODO Auto-generated method stub
		return roleMapper.findAll(userid);
	}

	public List<Role> findByName(String userid) {
		// TODO Auto-generated method stub
		return roleMapper.findByName(userid);
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return roleMapper.delete(id);
	}

 

 

}
