package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Member;

@Controller
@RequestMapping("/admin")
public class adminController 
{
	@GetMapping("/adminpage")
	public String adminPage(Model model, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		return "adminpage";
	}
}
