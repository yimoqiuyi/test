package com.yp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yp.pojo.User;

public interface UserMapper {
public  boolean addUser(User user); //添加用户
public  int delectUser(int id);     //删除用户
public boolean  updateUser(@Param("user")User user,@Param("id") int id) ;//跟新yoghurt
public List<User> selectAllUser(); //选择所有的用户
public User selectUserById(int id); //同过id选择用户
public User find(String name); //通过名字选择用户
 
  }
