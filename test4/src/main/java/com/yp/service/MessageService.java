package com.yp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yp.pojo.Message;

public interface MessageService {
	public boolean insertMessage(@Param("param") Message message,@Param("Id") int id); 
	public int delete(int id);//鍒犻櫎鐣欒█
	public boolean updateMessage(Message message,int id); //淇敼鐣欒█
	public Message selectOneMessage(int id); //鏌ョ湅鐣欒█
	public List<Message> selectAllMessage();  //鏌ョ湅鎵�鏈夌暀瑷�
	public List selectAllMessageByUserId(int id);
	public List selectMessageByTypeId(int id);
	public List selectMessageByname(String messageName);
	public List selectMessageByState(String state);
	public List selectOneMessageByState(@Param("userid") int userid,@Param("state" )String state);
	public Message selectMesByCmId(int id);//ͨ������id��ȡ����
}
