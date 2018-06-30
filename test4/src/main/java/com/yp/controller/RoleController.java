package com.yp.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.yp.pojo.Message;
import com.yp.service.CommontService;
import com.yp.service.MessageService;
import com.yp.service.RecommontService;
import com.yp.pojo.Commont;
import  com.yp.pojo.Recommont ;
@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired 
	private MessageService messageService;
	@Autowired
	private CommontService commontService;
	@Autowired 
	private RecommontService recommontService;
@RequestMapping("message") //显示所有评审过的文章
public ModelAndView showMessage(ModelAndView mv,HttpServletRequest request,@RequestParam(value="pageNumber",required=false) Integer pageNumber)
 {
	if(pageNumber==null||pageNumber<=0)
	{
		pageNumber=1;
	}
	int pageSize=10;
	String state="0";
	ArrayList list=(ArrayList) messageService.selectMessageByState(state);
	int total=list.size();
	if(total%pageSize!=0)
	{
		total++;
	}
	if(pageNumber>=total)
	{
		pageNumber=total;
	}
	PageHelper.startPage(pageNumber,pageSize);
    String id=request.getParameter("id");
    System.out.println(id);
	list=(ArrayList) messageService.selectMessageByState(state);
	mv.addObject("messageList",list);
	mv.addObject("id",id);
	mv.addObject("state","已审核");
	mv.addObject("pageNumber",pageNumber);
 	mv.addObject("totalCount",total);
	 mv.setViewName("tourist/message");
	return mv;
 }
//显示某人的文章
@RequestMapping("showOne")  
public ModelAndView show(ModelAndView mv,HttpServletRequest request)
{  
	String userid=request.getParameter("userid");//用户id
	System.out.println("用户"+userid);
	int id=Integer.parseInt(request.getParameter("id"));//文章id
	System.out.println("文章id"+id);
	Message message=messageService.selectOneMessage(id);
	mv.addObject("message",message);
	mv.setViewName("tourist/showOneMessage");
	mv.addObject("id",userid);
  	ArrayList list=(ArrayList) commontService.selectAllByMeId(id);//通过文章id获取所有的评论
 	mv.addObject("commontList",list);
 	return mv;
 }
//一级留言
@RequestMapping(value="commont",method=RequestMethod.POST)
public ModelAndView Commont(ModelAndView mv,HttpServletRequest request,@RequestParam(value="content") String content,
@RequestParam(value="mesid",required=false)Integer mesid,@RequestParam(value="userid",required=false) Integer userid)
{     
	System.out.println(userid);
  	Message message=messageService.selectOneMessage(mesid);
	 com.yp.pojo.Commont commont=new com.yp.pojo.Commont();
	 commont.setMesid(mesid);
	 commont.setContext(content);
	 commont.setUserid(userid);
	 commont.setCommontid(userid);
	 commontService.insertCommont(commont);
 	 mv.addObject("message",message);
 	 ArrayList list=(ArrayList) commontService.selectAllByMeId(mesid);//通过文章id获取所有的评论
	 mv.addObject("commontList",list);
	 mv.addObject("id",userid);
    mv.setViewName( "tourist/showAllcommont");
	return mv ;
 }
//二级留言
@RequestMapping(value="recommont",method=RequestMethod.GET)
public ModelAndView Recommont(ModelAndView mv,HttpServletRequest request)
{  
	int id=Integer.parseInt(request.getParameter("id"));//评论的id
     int userid=Integer.parseInt(request.getParameter("userid")); //回复者id
     int touserid=Integer.parseInt(request.getParameter("touserid"));  //评论者id
     mv.addObject("userid",userid);
     mv.addObject("touserid",touserid);
     mv.addObject("id",id);
     Commont com=commontService.selectOneComont(id);
     mv.addObject("commont",com);
    mv.setViewName("tourist/showRecommont");
	return mv;
 }
//添加二级留言
	@RequestMapping(value="insertRecom",method=RequestMethod.POST)
	public ModelAndView insertRecom(ModelAndView mv,HttpServletRequest request)
{ 
	int id=Integer.parseInt(request.getParameter("id"));//评论的id
    int userid=Integer.parseInt(request.getParameter("userid")); //回复者id
    int touserid=Integer.parseInt(request.getParameter("touserid"));  //评论者id
    String context=request.getParameter("context");
     Recommont recom=new Recommont();
     recom.setTouserid(touserid);
     recom.setCommontid(id);
     recom.setContext(context);
     recom.setUserid(userid);
      recommontService.insertCommont(recom);
      mv.addObject("id",userid);
      mv.setViewName("index");
	return mv;
 }
//显示所有的二级留言
@RequestMapping(value="Allrecommont")
public ModelAndView AllRecom(ModelAndView mv,HttpServletRequest request)
{
	int id=Integer.parseInt(request.getParameter("id"));//评论的id
     int userid=Integer.parseInt(request.getParameter("userid")); //回复者id
    int touserid=Integer.parseInt(request.getParameter("touserid"));  //评论者id
    ArrayList list=(ArrayList) recommontService.selectAllByCoId(id);  //通过评论id获取回复集合
    mv.addObject("reList",list);
   Commont com=commontService.selectOneComont(id);
    mv.addObject("commont",com);
    mv.addObject("userid",userid);
    mv.addObject("touserid",touserid);
    mv.addObject("id",id);
     mv.setViewName("tourist/showAllRecom");
	return mv;
 }
@RequestMapping("index")  //返回主页面
public ModelAndView index(ModelAndView mv,HttpServletRequest request)
{ 
	String id=request.getParameter("id");
	mv.addObject("id",id);
	mv.setViewName("index");
	return mv;
	
}
}
