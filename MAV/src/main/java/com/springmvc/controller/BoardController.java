package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Member;
import com.springmvc.service.BoardService;
import com.springmvc.service.CommentService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
    private  BoardService boardService;
	
	@Autowired
	private  CommentService commentService;

    @GetMapping("/list")
    public String list() {
        return "boardList";
    }

    @GetMapping("/boardDetail")
    public String board(@RequestParam("id") int id) {

            return "boardDetail";        
    }
    
    @GetMapping("/writeForm")
    public String boardWriteForm() {
    // 로그인한 사용자만 글을 써야한다. 로그인을 하지 않았다면 리스트보기로 자동 이동 시킨다.
    // 세션에서 로그인한 정보를 읽어들인다.
            return "boardWriteForm";        
    }
    
    @PostMapping("/write")
    public String boardWrite(@RequestParam("boardTitle") String title,
    		                 @RequestParam("boardContents") String content,
    		                 HttpServletRequest request,
    		                 Model model
    		) {
    	
		 HttpSession session = request.getSession(); 
		 Member member = (Member)session.getAttribute("member"); 
		
		 System.out.println("member 정보: " + member.getMemberId());
		 model.addAttribute("member",member);
        // 로그인한 사용자만 글을 써야한다. 로그인을 하지 않았다면 리스트보기로 자동 이동 시킨다.
        // 세션에서 로그인한 정보를 읽어들인다.
    	
    	// 로그인한 회원 정보 + 제목, 내용을 저장한다.
    	
            return "redirect:./list";        
    }

	
	/*
	 * @GetMapping("/") public String findAll(Model model) { List<Board> BoardList =
	 * boardService.findAll(); model.addAttribute("boardList", BoardList); return
	 * "list"; }
	 */
	 


}