package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Tournament;
import com.springmvc.service.TournamentService;

@Controller
@RequestMapping("/tournament")
public class TournamentContoller {

    @Autowired
    private TournamentService tournamentService ;
	
    
    // 토너먼트 만들기 폼 보여주기
	@GetMapping("/addtournament")
	public String create_TnForm(@ModelAttribute("newtournament")Tournament tournament) {
	
		return "addtournament";		
	}
	
	// 클라이언트에게 받은 값 db에 저장 후 리다이렉트
	@PostMapping("/addtournament")
	public String createtournament(@ModelAttribute("newtournament") Tournament tournament,Model model) {
		
		tournamentService.setNewTournament(tournament);
		System.out.println("tournament : "+ tournament.getMax_participants());	
		model.addAttribute("tournament",tournament);
		return "redirect:/store";
	}
	
	
	//마이페이지 업데이트인데 우선 모든걸 보여줌 그래서 수정해야함 아이디가 가지고있는 걸로 이걸 수정하는건 절대 아님
	@GetMapping("/updateTournament")
	public String updeateTournamentForm(@RequestParam("tournamentNum")int tournamentNum,Model model) {
		System.out.println(tournamentNum + " : tournamentNum" );
		Tournament updateTournament = tournamentService.updateTournamentForm(tournamentNum);
	    model.addAttribute("updateTournament", updateTournament);

		return "/updateTournament";
	}
	
}
