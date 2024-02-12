package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController 
{
	@GetMapping("/add/member")
	public String addMember()
	{
		return "addMember";
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
}
