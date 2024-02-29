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

import com.springmvc.domain.Match;
import com.springmvc.domain.MatchRoom;
import com.springmvc.domain.Member;
import com.springmvc.domain.Room;
import com.springmvc.service.MatchService;
import com.springmvc.service.StoreService;

@Controller
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private StoreService storeService;
    
	@Autowired
	private MatchService matchService;
	
	
	
	
    // 상세보기에서 매칭룸만들기
    @GetMapping("/roomsDetail")
    public String detailmyRooms(@RequestParam("roomNum")int roomNum, Model model,HttpServletRequest request ) {
    	
		HttpSession session = request.getSession(); 
		Member member = (Member)session.getAttribute("member"); 
						
        model.addAttribute("member", member);
        
        
    	model.addAttribute("matchForm", new Match());
    	Room detailroom =storeService.getByroomNumAllRooms(roomNum);
    	
    	model.addAttribute("detailroom",detailroom);
    	return "detailRoom";
    }
    
    //매칭룸 만들기
    @PostMapping("/roomsDetail")
    public String createMatch(@ModelAttribute("matchForm") Match match, HttpServletRequest request) {
        
    	// 매칭룸을 만들 때 세션에 저장된 멤버의 아이디를 설정
        HttpSession session = request.getSession(); 
        Member member = (Member) session.getAttribute("member"); 
        match.setCreatorId(member.getMemberId());
        System.out.println(match.getCreatorId()+ "크리에이터 아이디 아이디");
        
        // 매칭룸 생성 및 해당 매칭룸으로 반환
        int roomNum = matchService.matchCreate(match);
        System.out.println("roomNum :" + roomNum);
        
       // 만든 매칭룸으로 이동
        return "redirect:/match/matchingDetail?roomNum="+roomNum;
    }
    
    
    
    
    //create 매칭신청
    // 매칭룸에서 신청
    @GetMapping("/matchingDetail")
    public String detailmatchingForm(@RequestParam("roomNum")int roomNum, Model model,HttpServletRequest request ) {
    	
		HttpSession session = request.getSession(); 
		Member member = (Member)session.getAttribute("member"); 
		
		System.out.println("member 정보: " + member.getMemberId());
				
        model.addAttribute("member", member);
        
        MatchRoom matching = matchService.getMatchByRoomNum(roomNum);    
        System.out.println(matching.getMatchTitle() + " : matching.getMatchTitle()");
    	model.addAttribute("matching", matching);
    	
    	Room room =storeService.getByroomNumAllRooms(roomNum);
    	model.addAttribute("room",room);
    	    	
    	return "matchingRoom";
    }
    
    //post
    @PostMapping("/matchingApply")
    public String matchingapp(@ModelAttribute("matching") Match match, HttpServletRequest request) {
        // 매칭룸을 만들 때 세션에 저장된 멤버의 아이디를 설정
        HttpSession session = request.getSession(); 
        Member member = (Member) session.getAttribute("member"); 
        match.setApplicantId(member.getMemberId());
        System.out.println(match.getCreatorId() + " : match.getCreatorId()");
        // creatorId와 applicantId가 같은 경우 
        if (match.getCreatorId().equals(match.getApplicantId())) {
        	System.out.println("매칭 아이디중복");
            
            // 특정 페이지로 리다이렉션
            return "redirect:/match/matchingDetail?roomNum=" + match.getRoomNum();
        }
        
        matchService.applyMatch(match);


        // 원래 동호회장 만든 매칭룸으로 이동
        return "redirect:/match/matchingDetail?roomNum=" + match.getRoomNum();
    } 
    
    
    
    //read
     //매칭뷰

     @GetMapping("/matchingView")
     public String matchingView(Model model,MatchRoom matchRoom) {
    	 
    	 
     	List<MatchRoom> matchView = matchService.findAllMatchRooms(matchRoom);
     	System.out.println("matchview"+matchView);
     	model.addAttribute("matchView",matchView);
     	return "matchingView";
     }
     

     
     
     //추 후 옮기기 에러 페이지

	
	
}