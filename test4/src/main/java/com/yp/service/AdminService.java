package com.yp.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yp.pojo.Admin;
 
public interface AdminService {
public List<Admin> selectAllAdmin(); //閫夋嫨绠＄悊鍛�
public int insertAdmin(Admin admin, MultipartFile file);//娣诲姞绠＄悊鍛�
public Admin selectOneAdmin(int id);//
}
