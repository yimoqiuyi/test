package com.yp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yp.mapper.CommontMapper;
import com.yp.pojo.Commont;
import com.yp.service.CommontService;

public class CommontServiceImpl implements CommontService{
@Autowired
private CommontMapper commontMapper;
	public boolean insertCommont(Commont commont) {
		// TODO Auto-generated method stub
		return commontMapper.insertCommont(commont);
	}

  	public List<Commont> selectAllByMeId(int id) {
		// TODO Auto-generated method stub
		return commontMapper.selectAllByMeId(id);
	}

	public Commont selectComByMesId(int id) {
		// TODO Auto-generated method stub
		return commontMapper.selectComByMesId(id);// 通过文章id获取评论
	}

	public Commont selectOneComont(int id) {
		// TODO Auto-generated method stub
		return commontMapper.selectOneComont(id);
	}

}
