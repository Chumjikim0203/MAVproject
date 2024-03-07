package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Match;
import com.springmvc.domain.MatchRoom;
import com.springmvc.domain.Member;
import com.springmvc.domain.Room;
import com.springmvc.domain.Store;
import com.springmvc.domain.Tournament;
import com.springmvc.service.MatchService;
import com.springmvc.service.StoreService;
import com.springmvc.service.TournamentService;

@Controller
@RequestMapping("/store")
public class StoreController {
   
	   
    @Autowired
    private StoreService storeService;
    
   @Autowired
   private MatchService matchService;
   
   @Autowired
   private TournamentService tournamentService;
   
   
   //해당 업체가 만든 모든 경기장룸/토너먼트/매칭룸을 가지고 스토어로감
    @GetMapping
    public String readStoreMypage(HttpServletRequest request,Model model) {
       
             
      HttpSession session = request.getSession(); 
      Member member = (Member)session.getAttribute("member"); 
      Store store = (Store) session.getAttribute("store");

      System.out.println("Store 정보: " + store.getStoreId() + ", " +store.getStoreName());
      
        // 입력한 방 모두의 정보를 가지고오는 로직
      String storeId = store.getStoreId();
        model.addAttribute("member",member);

        return "store";
    }

    //아작스 부분
    @GetMapping("/RoomManagement")
    public String roomManagement(HttpServletRequest request, Model model, Room room) {
       
      HttpSession session = request.getSession(); 
      Member member = (Member)session.getAttribute("member"); 
      Store store = (Store) session.getAttribute("store");
      System.out.println(store.getStoreId() + ": 이 부분 확인");
      System.out.println("Store 정보: " + store.getStoreId() + ", " +store.getStoreName());
      
        // 입력한 방 모두의 정보를 가지고오는 로직
      String storeId = store.getStoreId();
        model.addAttribute("member",member);

      
      //room
        List<Room> myRooms = storeService.getRoomsByStoreId(storeId);
       System.out.println(myRooms.get(room.getRoomNum()) + "이걸 확인 할꺼야");
        model.addAttribute("myRooms", myRooms);
        
        return "sectionRoom";
    }
    
    @GetMapping("/MatchRoomManagement")
    public String MatchRoomManagement(HttpServletRequest request, Model model, MatchRoom matchRoom, Room room) {
       
      HttpSession session = request.getSession(); 
      Member member = (Member)session.getAttribute("member"); 
      Store store = (Store) session.getAttribute("store");
      System.out.println(store.getStoreId() + ": 이 부분 확인");
      System.out.println("Store 정보: " + store.getStoreId() + ", " +store.getStoreName());
      
        // 입력한 방 모두의 정보를 가지고오는 로직
      String storeId = store.getStoreId();
        model.addAttribute("member",member);

      
      //MatchRoom
        List<MatchRoom> matchView = matchService.getMatchRoomsByStoreId(storeId);
        model.addAttribute("matchView",matchView);
        
      //room
        List<Room> myRooms = storeService.getRoomsByStoreId(storeId);
        System.out.println(myRooms.get(room.getRoomNum()) + "이걸 확인 할꺼야");
        model.addAttribute("myRooms", myRooms);
        
        return "sectionMatchRoom";
    }
    
    @GetMapping("/ResultManagement")
    public String ResultManagement(HttpServletRequest request, Model model, MatchRoom matchRoom, Room room) {
       
      HttpSession session = request.getSession(); 
      Member member = (Member)session.getAttribute("member"); 
      Store store = (Store) session.getAttribute("store");
      System.out.println(store.getStoreId() + ": 이 부분 확인");
      System.out.println("Store 정보: " + store.getStoreId() + ", " +store.getStoreName());
      
        // 입력한 방 모두의 정보를 가지고오는 로직
      String storeId = store.getStoreId();
        model.addAttribute("member",member);
      
      //MatchRoom
        List<MatchRoom> matchView = matchService.getMatchRoomsByStoreId(storeId);
        model.addAttribute("matchView",matchView);
        
      //room
        List<Room> myRooms = storeService.getRoomsByStoreId(storeId);
        System.out.println(myRooms.get(room.getRoomNum()) + "이걸 확인 할꺼야");
        model.addAttribute("myRooms", myRooms);
        
        return "sectionResultManagement";
    }
    
   /*
    * // 삭제 //룸 넘버 받아와서 삭제
    * 
    * @RequestMapping("/deleteRoom") public String
    * deleteRoom(@RequestParam("roomNum") int roomNum) {
    * 
    * storeService.deleteRoom(roomNum); return "redirect:/store/myRooms"; }
    */

    @GetMapping("/add")
    public String createStore(@ModelAttribute("addStore") Store store,Model model,HttpServletRequest request)
    {
    	
       HttpSession sessionId=request.getSession();
       Member member=(Member)sessionId.getAttribute("member");
       System.out.println("member:"+member.getMemberId());
       model.addAttribute("member",member);
       sessionId.setAttribute("member", member);


       
       return "addStore";
    }

    @PostMapping("/add")
    public String returnStore(@ModelAttribute("addStore") Store store,Model model,HttpServletRequest request) {
    	System.out.println("포스트store:"+store.getStoreName());
      HttpSession sessionId=request.getSession();
      Member member=(Member)sessionId.getAttribute("member");
      model.addAttribute("member",member);
      storeService.CreateStore(store);
      model.addAttribute("addstore",store);
      return "redirect:/store";
    }

    @GetMapping("/update")
    public String UpdateStore(@ModelAttribute("store") Store store,Model model,@RequestParam String storeId) {
    	Store storeById=storeService.getStoreById(storeId);
    	model.addAttribute("store",storeById);
    	System.out.println("컨트롤store:"+storeById.getStoreAddr());

    	return "storeupdateform";
    }
    @PostMapping("/update")
    public String submitStore(@ModelAttribute("store") Store store){
    	System.out.println("컨트롤store2:"+store.getStoreId());
    	storeService.UpdateStore(store);	
    	return "redirect:/";
    }
    
    @GetMapping("/delete")
    public String DeleteStore(@RequestParam String storeId){
    	storeService.DeleteStore(storeId);
    	return "redirect:/";
    }
    
    
   /*
    * @GetMapping("/myRooms") public String getMyRooms(Model model) { // 업체가 작성한 모든
    * 방의 시간과 날짜를 가져오는 로직 // 실제로는 세션 등에서 업체 아이디를 가져와야 합니다. String storeId =
    * "업체의 아이디 여기에";
    * 
    * List<Room> myRooms = storeService.getAllRoomsByStoreId();
    * model.addAttribute("myRooms", myRooms); return "myRooms"; }
    */
    
    
}