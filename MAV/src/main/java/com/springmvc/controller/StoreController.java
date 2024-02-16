package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Room;
import com.springmvc.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    
    //대경이행님이 로긴 만들면 값 가지고 와서 store들어가자 마자 뿌리기(아이디별로 하는것 만들어야함)
    @GetMapping
    public String readStoreMypage(Model model, Room room) {
        // 입력한 방 모두의 정보를 가지고오는 로직
        List<Room> myRooms = storeService.getAllRooms(room);
        model.addAttribute("myRooms", myRooms);
        return "store";
    }
    
    //방만들기
    @GetMapping("/addrooms")
    public String createStoreRoomForm(@ModelAttribute("newrooms") Room room,Model model) {
       
        Room newRoom = new Room();
        model.addAttribute("newrooms",newRoom);
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
    public String createStoreRoom(@ModelAttribute("newrooms") Room room,BindingResult bindingResult, Model model) {
    	
        storeService.createRoom(room);
        model.addAttribute("newrooms", room);
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
    // 상세보기
    @GetMapping("/roomsDetail")
    public String detailmyRooms(@RequestParam("roomNum")int roomNum, Model model) {
    	System.out.println(roomNum);
    	Room detailroom =storeService.getByroomNumAllRooms(roomNum);
    	model.addAttribute("detailroom",detailroom);
    	return "detailRoom";
    }
    
    
    
    // 리드를 검증하기 위해서 가짜로 작성해둠
    @GetMapping("/myRooms")
    public String readAllRooms(Model model, Room room) {
    	List<Room> allrooms = storeService.getAllRooms(room);
    	model.addAttribute("allrooms", allrooms);
    	
    	return "myRooms";
    }
    
    // 이것도 필요 없으나 우선 적으로 작성해둠
    @RequestMapping("/deleteRoom")
    public String deleteRoom(@RequestParam("roomNum") int roomNum) {
    	
    	System.out.println(roomNum + "여기까지온거 마져?");
        storeService.deleteRoom(roomNum);
        return "redirect:/store/myRooms";
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