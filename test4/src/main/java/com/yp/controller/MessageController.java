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
	  //������£�ѡ�����ͣ�
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
//������£����µļ��룩
	@RequestMapping("/insert")
	public ModelAndView Insert(Message message, HttpServletRequest request, @RequestParam("userid")String  userid,Model model) {
		ModelAndView mv = new ModelAndView();
		String[] s = request.getParameterValues("type");
		List list = Arrays.asList(s);
 		int Id = Integer.parseInt(userid);
 		System.out.println("������"+userid);
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
	//ͨ������ѡ������
@RequestMapping("find")
public ModelAndView getFind( @RequestParam("findByName") String title,ModelAndView mv,HttpServletRequest request)
{  
 	int id=Integer.parseInt(request.getParameter("userid")) ;
 	System.out.println("shu chu Id"+id);
 	System.out.println(title);
 	ArrayList list=(ArrayList) messageService.selectMessageByname(title);
 	mv.addObject("state","�����");
   	mv.addObject("messagelist",list);
 	mv.addObject("userid",id);
 	mv.setViewName("message/showFindMessage");
	return mv;
	
}
//ɾ������
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

	// ѡ�񼯺�δ��˼���
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "selectOneallMs")
	public ModelAndView selectAllMessage(HttpSession session, HttpServletRequest request) {

		String id = (String) request.getParameter("id");// �û�id
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		System.out.println(pageNumber);
		int userId = Integer.parseInt(id);
		System.out.println("yonghu" + id);
		System.out.println("����ҳ��" + pageNumber);
		int pageSize = 4;
		ModelAndView mv = new ModelAndView();
		@SuppressWarnings("unchecked")
		ArrayList<Message> list = (ArrayList<Message>) messageService.selectAllMessageByUserId(userId);
		System.out.println("list��С"+list.size());
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
		state = "δ���";
		mv.addObject("state", state);
		mv.addObject("userid",userId);
		mv.addObject("pageNumber", pageNumber);
		mv.addObject("messageList", list);
		mv.setViewName("message/showOneselfMessage");
		return mv;
	}

	// ѡ��ĳ������
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
	//�������
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
		String state="δ���";
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
	//δʵ��
	@RequestMapping("adminshowone")
	public ModelAndView showOnemessage(HttpServletRequest request,ModelAndView mv)
	{  
		int id= Integer.parseInt(request.getParameter("id")) ;
		Message message=messageService.selectOneMessage(id);
		return mv;
 	}
	//�������
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
	//����Ա��ʾ�ѱ���˵�����
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
	    String k="�����";
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
	//�������������
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
		System.out.println("�鿴�����������");
 		PageHelper.startPage(pageNumber,pageSize);
		list=(ArrayList) messageService.selectOneMessageByState(id, "0");
		System.out.println(list.size());
		mv.addObject("state","�����");
		mv.addObject("MessageList",list);
		mv.addObject("totalCount",total);
 		mv.addObject("userid",id);	
		mv.addObject("pageNumber",pageNumber);
		mv.setViewName("message/showAllReadyCheck");
		return mv;
 	}
  }
