package com.yp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yp.mapper.RecommontMapper;
import com.yp.pojo.Recommont;
import com.yp.service.RecommontService;

public class RecommontServiceImpl implements RecommontService{
@Autowired
private RecommontMapper recommontMapper;
	public boolean insertCommont(Recommont recommont) {
		// TODO Auto-generated method stub
		return recommontMapper.insertCommont(recommont);
	}

	public Recommont selectCommontByCoId(int id) {
		// TODO Auto-generated method stub
		return recommontMapper.selectCommontByCoId(id);
	}

	public List<Recommont> selectAllByCoId(int id) {
		// TODO Auto-generated method stub
		return recommontMapper.selectAllByCoId(id);
	}

	public List<Recommont> selectAllRecom() {
		// TODO Auto-generated method stub
		return recommontMapper.selectAllRecom();
	}

}
