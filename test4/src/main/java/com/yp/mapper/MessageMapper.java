package com.yp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yp.pojo.Commont;
import com.yp.pojo.Message;

public interface MessageMapper {
public boolean insertMessage(@Param("param") Message message,@Param("Id") int id); //
public int deleteMessage(int id);//
public boolean updateMessage(@Param("param") Message message,@Param("id") int id); //
public Message selectOneMessage(int id); //ѡ��ƪ����
public List<Message> selectAllMessage();  //ѡ����������
public List selectAllMessageByUserId(int id);//�����û�ѡ����������
public List selectMessageByTypeId(int id);//��������ѡ����������
public List selectMessageByname(String findByName);//������������ѡ������
public List selectMessageByState(String state);//��������״̬ѡ������
public List selectOneMessageByState(@Param("userid") int userid,@Param("state" )String state);//�����û�����������ѡ������
public Message selectMesByCmId(int id);//ͨ������id��ȡ����
}
