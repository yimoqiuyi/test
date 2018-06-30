package com.yp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yp.mapper.TypeMapper;
import com.yp.pojo.Type;
import com.yp.service.TypeService;

public class TypeServiceImpl implements TypeService {
@Autowired
private TypeMapper typeMapper;
	public List<Type> selectAllType() {
		// TODO Auto-generated method stub
		return typeMapper.selectAllType();
	}

	public int insertType(Type type) {
		 
		return typeMapper.insertType(type);
	}

	public int deleteType(int id) {
		// TODO Auto-generated method stub
		return typeMapper.deleteType(id);
	}

	public Type selectTypeByMessageId(int id) {
		// TODO Auto-generated method stub
		return typeMapper.selectTypeByMessageId(id);
	}

}
