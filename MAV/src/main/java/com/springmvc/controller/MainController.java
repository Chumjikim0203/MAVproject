package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springmvc.domain.MatchRoom;
import com.springmvc.domain.Room;
import com.springmvc.service.ClubService;
import com.springmvc.service.MatchService;
import com.springmvc.service.StoreService;

@Controller
public class MainController {
<<<<<<< HEAD
   
    @Autowired
    private StoreService storeService;
    
   @Autowired
   private MatchService matchService;
   
   @Autowired
   private ClubService clubService;

   // 메인 페이지 호출
   @GetMapping("/main")
   public String goHome(Model model,Room room,MatchRoom matchRoom) {   
      
      //매칭룸
       List<MatchRoom> matchView = matchService.findAllMatchRooms(matchRoom);
       model.addAttribute("matchView",matchView);
       
       
       //경기장
        List<Room> myRooms = storeService.getAllRooms(room);
        model.addAttribute("myRooms", myRooms);
       
      return "main";
   }

}

=======
	
    @Autowired
    private StoreService storeService;
    
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private ClubService clubService;

	// 메인 페이지 호출
	@GetMapping("/main")
	public String goHome(Model model,Room room,MatchRoom matchRoom) {	
		
		//매칭룸
    	List<MatchRoom> matchView = matchService.findAllMatchRooms(matchRoom);
    	model.addAttribute("matchView",matchView);
    	
    	
    	//경기장
        List<Room> myRooms = storeService.getAllRooms(room);
        model.addAttribute("myRooms", myRooms);
    	
		return "main";
	}

}


>>>>>>> origin/KTY
