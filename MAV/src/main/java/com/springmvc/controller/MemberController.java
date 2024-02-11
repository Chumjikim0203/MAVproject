package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController 
{
	@RequestMapping("/add")
	public String addMember()
	{
		return "test";
	}
}
