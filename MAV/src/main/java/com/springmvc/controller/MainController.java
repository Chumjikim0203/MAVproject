package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springmvc.domain.Member;
import com.springmvc.domain.Store;
import com.springmvc.domain.Teacher;

@Controller
public class MainController {

	// 메인 페이지 호출
	@GetMapping("/main")
	public String goHome(HttpServletRequest request, Model model) 
	{
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Store store = (Store) session.getAttribute("store");
		
		model.addAttribute("member", member);
		model.addAttribute("teacher", teacher);
		model.addAttribute("store", store);
		return "main";
	}
}
