package com.yp.mapper;

import java.util.List;

import com.yp.pojo.Type;

public interface TypeMapper {
public List<Type> selectAllType();  //ѡ����������
public int insertType(Type type);// �������
public int deleteType(int id);//  ɾ������
public Type selectTypeByMessageId(int id);//��������idѡ������ 
}
