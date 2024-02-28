package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Classes;
import com.springmvc.domain.Member;
import com.springmvc.domain.Teacher;
import com.springmvc.service.ClasseService;
import com.springmvc.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private ClasseService ClassesService;
	@Autowired
	private TeacherService teacherService;
	//강사 마이페이지
	@GetMapping
	public String teacher(Model model ,Classes classes,Member member,HttpServletRequest request,Teacher teacher) {
	
		HttpSession sessionId=request.getSession();	
		member= (Member)sessionId.getAttribute("member");
        teacher= teacherService.teacherId(member.getMemberId());
		model.addAttribute("allclass",ClassesService.getAllClassesList(classes));
//		System.out.println("teachermember:"+member.getMemberId());
//		System.out.println("addmember:"+member.getMemberEmail());
		System.out.println("teachermypagecontroller:"+teacher.getTeacherCategory());
		model.addAttribute("teacher",teacher);
		
		model.addAttribute("member",member);
		
		return "teacher";
	}
	//강사등록하기 c
	@GetMapping("/add")
	public String addteacher(@ModelAttribute("addTeacher") Teacher teacher,Model model,HttpServletRequest request) {
		//세션만들기
		HttpSession sessionId=request.getSession();		
		//세션은 오브젝트 타입이라 (캐스팅)해주고 member에서 받은 sessionId.getAttribute("member");맞춰줘야함
		Member member= (Member)sessionId.getAttribute("member");
		System.out.println("addsessionId:"+member);
		System.out.println("addmemberid:"+member.getMemberId());
//		System.out.println("addmemberpw:"+member.getMemberPassword());	
		model.addAttribute("member", member);
		
		return "addTeacher";
	}
	//강사등록하기 서브밋c
	@PostMapping("/add")
	public String submitaddteacher(@ModelAttribute("addTeacher") Teacher teacher,Model model,BindingResult bindingResult,HttpServletRequest request)
	{
		HttpSession sessionId=request.getSession();
		Member member=(Member)sessionId.getAttribute("member");
		model.addAttribute("member",member);
		sessionId.setAttribute("member", member);
		System.out.println("memberid:"+member.getMemberId());
	//	System.out.println("teacheradd:"+teacher.getTeacherId());
		//에러확인코드 
		//System.out.println(bindingResult.hasErrors());		
		//System.out.println("강사등록서브밋:"+teacher.getTeacherCategory());
		
		teacherService.CreateTeacher(teacher);
		model.addAttribute("teacher",teacher);
		
		return "redirect:/teacher";
	}
	// 강사수정 u
	@GetMapping("/update/teacher")
	public String updateteacher(@ModelAttribute("update") Teacher teacher,@RequestParam String teacherId,Model model, HttpServletRequest reqeust) {
		HttpSession sessionId=reqeust.getSession();
		Member member=(Member)sessionId.getAttribute("member");
		Teacher teacherById=teacherService.teacherId(teacherId);
		model.addAttribute("member",member);
		System.out.println("여기도착 teacherid는?:"+teacher.getTeacherCategory());
		model.addAttribute("teacher",teacherById);
		
		
		return "teacherupdateform";
	}
	@PostMapping("/update/formupdate")
	public String submitupdateteacher(@ModelAttribute("update")Teacher teacher,@RequestParam String teacherId) {
	System.out.println("submitupdateteacher도착");
		teacherService.UpdateTeacher(teacher);
		return "redirect:/teacher";
	}
	// R

}