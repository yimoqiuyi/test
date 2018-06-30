package com.yp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yp.pojo.Admin;
import com.yp.service.AdminService;
import com.yp.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
@Autowired
private UserService  userService;
@Autowired
private AdminService adminService;
@RequestMapping("delete")    
public String deleteUser(int id)
{
   userService.delectUser(id);
	return null;
 }
//添加成员
@RequestMapping("/insert")
public ModelAndView insertAdmin(Admin admin,@RequestParam("imgFile") MultipartFile file)
{
	ModelAndView mv=new ModelAndView();
	adminService.insertAdmin(admin, file);
	return mv;
}
//显示管理员
@RequestMapping("show")
public ModelAndView showOneSelf(ModelAndView mv,HttpServletRequest request)
{ 
	int id=Integer.parseInt(request.getParameter("id"));
	System.out.println(id);
	Admin admin=adminService.selectOneAdmin(id);
	mv.addObject("admin",admin);
	mv.addObject("adminId",id);
	mv.setViewName("admin/admin");
	return mv;
 }
}
