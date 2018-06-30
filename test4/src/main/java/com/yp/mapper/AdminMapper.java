package com.yp.mapper;

 
import java.util.List;
import com.yp.pojo.Admin;

public interface AdminMapper {
public List<Admin> selectAllAdmin(); //未实现
public int insertAdmin(Admin admin);//添加管理员
public Admin selectOneAdmin(int id);//选择管理员
}
