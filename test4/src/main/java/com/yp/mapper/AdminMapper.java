package com.yp.mapper;

 
import java.util.List;
import com.yp.pojo.Admin;

public interface AdminMapper {
public List<Admin> selectAllAdmin(); //δʵ��
public int insertAdmin(Admin admin);//��ӹ���Ա
public Admin selectOneAdmin(int id);//ѡ�����Ա
}
