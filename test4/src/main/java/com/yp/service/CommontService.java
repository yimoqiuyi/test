package com.yp.service;

import java.util.List;

import com.yp.pojo.Commont;

public interface CommontService {
	public boolean insertCommont(Commont commont);//�������
 	public List<Commont> selectAllByMeId(int id);//ͨ������id�������һ������
	public Commont selectComByMesId(int id);
	public Commont selectOneComont(int id);//ͨ��id��ȡ����
}
