package com.springmvc.controller;

import java.util.List;

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
	
	
    // 상세보기 매칭룸만들기
    @GetMapping("/roomsDetail")
    public String detailmyRooms(@RequestParam("roomNum")int roomNum, Model model) {
    	System.out.println(roomNum);
        model.addAttribute("matchForm", new Match());
    	Room detailroom =storeService.getByroomNumAllRooms(roomNum);
    	model.addAttribute("detailroom",detailroom);
    	return "detailRoom";
    }
    
    
    // 이해가 잘 안감
    //만든 매칭룸 보여주기
     @PostMapping("/roomsDetail")
     public String createMatch(@ModelAttribute("matchForm") Match match, Model model) {
    
    	 Match newmatch = new Match(); model.addAttribute("matchForm", newmatch);
    	 matchService.matchCreate(match);
    	 
      	return "redirect:/store";
      }
     
     //업체가 만든게 아닌 회장이 만든 매칭룸을 매칭뷰로 보내는 로직
     @GetMapping("/matchingView")
     public String matchingView(Model model,MatchRoom matchRoom) {
     	List<MatchRoom> matchView = matchService.findAllMatchRooms(matchRoom);
     	System.out.println("matchview"+matchView);
     	model.addAttribute("matchView",matchView);
     	return "matchingView";
     }
     
     
     //메인페이지로 보내는 로직 작성 @겟매핑 메인 모델 사용하면 될 듯
     

     
     

	
	
}