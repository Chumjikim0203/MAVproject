package com.springmvc.controller;

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
import com.springmvc.service.ClasseService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private ClasseService ClassesService;
	
	@GetMapping
	public String teacher(Model model ,Classes classes) {
		model.addAttribute("allclass",ClassesService.getAllClassesList(classes));
		return "teacher";
	}
}