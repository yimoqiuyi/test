package com.yp.mapper;

import java.util.List;

import com.yp.pojo.Function;

public interface FunctionMapper {
	public boolean save(Function function);// 
	public boolean update(Function function);//
	public Function find(String userid);//¹¦ÄÜÑ¡Ôñ
	public List<Function> findAll(String userid);//
	public List<Function> findByName(String userid);//
	public boolean delete(String id);//
}
