package com.yp.mapper;

import java.util.List;

import com.yp.pojo.Recommont;

public interface RecommontMapper {
	public boolean insertCommont(Recommont recommont);//�������
	public Recommont selectCommontByCoId(int id);//ͨ��һ��Id�õ���������
	public List<Recommont> selectAllByCoId(int id);//ͨ��һ��Id������ж�������
	public List<Recommont>  selectAllRecom();  //��ȡ���еĶ����ظ�
}
