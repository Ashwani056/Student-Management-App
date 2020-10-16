package com.ashwani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashwani.entity.Student;
import com.ashwani.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService setuService;
	
	@RequestMapping("/welcome")
	public String showWelcomePage()
	{
		return "welcome";
	}
	
	@RequestMapping("/addform")
	public String showAddPage()
	{
		return "addform";
	}
	@RequestMapping("/searchform")
	public String showSearchPage()
	{
		return "searchform";
	}
	
	@RequestMapping("/updateform")
	public String showUpdatePage()
	{
		return "updateform";
	}
	
	@RequestMapping("/deleteform")
	public String showDeletePage()
	{
		return "deleteform";
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(ModelMap map, @RequestParam String sid,@RequestParam String sname,@RequestParam String saddr)
	{
		map.addAttribute("Studentoperation", "Student Instertion");
		Student student=new Student();
		student.setSid(sid);
		student.setSname(sname);
		student.setSaddr(saddr);
		
		String status=setuService.addStudent(student);
		return status;
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String search(ModelMap map, @RequestParam String sid)
	{
		map.addAttribute("Studentoperation", "Student Search");
		Student student=setuService.searchStudent(sid);
		if(student!=null)
		{
			map.addAttribute("student",student);
			return "display";
		}
		else {
			return "notexisted";
		}
		
	}
	
	@RequestMapping(value="/editform",method=RequestMethod.POST)
	public String getEditForm(ModelMap map, @RequestParam String sid)
	{
		map.addAttribute("Studentoperation", "Student Search");
		Student student=setuService.searchStudent(sid);
		if(student!=null)
		{
			map.addAttribute("student",student);
			return "editform";
		}
		else {
			return "notexisted";
		}
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(ModelMap map, @RequestParam String sid,@RequestParam String sname,@RequestParam String saddr)
	{
		map.addAttribute("Studentoperation", "Student Updation");
		Student student=new Student();
		student.setSid(sid);
		student.setSname(sname);
		student.setSaddr(saddr);
		
		String status=setuService.updateStudent(student);
		return status;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(ModelMap map, @RequestParam String sid)
	{
		map.addAttribute("Studentoperation", "Student Search");
		map.addAttribute("studentOperation","student Deletion");
		Student student=setuService.searchStudent(sid);
		if(student!=null)
		{
			String status=setuService.deleteStudent(sid);
			return status;
		}
		else {
			return "notexisted";
		}
		
	}
	
	
	
}
