package com.yp.mapper;

import java.util.List;

import com.yp.pojo.Commont;

public interface CommontMapper {
public boolean insertCommont(Commont commont);//�������
 public List<Commont> selectAllByMeId(int id);//ͨ������id�������һ������
public Commont selectComByMesId(int id);//ͨ������id��ȡһ��
public Commont selectOneComont(int id);//ͨ��id��ȡ����
}
