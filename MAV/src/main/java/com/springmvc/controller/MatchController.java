package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.domain.Match;



@Controller
@RequestMapping("/match")
public class MatchController 
{

	
	@GetMapping("/create")
	public String createMatch(@ModelAttribute("matchForm")Match match, Model model) {
		
		matchSe
		model.addAttribute("matchForm",matchForm);
		return"/matchingRoom";
	}
	
}


