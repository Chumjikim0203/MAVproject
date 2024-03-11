package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.springmvc.domain.Store;
import com.springmvc.domain.Teacher;
import com.springmvc.repository.ClassesRepository;
import com.springmvc.service.ClasseService;
import com.springmvc.service.TeacherService;

@Controller
@RequestMapping("/Class")
public class ClassController {
	@Autowired
	private ClasseService ClassesService;
	@Autowired
	private TeacherService teacherService;
//	@GetMapping
//	public String teacher(Model model ,Classes classes) {
//		model.addAttribute("allclass",ClassesService.getAllClassesList(classes));
//		return "teacher";
//	}

	@GetMapping("/addclass")
	public String addclassform(@ModelAttribute("newclasses")Classes claases, Model model,HttpServletRequest request,Member member,Teacher teacher) {
		HttpSession sessionId=request.getSession();	
		member= (Member)sessionId.getAttribute("member");
		teacher= (Teacher)sessionId.getAttribute("teacher");
		Classes classes = new Classes();
		System.out.println("Getadd:"+teacher.getTeacherId());
		model.addAttribute("classes", classes);
		model.addAttribute("member", member);
		model.addAttribute("teacher",teacher);
		classes.setClassIntroduction("ex)"
		+ "■강의 특이사항\r\n"
        + " 학원 가는 길: 엘리베이터를 이용하여 10층  \r\n"
        + "\r\n"
        + "■주차: 학원수강생 선착순 3대 2시간 무료 \r\n"
        + "-주차 미등록자는 사무실 직원에게 문의 /010-0000-0000)\r\n"
        + "-21시 이후 입차 시 주차비용 발생\r\n"
        + "\r\n"
        + "■무단 출입 금지\r\n"
        + "\r\n"
        + "■수강대상 \r\n"
        + "비전공자 가능 \r\n"
        + "■00강의란 ?\r\n"
        + "간단한 설명 \r\n"
        + "■관련자격증 ?\r\n"
        + "간단한 설명 \r\n" 
        + "■환불 정책 \r\n"
        + "신청 취소 시 환불 기준\r\n"
        + "매치 2일 전   무료 취소\r\n"
        + "매치 1일 전   80% 환급\r\n"
        + "당일 ~ 첫수강 시작 90분 전까지   20% 환급\r\n"
        + "취소 수수료 발생 시 사용된 포인트를 우선 차감 후 차액을 캐시로 지급 합니다.\r\n"
        + "■그 외 취소 기준\r\n");
       

		return "addclass";
	}

	//강의등록 하기버튼
	  @PostMapping("/addclass") 
	  public String createaddclass(@ModelAttribute Classes classes,BindingResult bindingResult, Model model,HttpServletRequest request,Teacher teacher)
	  { 
	  HttpSession sessionId=request.getSession();	
	  teacher= (Teacher)sessionId.getAttribute("teacher");
	  classes = (Classes) model.getAttribute("classes");
	  System.out.println("addteacherId:"+teacher.getTeacherId());
	  model.addAttribute("teacher",teacher); 
	  model.addAttribute("classes",classes); 
	  ClassesService.setNewClasses(classes);
	 // return "redirect:/teacher";
	  return "redirect:/teacher";

	  }
//	  @GetMapping("/allclass")
//	  public String readclasses(Model model ,Classes classes) {
//		  System.out.println("allclass 도착");
//		  List<Classes> allclasses=Classesservice.getAllClassesList(classes);
//		  System.out.println("allclasses:"+allclasses);
//		  System.out.println("classgrade:"+classes.getClassGrade());
//		  System.out.println("className:"+classes.getClassName());
//		  model.addAttribute("allclass",allclasses);
//		  return "teacher";
//	  }
	  @GetMapping("/updateclass")
	  public String updateclass(@RequestParam ("classNum")int classNum, Model model,HttpServletRequest request,Member member,Teacher teacher) {
		  HttpSession sessionId=request.getSession();	
		  member= (Member)sessionId.getAttribute("member");
          teacher= teacherService.teacherId(member.getMemberId());
		  System.out.println("updateclass도착:"+classNum);
		  Classes getById=ClassesService.getById(classNum);
		  model.addAttribute("classes",getById);
		  model.addAttribute("teacher",teacher);
		  model.addAttribute("member",member);
//		  뷰페이지에  <form:form modelAttribute="classes" 와 매핑
		  return "classupdateform";
	  }
	  @PostMapping("/updateclass")
	  public String updateclass2(@ModelAttribute("classes")  Classes classes,Model model){
		  System.out.println("update2도착");
		  System.out.println("classname"+classes.getClassName());
		  System.out.println("classnum"+classes.getClassNum());
			

		  ClassesService.setUpdateClasses(classes);
		 
		  return "redirect:/teacher";
	  }

	//삭제하기
	  @GetMapping("/deleteclass")
	  public String deleteclass(Model model,@RequestParam("classNum")int classNum) {
		  ClassesService.setdeleteClasses(classNum);
		  return "redirect:/teacher";
	  }
		//상세정보뿌려주기
	  @GetMapping("/detailclass")
	  public String detailclass(@RequestParam("classNum") int classNum, Model model,HttpServletRequest request,Member member) {
		  HttpSession sessionId=request.getSession();	
		  member= (Member)sessionId.getAttribute("member");
		  Store store= (Store) sessionId.getAttribute("store");
		  model.addAttribute("member",member);
		  model.addAttribute("store",store);
		  model.addAttribute("detailclass",ClassesService.getById(classNum));
		  System.out.println("cs.getby:"+ClassesService.getById(classNum));
		  return "detailclass";
	  }
	  
	  //read classList
	  @GetMapping("/classlist")
	  public String ClassList( Model model,HttpServletRequest request,Member member,Teacher teacher, Classes classes) {
		  HttpSession sessionId=request.getSession();	
		  member= (Member)sessionId.getAttribute("member");
		  Store store = (Store) sessionId.getAttribute("store");
		  teacher= teacherService.teacherId(member.getMemberId());
		  List<Classes> classesall=(List<Classes>)ClassesService.getAllClassesList(classes);
		  model.addAttribute("member",member);
		  model.addAttribute("teacher", teacher);
		  model.addAttribute("store", store);
		  model.addAttribute("classes",classesall);
		  System.out.println("classlist도착 member는:"+member.getMemberId());
		  System.out.println("classes:"+classesall);
		  return "classlist";
	  }
	  @GetMapping("/addmember")
	  public String addclassmember(@ModelAttribute("detailclass") Classes classes, HttpServletRequest request,Model model) {
	        HttpSession sessionId = request.getSession();	
	        Member member = (Member)sessionId.getAttribute("member");
	        String memberlistname =member.getMemberName();
	        
	        classes = ClassesService.getById(classes.getClassNum());
	        List<Member> memberlist=new ArrayList<Member>();
	        if (classes != null && member != null) 
	        {
	        	 memberlist.add(member);	           
	        }
	        
	        System.out.println("classes 에 담긴 클래스 넘버 : "+classes.getClassNum());
	        System.out.println("member:"+memberlist);
	        model.addAttribute("memberlist",memberlist);
	        model.addAttribute("detailclass",classes);
	        return "detailclass";
	    }

	     
}

