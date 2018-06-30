package com.yp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yp.pojo.User;

public interface UserMapper {
public  boolean addUser(User user); //����û�
public  int delectUser(int id);     //ɾ���û�
public boolean  updateUser(@Param("user")User user,@Param("id") int id) ;//����yoghurt
public List<User> selectAllUser(); //ѡ�����е��û�
public User selectUserById(int id); //ͬ��idѡ���û�
public User find(String name); //ͨ������ѡ���û�
 
  }
