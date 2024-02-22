package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Club;
import com.springmvc.domain.Member;
import com.springmvc.service.ClubService;
import com.springmvc.service.MemberService;

@Controller
public class LoginController 
{
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private ClubService clubService;
	
	@GetMapping("/login")
	public String login(Model model)
	{
		System.out.println("로그인 페이지 도착");
		model.addAttribute(new Member());
		return "login";
	}
	@PostMapping("/login")
    public String login(@RequestParam("memberId") String memberId, 
                        @RequestParam("memberPassword") String memberPassword,
                        HttpServletRequest request) 
	{
		System.out.println("로그인 처리중");
        HttpSession session = request.getSession();
		// 사용자 인증
        Member member = memberService.getLogin(memberId, memberPassword);
        if (member != null) 
        {
            // 세션에 사용자 정보 저장
            session.setAttribute("member", member);
            System.out.println("login 컨트롤러에서 담긴 정보 : "+ member.getMemberId());
            
            return "redirect:/"; // 로그인 성공 시 대시보드 페이지로 이동
        } else {
            return "redirect:/login?error=true"; // 로그인 실패 시 로그인 페이지로 이동
        }
    }
	@GetMapping("/loginfailed")
	public String loginerror(Model model)
	{
		model.addAttribute("error", "true");
		return "login";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		
		if(session != null)
		{
			session.invalidate();
		}
		return "redirect:/login";
	}
}
