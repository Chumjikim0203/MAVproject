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
		model.addAttribute("club",clubSession);
		model.addAttribute("member", memberSession);
		session.setAttribute("club", clubSession);
		System.out.println("club컨트롤러의 getmapping에서 담긴 정보 : "+ memberSession.getMemberId());
		System.out.println("club컨트롤러의 getmapping에서 담긴 클럽명 : "+ clubSession.getClubName());
		
		return "addClub";
	}
	
	@PostMapping("/add")
	public String addClubDone(@ModelAttribute("club") Club club, @ModelAttribute("member") Member member,HttpServletRequest request, BindingResult bindingResult, Model model)
	{
		System.out.println("클럽 생성 postmapping 도착");
		if(bindingResult.hasErrors())
		{
			return "addClub";
		}
		HttpSession session = request.getSession();
		Member memberSession = (Member) session.getAttribute("member");
		Club clubSession = (Club) model.getAttribute("club");
		model.addAttribute("member", memberSession);
		model.addAttribute("club", clubSession);
	
		System.out.println("동호회 가입신청 오류 : "+bindingResult.hasErrors());
		
		clubService.addNewClub(clubSession, memberSession);
		session.setAttribute("club", clubSession);
		session.setAttribute("member", memberSession);

		System.out.println("post 에서 클럽세션에 담은 이름 : "+clubSession.getClubName());
		System.out.println("post 에서 멤버세션에 담은 아이디 : "+memberSession.getMemberId());
		
		return "redirect:/club/clubpage";
	}
	
	@GetMapping("/clubpage")
	public String myclub(HttpServletRequest request, Model model)
	{
		System.out.println("클럽페이지 도착");
		HttpSession session = request.getSession();
		Member memberSession = (Member) session.getAttribute("member");
		Club clubSession;
		
		Club club = clubService.getByClubId(memberSession.getMemberId());
		System.out.println("클럽페이지에서 가진 회원아이디 : " + memberSession.getMemberId());
		
		model.addAttribute("member", memberSession);
		model.addAttribute("club", club);
		
		clubSession = (Club) model.getAttribute("club");
		session.setAttribute("club", clubSession);
		
		return "clubpage";
	}
	
	@GetMapping("/list")
	public String clubList(Model model)
	{
		System.out.println("클럽 리스트 페이지 도착");
		
		return "clublist";
	}
	@GetMapping("/update")
	public String updateClub(Club club,HttpServletRequest request,Model model)
	{
		System.out.println("클럽 업데이트 getmapping 도착");
		HttpSession session = request.getSession();
		Club clubSession = (Club) session.getAttribute("club");
		
		model.addAttribute("club", clubSession);
		return "updateclub";
	}
	@PostMapping("/update")
	public String updateClubDone(@ModelAttribute Club club)
	{
		clubService.updateClub(club);
		return "redirect:/club/clubpage";
	}
	@GetMapping("/delete")
	public String deleteClub(Club club, HttpServletRequest request)
	{
		System.out.println("클럽 삭제 컨트롤러 도착");
		HttpSession session = request.getSession();
		Club clubSession = (Club) session.getAttribute("club");
		System.out.println("삭제 처리할 클럽명 : "+clubSession.getClubName());
		clubService.deleteClub(clubSession.getClubName());
		
		return "redirect:/member/mypage";
	}
}
