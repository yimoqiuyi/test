package com.yp.controller;

import java.util.ArrayList;
import java.util.Arrays;
 
import java.util.Iterator;
import java.util.List;
 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.web.bind.annotation.RequestParam;
 
import org.springframework.web.servlet.ModelAndView;
 
 
import com.github.pagehelper.PageHelper;
import com.yp.pojo.Admin;
import com.yp.pojo.Message;
import com.yp.service.AdminService;
import com.yp.service.MessageService;
import com.yp.service.TypeService;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private TypeService typeService;
  @Autowired
    private AdminService adminService; 
	  //添加文章（选择类型）
		@RequestMapping("write")
		public ModelAndView writeMessage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		ArrayList typelist = (ArrayList) typeService.selectAllType();
		mv.addObject("typeList", typelist);
		String id = request.getParameter("id");
   		System.out.println(typelist.size());
  		mv.addObject("userid",id);
		mv.setViewName("message/writemessage");
		return mv;

	}
//添加文章（文章的加入）
	@RequestMapping("/insert")
	public ModelAndView Insert(Message message, HttpServletRequest request, @RequestParam("userid")String  userid,Model model) {
		ModelAndView mv = new ModelAndView();
		String[] s = request.getParameterValues("type");
		List list = Arrays.asList(s);
 		int Id = Integer.parseInt(userid);
 		System.out.println("作者是"+userid);
		mv.addObject("userid", Id);
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			int k = Integer.parseInt(iterator.next());
			message.setContext(message.getContext());
			message.setDate(message.getDate());
			message.setTitle(message.getTitle());
			message.setState("1");
			message.setTypelist(list);
			message.setNote(message.getNote());
			message.setTypeId(k);
			messageService.insertMessage(message, Id);
		}
		mv.setViewName("message/return");
		return mv;
	}
	//通过标题选择文章
@RequestMapping("find")
public ModelAndView getFind( @RequestParam("findByName") String title,ModelAndView mv,HttpServletRequest request)
{  
 	int id=Integer.parseInt(request.getParameter("userid")) ;
 	System.out.println("shu chu Id"+id);
 	System.out.println(title);
 	ArrayList list=(ArrayList) messageService.selectMessageByname(title);
 	mv.addObject("state","已审核");
   	mv.addObject("messagelist",list);
 	mv.addObject("userid",id);
 	mv.setViewName("message/showFindMessage");
	return mv;
	
}
//删除文章
	@RequestMapping("/delete")
	public ModelAndView deleteMessage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int id=Integer.parseInt(request.getParameter("id"));
		String userId=request.getParameter("userId");
		messageService.delete(id);
 		mv.addObject("userid",userId);
		mv.setViewName("message/return");
		return mv;
	}

//	@RequestMapping("/update")
//	public ModelAndView updateMessage(Message message, @RequestParam("typeId") int typeId[]) {
//		ModelAndView mv = new ModelAndView();
//		message.setTitle(message.getTitle());
//		message.setContext(message.getContext());
//		int n = typeId.length;
//		for (int i = 0; i < n; i++) {
//			message.setTypeId(typeId[i]);
//		}
//		messageService.update(message,id);
//		return mv;
//	}

	// 选择集合未审核集合
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "selectOneallMs")
	public ModelAndView selectAllMessage(HttpSession session, HttpServletRequest request) {

		String id = (String) request.getParameter("id");// 用户id
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		System.out.println(pageNumber);
		int userId = Integer.parseInt(id);
		System.out.println("yonghu" + id);
		System.out.println("文章页面" + pageNumber);
		int pageSize = 4;
		ModelAndView mv = new ModelAndView();
		@SuppressWarnings("unchecked")
		ArrayList<Message> list = (ArrayList<Message>) messageService.selectAllMessageByUserId(userId);
		System.out.println("list大小"+list.size());
		int total = list.size();
		if (total % pageSize != 0) {
			total++;
		}
		if (pageNumber <= 0) {
			pageNumber = 1;
		}
		if (pageNumber >= total) {
			pageNumber = total;
		}
		mv.addObject("totalCount", total);
		PageHelper.startPage(pageNumber, pageSize);
		list = (ArrayList<Message>) messageService.selectAllMessageByUserId(userId);
		String state = null;
		state = "未审核";
		mv.addObject("state", state);
		mv.addObject("userid",userId);
		mv.addObject("pageNumber", pageNumber);
		mv.addObject("messageList", list);
		mv.setViewName("message/showOneselfMessage");
		return mv;
	}

	// 选择某个对象
	@RequestMapping("selectone")
	public ModelAndView selectOneMessage(HttpServletRequest request) {
		String id = request.getParameter("id");
		String userId=request.getParameter("userId");
		System.out.println("  ddd"+id);
		int Id = Integer.parseInt(id);
		ModelAndView mv = new ModelAndView();
		Message message = messageService.selectOneMessage(Id);
 		mv.addObject("message", message);
 		mv.addObject("userId",userId);
 		mv.addObject("id",id);
 		mv.setViewName("message/showOneMessage");
		return mv;
	}
	//审核文章
	@RequestMapping("showAll")
	public ModelAndView showAllmessage(ModelAndView mv,HttpServletRequest request)
	{    
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		String id = request.getParameter("id");
		int pageSize=10;
		ArrayList list=(ArrayList) messageService.selectMessageByState("1");
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
		String state="未审核";
		PageHelper.startPage(pageNumber,pageSize);
		list=(ArrayList) messageService.selectMessageByState("1");
		mv.addObject("allMessageList",list);
		mv.addObject("totalCount",total);
		mv.addObject("state",state);
		mv.addObject("adminId",id);	
		mv.addObject("pageNumber",pageNumber);
		mv.setViewName("admin/showAllMessage");
		return mv;
 	}
	//未实现
	@RequestMapping("adminshowone")
	public ModelAndView showOnemessage(HttpServletRequest request,ModelAndView mv)
	{  
		int id= Integer.parseInt(request.getParameter("id")) ;
		Message message=messageService.selectOneMessage(id);
		return mv;
 	}
	//文章审核
	@RequestMapping("check")
	public ModelAndView checkMessage(HttpServletRequest request,ModelAndView mv)
	{  
	 
		int  adminId=Integer.parseInt(request.getParameter("adminid")) ;
		Admin admin=adminService.selectOneAdmin(adminId);
   		int   id=Integer.parseInt(request.getParameter("id"));
 		Message message=messageService.selectOneMessage(id);
  		message.setState("0");
 		message.setContext(message.getContext());
 		message.setDate(message.getDate());
 		message.setNote(message.getNote());
 		message.setTitle(message.getTitle());
  	    messageService.updateMessage(message,id);
        mv.addObject("adminId",adminId);
        mv.addObject("admin",admin);
 		mv.setViewName("admin/admin");
		return mv;
 	}
	//管理员显示已被审核的文章
	@RequestMapping("showcheck")
	public ModelAndView showcheck(ModelAndView mv,HttpServletRequest request)
	{
		 String adminid=request.getParameter("id");
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		System.out.println(pageNumber);
		int pageSize=10;
 		ArrayList list=(ArrayList) messageService.selectMessageByState("0");
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
	    String k="已审核";
		PageHelper.startPage(pageNumber,pageSize);
		list= (ArrayList) messageService.selectMessageByState("0");
		mv.addObject("totalCount",total);
		mv.addObject("adminId",adminid);
		mv.addObject("alreadycheckList",list);
	    mv.addObject("state",k);
	    mv.addObject("pageNumber",pageNumber);
	    mv.setViewName("admin/showCheck");
		return mv;
 	}
	//个人已审核文章
	@RequestMapping("selectOneallCheck")
	public ModelAndView showAllCheck(ModelAndView mv,HttpServletRequest request)
	{ 
		
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		int pageSize=10;
		ArrayList list=(ArrayList)messageService.selectOneMessageByState(id, "0");
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
		System.out.println("查看已评审的文章");
 		PageHelper.startPage(pageNumber,pageSize);
		list=(ArrayList) messageService.selectOneMessageByState(id, "0");
		System.out.println(list.size());
		mv.addObject("state","已审核");
		mv.addObject("MessageList",list);
		mv.addObject("totalCount",total);
 		mv.addObject("userid",id);	
		mv.addObject("pageNumber",pageNumber);
		mv.setViewName("message/showAllReadyCheck");
		return mv;
 	}
  }
