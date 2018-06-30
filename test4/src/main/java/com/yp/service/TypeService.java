package com.yp.service;

import java.util.List;

import com.yp.pojo.Type;

public interface TypeService {
	public List<Type> selectAllType();  //选择类型
	public int insertType(Type type);// 添加类型
	public int deleteType(int id);// 删除类型
	public Type selectTypeByMessageId(int id);
}
