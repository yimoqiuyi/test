package com.yp.mapper;

import java.util.List;

import com.yp.pojo.Type;

public interface TypeMapper {
public List<Type> selectAllType();  //选择所有类型
public int insertType(Type type);// 添加类型
public int deleteType(int id);//  删除类型
public Type selectTypeByMessageId(int id);//根据文章id选择类型 
}
