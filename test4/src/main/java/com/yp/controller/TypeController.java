package com.yp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yp.pojo.Type;
import com.yp.service.TypeService;

@Controller
@RequestMapping("type")
public class TypeController {
	@Autowired
	private TypeService typeService;
	//显示文章所有类型
@RequestMapping("add")
public ModelAndView insertType(Type type)
{ 
	 ArrayList list=(ArrayList) typeService.selectAllType();
	 type.setId(list.size());
	return null;
	
}
//@RequestMapping("list")
//public String getAllType(RedirectAttributes ra)
//{ 
//	ArrayList list=(ArrayList) typeService.selectAllType();
//	ra.addFlashAttribute("Typelist",list);
//	return "redirect:./message/write.do";
//	
//}
}
