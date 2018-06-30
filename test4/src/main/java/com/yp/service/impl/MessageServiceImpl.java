package com.yp.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.yp.mapper.MessageMapper;
import com.yp.pojo.Message;
import com.yp.service.MessageService;

public class MessageServiceImpl implements MessageService{
@Autowired MessageMapper messageMapper;
public boolean insertMessage(@Param("param") Message message,@Param("Id") int id) {
		 
		return messageMapper.insertMessage(message, id ) ;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return messageMapper.deleteMessage(id);
	}

	public boolean updateMessage(@Param("param") Message message,@Param("id") int id) {
		// TODO Auto-generated method stub
		return messageMapper.updateMessage(message,id);
	}

	public Message selectOneMessage(int id) {
		// TODO Auto-generated method stub
		return messageMapper.selectOneMessage(id);
	}

	public List<Message> selectAllMessage() {
		 
		return messageMapper.selectAllMessage();
	}

	public List selectAllMessageByUserId(int id) {
		// TODO Auto-generated method stub
		return messageMapper.selectAllMessageByUserId(id);
	}

	public List selectMessageByTypeId(int id) {
		// TODO Auto-generated method stub
		return messageMapper.selectMessageByTypeId(id);
	}

	public List selectMessageByname(String title) {
		// TODO Auto-generated method stub
		return messageMapper.selectMessageByname(title);
	}

	public List selectMessageByState(String state) {
		// TODO Auto-generated method stub
		return messageMapper.selectMessageByState(state);
	}

	public List selectOneMessageByState(int userid, String state) {
		// TODO Auto-generated method stub
		return messageMapper.selectOneMessageByState(userid, state);
	}

	public Message selectMesByCmId(int id) {
		// TODO Auto-generated method stub
		return messageMapper.selectMesByCmId(id);
	}

}
