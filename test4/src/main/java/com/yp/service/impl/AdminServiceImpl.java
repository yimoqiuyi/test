package com.yp.service.impl;
    
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.yp.mapper.AdminMapper;
import com.yp.pojo.Admin;
import com.yp.service.AdminService;
public class AdminServiceImpl implements AdminService{
@Autowired
private AdminMapper adminMapper;
	 
	public List<Admin> selectAllAdmin() {
		// TODO Auto-generated method stub
		return adminMapper.selectAllAdmin();
	}

	public int insertAdmin(Admin admin, MultipartFile file) {
		 String fileName=file.getOriginalFilename();
		 String path="${pageContext.request.contextPath}/picture/";
		 String filePath=path+fileName;
		  File saveFile = new File(filePath);
          try {
               file.transferTo(saveFile); //保存文件
               admin.setPicture(filePath);
          } catch (IOException e) {
              e.printStackTrace();
          }
 		return adminMapper.insertAdmin(admin);
	}

	public Admin selectOneAdmin(int id) {
		// TODO Auto-generated method stub
		return adminMapper.selectOneAdmin(id);
	}
 
}
