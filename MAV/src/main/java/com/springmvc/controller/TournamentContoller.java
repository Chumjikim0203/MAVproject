package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.MatchRoom;
import com.springmvc.domain.Member;
import com.springmvc.domain.Room;
import com.springmvc.domain.Store;
import com.springmvc.domain.Tournament;
import com.springmvc.service.TournamentService;

@Controller
@RequestMapping("/tournament")
public class TournamentContoller {

    @Autowired
    private TournamentService tournamentService ;
	
    
    // 토너먼트 만들기 폼 보여주기
	@GetMapping("/addtournament")
	public String create_TnForm(HttpServletRequest request, @ModelAttribute("newtournament")Tournament tournament) {
		
		return "addtournament";		
	}
	
	// 클라이언트에게 받은 값 db에 저장 후 리다이렉트
	@PostMapping("/addtournament")
	public String createtournament(HttpServletRequest request, @ModelAttribute("newtournament") Tournament tournament, Model model) {
	    HttpSession session = request.getSession();
	    Store store = (Store) session.getAttribute("store");  // 세션에서 store 객체를 가져옴
	    tournament.setStoreId(store.getStoreId());  // 세션에서 가져온 storeId를 tournament 객체에 설정

	    tournamentService.setNewTournament(tournament);
	    System.out.println("tournament : "+ tournament.getMax_participants());    
	    model.addAttribute("tournament",tournament);
	    return "redirect:/store";
	}
	
	//update
	//마이페이지 업데이트인데 우선 모든걸 보여줌 그래서 수정해야함 아이디가 가지고있는 걸로 이걸 수정하는건 절대 아님
	@GetMapping("/updateTournament")
	public String updeateTournamentForm(@RequestParam("tournamentNum")int tournamentNum,Model model) {
		System.out.println(tournamentNum + " : tournamentNum" );
		Tournament updateTournament = tournamentService.updateTournamentForm(tournamentNum);
	    model.addAttribute("updateTournament", updateTournament);

		return "/updateTournament";
	}
	
	//update된것 저장
	@PostMapping("/updateTournament")
	public String changeTournament(@ModelAttribute("updateTournament")Tournament tournament) {
		
		System.out.println(tournament.getTournamentNum() + " : 이번에 여기 확인");
		//업데이트 하는구문
		tournamentService.changeTournament(tournament);
		
		return "redirect:/store";
	}
	
	@GetMapping("/deleteTournament")
	public String deletetournament(@RequestParam("tournamentNum")int tournamentNum )
	{	
		tournamentService.deleteTournament(tournamentNum);
		return "redirect:/store";
	}
	
	//ajax 연결부
    @GetMapping("/tournamentManagement")
    public String tournamentManagement(HttpServletRequest request, Model model, MatchRoom matchRoom, Room room) {
    	
		HttpSession session = request.getSession(); 
		Member member = (Member)session.getAttribute("member"); 
		Store store = (Store) session.getAttribute("store");
		System.out.println(store.getStoreId() + ": 이 부분 확인");
		System.out.println("Store 정보: " + store.getStoreId() + ", " +store.getStoreName());
		
        // 입력한 방 모두의 정보를 가지고오는 로직
		String storeId = store.getStoreId();
        model.addAttribute("member",member);
		
    	List<Tournament> newtournament = tournamentService.getTournamentByStoreId(storeId);
    	model.addAttribute("newtournament",newtournament);
        
        return "sectionTManagement";
    }
}
