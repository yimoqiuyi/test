package com.yp.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.yp.mapper.UserMapper;
import com.yp.pojo.User;
import com.yp.service.UserService;

public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper;
 
public boolean addUser(User user,MultipartFile file) {
	 
	String name=file.getOriginalFilename();
	String path="${pageContext.request.contextPath}/picture/";
	 String filePath=path+name;
	 File saveFile = new File(filePath);
     try {
          file.transferTo(saveFile); 
          user.setId(user.getId());
          user.setPicture(name);
     } catch (IOException e) {
         e.printStackTrace();
     }
	return userMapper.addUser(user);
}

public int delectUser(int id) {
	// TODO Auto-generated method stub
	return userMapper.delectUser(id);
}

public boolean  updateUser(@Param("user")User user,@Param("id") int id) {
	// TODO Auto-generated method stub
 	return userMapper.updateUser(user,id);
}

public List<User> selectAllUser() {
	// TODO Auto-generated method stub
	return userMapper.selectAllUser();
}

public User selectUserById(int id) {
	// TODO Auto-generated method stub
	return userMapper.selectUserById(id);
}

public boolean insertUser(User user, MultipartFile file) {
	// TODO Auto-generated method stub
	return false;
}

public User find(String name) {
	// TODO Auto-generated method stub
	return userMapper.find(name);
}

 
 
  

 

}
