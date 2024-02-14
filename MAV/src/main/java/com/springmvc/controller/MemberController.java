package com.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Member;
import com.springmvc.repository.MemberRepository;

@Controller
@RequestMapping("/member")
public class MemberController 
{
	@Autowired
	private MemberRepository memberRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@GetMapping("/add/member")
	public String addMember(Model model)
	{
		System.out.println("회원가입 페이지 도착");
		model.addAttribute("member", new Member());
		return "addMember";
	}
	
	@PostMapping("/add/member")
	public String addDone(@ModelAttribute Member member, BindingResult bindingResult, Model model)
	{		
		if(bindingResult.hasErrors())
		{
			return "addMember";
		}
		model.addAttribute("member", member);
		memberRepository.setNewMember(member);
		return "memberSuccess";
	}

    @ModelAttribute("genderOptions")
    public Map<String, String> getGenderOptions() 
    {
        Map<String, String> genderOptions = new HashMap<>();
        genderOptions.put("남성", "남성");
        genderOptions.put("여성", "여성");
        return genderOptions;
    }
    
    @ModelAttribute("phone01Options")
    public Map<String, String> getPhone01Options() 
    {
        Map<String, String> phone01Options = new HashMap<>();
        phone01Options.put("010", "010");
        phone01Options.put("011", "011");
        return phone01Options;
    }
	
    @GetMapping("/update/member")
    public String updateMember(Member member,Model model)
    {    	
    	model.addAttribute("member", new Member());
    	return "updateMember";
    }
    @PostMapping("/update/member")
    public String updateDone()
    {
    	return "redirect:/member/mypage";
    }
    
    
	@GetMapping("/add/store")
	public String addStore()
	{
		return "addStore";
	}
	
	@GetMapping("/add/teacher")
	public String addTeacher()
	{
		return "addTeacher";
	}
	
	@GetMapping("/add/club")
	public String addClub()
	{
		return "addClub";
	}
	
	@GetMapping("/login")
	public String Login()
	{
		return "redirect:/login";
	}
	@GetMapping("/mypage")
	public String myPage()
	{
		return "mypage";
	}
}
