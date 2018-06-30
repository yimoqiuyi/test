package com.yp.mapper;

import java.util.List;

import com.yp.pojo.Commont;

public interface CommontMapper {
public boolean insertCommont(Commont commont);//添加评论
 public List<Commont> selectAllByMeId(int id);//通过文章id获得所有一级评论
public Commont selectComByMesId(int id);//通过文章id获取一级
public Commont selectOneComont(int id);//通过id获取评论
}
