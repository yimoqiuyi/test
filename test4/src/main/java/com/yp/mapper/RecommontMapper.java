package com.yp.mapper;

import java.util.List;

import com.yp.pojo.Recommont;

public interface RecommontMapper {
	public boolean insertCommont(Recommont recommont);//添加评论
	public Recommont selectCommontByCoId(int id);//通过一级Id得到二级评论
	public List<Recommont> selectAllByCoId(int id);//通过一级Id获得所有二级评论
	public List<Recommont>  selectAllRecom();  //获取所有的二级回复
}
