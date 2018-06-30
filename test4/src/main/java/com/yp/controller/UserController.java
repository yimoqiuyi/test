package com.yp.controller;
 
 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.yp.pojo.Admin;
import com.yp.pojo.User;
import com.yp.service.AdminService;
import com.yp.service.MessageService;
import com.yp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
private UserService  userService;
@Autowired
private AdminService adminService;
@Autowired
private MessageService messageService;
//���������Ϣ�����������֤
@RequestMapping(value="login2",method=RequestMethod.GET)   
public ModelAndView JudgeUser(ModelAndView mv,HttpServletRequest request) 
{  
   int id=Integer.parseInt(request.getParameter("id")) ; 
   User user=userService.selectUserById(id);
   if(user.getName().equals("admin"))
  	{   
   		
              Admin admin=new Admin();
   			  admin.setId(user.getId());
   			  admin.setName(user.getName());
  			  admin.setPassword(user.getPassword());
  			  admin.setPicture(user.getPicture());
  			  mv.addObject("adminId",user.getId());
  			     mv.addObject("admin",admin);
  			     mv.setViewName("admin/admin");
   		 }
   else 
	  if( user.getName()!=null)
     	{
//	 {
//		ArrayList<User> list=(ArrayList<User>) userService.selectAllUser();
// 	 Iterator<User> iterator = list.iterator();
//	 while(iterator.hasNext()) {		 
//	    User use =iterator.next();
//		 if(user.getName().equals(use.getName())&&(user.getPassword().equals(use.getPassword())))
//		 {
  		     mv.addObject("userid",id);
		     mv.addObject("user",user);
 			  mv.setViewName("message/return");
        }
	  else
	  {	  
		  mv.setViewName("error");
 	  }
		 
         	return mv;
}
 //��ʾ������Ϣ
 @RequestMapping("show")
 public ModelAndView showOne(HttpServletRequest request)
 {
	 String id=request.getParameter("id");
	 ModelAndView mv=new ModelAndView();
   	    int Id=Integer.parseInt(id);
 	 User user =userService.selectUserById(Id);
 	 mv.addObject("id",id);
 	mv.setViewName("user/showOneSelf"); 
 	 return mv.addObject("user",user);
 }
 
@RequestMapping(value="insert",method=RequestMethod.GET)  //����û�
public ModelAndView InsertUser(User user,@RequestParam(value="file",required=false) MultipartFile file)
{   
	System.out.println(("����û�"));
	ModelAndView mv=new ModelAndView();   	
 	if (userService.addUser(user, file))
	{     
		 ArrayList list=(ArrayList) userService.selectAllUser();
        user.setId(list.size());
		mv.addObject("user",user);
		System.out.println(user.getPicture());
	}
 	mv.setViewName("user/showOneSelf"); 
	return mv;
}
 
 //ע���û�
@RequestMapping(value="regist",method=RequestMethod.GET)
public ModelAndView Regist()
{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("user/regist");
	 return mv;
}
@RequestMapping("select") //select one user
public ModelAndView SelectUser(HttpServletRequest request)
{  
	
	ModelAndView mv=new ModelAndView();
	String id=request.getParameter("id");
	System.out.println(id);
	int Id=Integer.parseInt(id);
	User user=userService.selectUserById(Id);
	mv.addObject(user);
	mv.addObject("userid",id);
	mv.setViewName("user/updateOneSelf");
	return mv;
 }
//�����޸���Ϣ
@RequestMapping("main")
public ModelAndView showmain(User user,ModelAndView mv,@RequestParam(value="file",required=false) MultipartFile file,HttpServletRequest request)
{ 
	System.out.println("�޸ĸ�����Ϣ");
	int id=Integer.parseInt( request.getParameter("id"));
	System.out.println(id);
	 String name=file.getOriginalFilename();
	  String path="/test/picture/";
	  String filePath=path+name;
	  File saveFile = new File(filePath);
     try {
              file.transferTo(saveFile); //baocun wenjian
               } catch (IOException e) {
         e.printStackTrace();
          }
	User use=userService.selectUserById(id);
 	use.setName(user.getName());
	use.setNote(user.getNote());
	use.setPassword(user.getPassword());
	use.setPicture(name);
     if(userService.updateUser(use,id))
   {  
	    mv.addObject("userid",id);
        mv.setViewName("message/return");
    	return mv;
   }
     mv.setViewName("error");
	return mv;
}
//��ʾ��������Ϣ
@RequestMapping("showAlluser")
public ModelAndView getAlluser(ModelAndView mv,HttpServletRequest request)
{ 
	int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
	int pageSize=10;
	String adminid=request.getParameter("id");
	ArrayList list=(ArrayList) userService.selectAllUser();
	int total=list.size();
	if (total % pageSize != 0) {
		total++;
	} 
	if (pageNumber <= 0) {
		pageNumber = 1;
	 }
	if (pageNumber >= total) {
		pageNumber = total;
	 }
	PageHelper.startPage(pageNumber,pageSize);
	list=(ArrayList<User>) userService.selectAllUser();
	mv.addObject("pageNumber",pageNumber);
	mv.addObject("totalCount",total);
	mv.addObject("userlist",list);
	mv.addObject("adminId",adminid);
	mv.setViewName("admin/showAllUser");
	return mv;
 }
//��¼������shiro���н�ɫ�ж�
@RequestMapping("login")
public ModelAndView login(HttpServletRequest request,ModelAndView mv ){
 //��ǰSubject  
	System.out.println(request.getParameter("username"));
 
     Subject currentUser = SecurityUtils.getSubject();  
 //����token��shiro��realm
 UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("username"),request.getParameter("password"));  
 try {  
     /* 
      * �ڵ�����login������SecurityManager���յ�AuthenticationToken�������䷢�͸������õ�Realm 
      * ��ִ�б������֤��顣ÿ��Realm�����ڱ�Ҫʱ���ύ��AuthenticationTokens������Ӧ�� 
      * ���������¼ʧ���˻ᷢ��ʲô������û��ṩ�˴��������ֻᷢ��ʲô��ͨ����Shiro������ʱAuthenticationException������Ӧ 
      * ������Կ���ʧ�� 
      */  
	 User user=userService.find(request.getParameter("username"));
	 if(user==null)
	 {
		  request.setAttribute("msg", "��ƥ����û���������");  
	     mv.setViewName("error");
	 }else
	 {
	         user.setId(user.getId());
	        mv.addObject("id",user.getId());
             currentUser.login(token); 
         mv.setViewName("index");
	 }
  } catch (AuthenticationException e) {//��¼ʧ��  
     e.printStackTrace();  
      request.setAttribute("msg", "��ƥ����û���������");  
     mv.setViewName("error");
  }  
 return mv;
}
}
