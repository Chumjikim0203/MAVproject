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
<<<<<<< HEAD
import com.springmvc.domain.Teacher;
=======
>>>>>>> origin/KTY
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

    //대경이행님이 로긴 만들면 값 가지고 와서 store들어가자 마자 뿌리기(아이디별로 하는것 만들어야함)
	//해당 업체가 만든 모든 경기장룸/토너먼트/매칭룸을 가지고 스토어로감
    @GetMapping
<<<<<<< HEAD
    public String readStoreMypage(HttpServletRequest request,Model model, Room room, MatchRoom matchRoom, Tournament tournament,Store store,Member member) {
        // 입력한 방 모두의 정보를 가지고오는 로직
    	HttpSession session = request.getSession();
    	
    	member=(Member)session.getAttribute("member");
    	model.addAttribute("member",member);
    	System.out.println("session.getId() :" + session.getAttribute("member"));
    	List<Tournament> newtournament = tournamentService.getAlltournament(tournament);
    	model.addAttribute("newtournament",newtournament);
     	List<MatchRoom> matchView = matchService.findAllMatchRooms(matchRoom);
     	model.addAttribute("matchView",matchView);
        List<Room> myRooms = storeService.getAllRooms(room);
=======
    public String readStoreMypage(HttpServletRequest request,Model model,Room room, MatchRoom matchRoom, Tournament tournament) {
    	
    			
		  HttpSession session = request.getSession(); 
		  Member member = (Member)session.getAttribute("member"); 
		  Store store = (Store) session.getAttribute("store");

		  System.out.println("Store 정보: " + store.getStoreId() + ", " +store.getStoreName());
		  System.out.println("Store 정보: " + store.getStoreId() +", " + store.getStoreName());
	
    	
        // 입력한 방 모두의 정보를 가지고오는 로직
		String storeId = store.getStoreId();
		
		//room
        List<Room> myRooms = storeService.getRoomsByStoreId(storeId);
>>>>>>> origin/KTY
        model.addAttribute("myRooms", myRooms);
        
        //토너먼트
    	List<Tournament> newtournament = tournamentService.getTournamentByStoreId(storeId);
    	model.addAttribute("newtournament",newtournament);
    	
    	//매칭룸
     	List<MatchRoom> matchView = matchService.getMatchRoomsByStoreId(storeId);
     	model.addAttribute("matchView",matchView);
     	

        return "store";
    }
    
    
    //방만들기 폼 보여주기
    @GetMapping("/addrooms")
    public String createStoreRoomForm(@ModelAttribute("newrooms") Room room, Model model) {


        Room newRoom = new Room();
       
        model.addAttribute("newrooms", newRoom);
        newRoom.setRoomDetail("ex)\r\n"
        		+ "■구장 특이사항\r\n"
        		+ " 풋살장 가는 길: 엘리베이터를 이용하여 10층 풋살장으로 이동 \r\n"
        		+ "\r\n"
        		+ "■주차: 매치 신청 시 선착순 3대 2시간 무료 \r\n"
        		+ "-주차 미등록자는 사무실 직원에게 문의 /010-0000-0000)\r\n"
        		+ "-주차 등록은 매치 30분 이내 변경 및 신청 불가(이후 10분당 500원)\r\n"
        		+ "-21시 이후 입차 시 주차비용 발생\r\n"
        		+ "\r\n"
        		+ "■풋살화: 대여 가능(3,000원, Size : 250~285) (사이즈별 재고 여부는 구장 측으로 문의 주세요.)\r\n"
        		+ "\r\n"
        		+ "■무단 출입 금지\r\n"
        		+ "\r\n"
        		+ "■매치 진행 방식\r\n"
        		+ "매치 규칙\r\n"
        		+ "모든 파울은 사이드라인에서 킥인\r\n"
        		+ "골키퍼에게 백패스 가능. 손으로는 잡으면 안 돼요\r\n"
        		+ "사람을 향한 태클 금지\r\n"
        		+ "■진행 방식\r\n"
        		+ "\r\n"
        		+ "■환불 정책\r\n"
        		+ "신청 취소 시 환불 기준\r\n"
        		+ "매치 2일 전	무료 취소\r\n"
        		+ "매치 1일 전	80% 환급\r\n"
        		+ "당일 ~ 매치 시작 90분 전까지	20% 환급\r\n"
        		+ "매치 시작 90분 이내 환불 불가\r\n"
        		+ "취소 수수료 발생 시 사용된 포인트를 우선 차감 후 차액을 캐시로 지급 합니다.\r\n"
        		+ "■그 외 취소 기준\r\n"
        		+ "결제 후 30분 이내에는 하루 1회에 한해 무료 취소가 가능합니다. (단, 매치 시작 90분 이내일 경우 불가)");
        return "addrooms";
    }
    
    
    // 방 등록하기
    @PostMapping("/addrooms")
    public String createStoreRoom(HttpServletRequest request, @ModelAttribute("newrooms") Room room, Model model) {
    	
        HttpSession session = request.getSession();
        Store store = (Store) session.getAttribute("store");  // 세션에서 store 객체를 가져옴
        room.setStoreId(store.getStoreId());  // 세션에서 가져온 storeId를 room 객체에 설정

        storeService.createRoom(room);
        System.out.println("room : "+ room.getRoomCapacity());    
        model.addAttribute("room",room);
        return "redirect:/store";
    }
    
    // 업체 마이룸에서 방 삭제(아이디별로 하는것 만들어야함)
    @RequestMapping("/deleteMyRoom")
    public String deleteMyRoom(@RequestParam("roomNum") int roomNum) {
    	
        storeService.deleteRoom(roomNum);
        return "redirect:/store";
    }
    
    // 업체마이페이지에서 수정버튼 폼 보여주는(아이디별로 하는것 만들어야함)
    @GetMapping("/roomsUpdate")
    public String updatemyRooms(@RequestParam("roomNum")int roomNum, Model model) {
    	System.out.println(roomNum);
    	Room updateRooms =storeService.getByroomNumAllRooms(roomNum);
    	
    	model.addAttribute("updateRooms",updateRooms);
    	return "roomsUpdate";
    }
    
    //수정 값 db랑 연결하는 로직
    @PostMapping("/roomsChange")
    public String changeRooms(@ModelAttribute("updateRooms")Room updateRoom) {
    	
    	storeService.updateRoom(updateRoom);
    	
    	return "redirect:/store";
    }
    

    
    
    
    // 메인 및 룸페이지로 보내드는 리드라인
    @GetMapping("/myRooms")
    public String readAllRooms(Model model, Room room) {
    	List<Room> allrooms = storeService.getAllRooms(room);
    	model.addAttribute("allrooms", allrooms);
    	
    	return "myRooms";
    }
    
    // 삭제
    //룸 넘버 받아와서 삭제
    @RequestMapping("/deleteRoom")
    public String deleteRoom(@RequestParam("roomNum") int roomNum) {
    	
        storeService.deleteRoom(roomNum);
        return "redirect:/store/myRooms";
    }
    
    //업체가 만든 룸을 roomview로들어왔을때 보여주는 로직
    @GetMapping("/roomView")
    public String roomMainView(Model model, Room room, HttpServletRequest request) {
        
    	// 세션에서 memberId 가져오기
		
		 HttpSession session = request.getSession(); 
		 Member member = (Member)session.getAttribute("member"); 
		
		 System.out.println("member 정보: " + member.getMemberId());
		
		
		// 입력한 방 모두의 정보를 가지고오는 로직
		String memberId = member.getMemberId();

        // 입력한 방 모두의 정보를 가지고오는 로직
        List<Room> myRooms = storeService.getAllRooms(room);

        model.addAttribute("memberId", memberId);
        model.addAttribute("myRooms", myRooms);
        return "roomView";
    }
    
    @GetMapping("/add")
    public String createStore(@ModelAttribute("addStore") Store store,Model model,HttpServletRequest request)
    {
    	HttpSession sessionId=request.getSession();
		Member member=(Member)sessionId.getAttribute("member");
		model.addAttribute("member",member);
		sessionId.setAttribute("member", member);
    	System.out.println("member:"+member.getMemberId());

    	
    	return "addStore";
    }
    @PostMapping("/add")
    public String returnStore(@ModelAttribute("addStore") Store store,Model model,HttpServletRequest request) {
    	HttpSession sessionId=request.getSession();
		Member member=(Member)sessionId.getAttribute("member");
		model.addAttribute("member",member);
    	storeService.CreateStore(store);
		model.addAttribute("addstore",store);
    	return "redirect:/store";
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