package com.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Club;
import com.springmvc.domain.Member;
import com.springmvc.service.ClubService;

@Controller
@RequestMapping("/club")
public class ClubController 
{
	@Autowired
	private ClubService clubService;
	
	@ModelAttribute("categoryOptions")
    public Map<String, String> getCategoryOptions() 
    {
        Map<String, String> categoryOptions = new HashMap<>();
        categoryOptions.put("농구", "농구");
        categoryOptions.put("풋살", "풋살");
        categoryOptions.put("족구", "족구");
        categoryOptions.put("당구", "당구");
        categoryOptions.put("야구", "야구");
        return categoryOptions;
    }
	
	@GetMapping("/add")
	public String addClub(HttpServletRequest request,Model model)
	{
		HttpSession session = request.getSession();
		Member memberSession = (Member) session.getAttribute("member");
		Club clubSession = (Club) session.getAttribute("club");
		if(clubSession==null)
		{
			clubSession = new Club();
		}
		model.addAttribute("club", clubSession);
		session.setAttribute("club", clubSession);
		System.out.println("club컨트롤러의 getmapping에서 담긴 정보 : "+ memberSession.getMemberId());
		System.out.println("club컨트롤러의 getmapping에서 담긴 클럽명 : "+ clubSession.getClubName());
		
		return "addClub";
	}
	
	@PostMapping("/add")
	public String addClubDone(@ModelAttribute Club club, @ModelAttribute Member member,HttpServletRequest request, BindingResult bindingResult, Model model)
	{
		System.out.println("클럽 생성 postmapping 도착");
		HttpSession session = request.getSession();
		Member memberSession = (Member) session.getAttribute("member");
		Club clubSession = (Club) session.getAttribute("club");
		if(bindingResult.hasErrors())
		{
			return "addClub";
		}
		System.out.println("동호회 가입신청 오류 : "+bindingResult.hasErrors());
		clubService.addNewClub(clubSession, memberSession);
		model.addAttribute("club", clubSession);
		session.setAttribute("club", clubSession);
		System.out.println("클럽 생성할 postmapping에서 담긴 클럽명 : " + clubSession.getClubName());
		System.out.println("club컨트롤러의 postmapping에서 담긴 정보 : " + memberSession.getMemberId());
		return "mypage";
	}	
	
	@GetMapping("/clubpage")
	public String myclub(@ModelAttribute String clubName, HttpServletRequest request, Model model)
	{
		System.out.println("클럽페이지 도착");
		HttpSession session = request.getSession();
		Member memberSession = (Member) session.getAttribute("member");
		Club clubSession = (Club) session.getAttribute("club");
		session.setAttribute("club", clubSession);
		session.setAttribute("member", memberSession);
		List<Club> getByClubName = clubService.getByClubName(clubSession.getClubName());
		model.addAttribute("clubList", getByClubName);
		return "clubpage";
	}	
	@GetMapping("/update")
	public String updateClub(@RequestParam String ClubId,Club club,Model model)
	{
		System.out.println("클럽 업데이트 getmapping 도착");
		Club getByClubId = clubService.getByClubId(ClubId);
		System.out.println("업데이트 처리할 clubId" + getByClubId.getClubId());
		model.addAttribute("club", getByClubId);
		return "updateclub";
	}
}
