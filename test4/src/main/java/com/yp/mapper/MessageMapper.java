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
public Message selectOneMessage(int id); //选择单篇文章
public List<Message> selectAllMessage();  //选择所有文章
public List selectAllMessageByUserId(int id);//根据用户选择所有文章
public List selectMessageByTypeId(int id);//根据类型选择所有文章
public List selectMessageByname(String findByName);//根据搜索名字选择文章
public List selectMessageByState(String state);//根据文章状态选择文章
public List selectOneMessageByState(@Param("userid") int userid,@Param("state" )String state);//根据用户与文章类型选择文章
public Message selectMesByCmId(int id);//通过评论id获取文章
}
