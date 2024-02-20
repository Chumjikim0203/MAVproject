package com.springmvc.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Match;
import com.springmvc.domain.Room;
import com.springmvc.repository.MatchRepository;
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
    
    //매칭룸 보여주기
     @PostMapping("/roomsDetail")
     public String createMatch(@ModelAttribute("matchForm") Match match, Model model) {
    
    	 Match newmatch = new Match(); model.addAttribute("matchForm", newmatch);
    	 matchService.matchCreate(match);
    	 
      	return "redirect:/store";
      }
     
     

     
     

	
	
}



/*
 * @PostMapping("/roomsDetail") public String createMatch(
 * 
 * @RequestParam("matchTitle") String matchTitle,
 * 
 * @RequestParam("roomNum") int roomNum,
 * 
 * @RequestParam("roomName") String roomName,
 * 
 * @RequestParam("roomCount") int roomCount,
 * 
 * @RequestParam("roomCapacity") int roomCapacity,
 * 
 * @RequestParam("roomDetail") String roomDetail,
 * 
 * @RequestParam("roomDate") LocalDate roomDate,
 * 
 * @RequestParam("roomTime") String roomTime, Model model) {
 * 
 * Match match = new Match(matchTitle, roomNum, roomName, roomCount,
 * roomCapacity, roomDetail, roomDate, roomTime);
 * model.addAttribute("matchForm", match);
 * 
 * 
 * 
 * matchForm 모델 어트리뷰트를 추가 model.addAttribute("matchForm", match);
 * 
 * 
 * return "/store"; }
 */