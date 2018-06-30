package com.yp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.yp.pojo.User;

public interface UserService {
	public  boolean insertUser(User user, MultipartFile file); 
	public  int delectUser(int id);    
	public boolean updateUser(User user,int id); 
	public List<User> selectAllUser();
	public User selectUserById(int id);
	public  boolean addUser(User user,MultipartFile file);
	public User find(String name);
	 
 }
