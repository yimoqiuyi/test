package com.yp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yp.mapper.FunctionMapper;
import com.yp.pojo.Function;
import com.yp.service.FunctionService;

public class FunctionServiceImpl  implements FunctionService{
@Autowired
private FunctionMapper functionMapper;
	public boolean save(Function function) {
		// TODO Auto-generated method stub
		return functionMapper.save(function);
	}

	public boolean update(Function function) {
		// TODO Auto-generated method stub
		return functionMapper.update(function);
	}

	public Function find(String userid) {
		// TODO Auto-generated method stub
		return functionMapper.find(userid);
	}

	public List<Function> findAll(String userid) {
		// TODO Auto-generated method stub
		return functionMapper.findAll(userid);
	}

	public List<Function> findByName(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	 

}
