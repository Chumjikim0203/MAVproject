package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.Comment;
import com.springmvc.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
    private  CommentService commentService;

    @PostMapping("/save")
    public @ResponseBody List<Comment> save(@ModelAttribute Comment comment) {
        System.out.println("comment = " + comment);
        commentService.save(comment);
        // 해당 게시글에 작성된 댓글 리스트를 가져옴
        List<Comment> commentList = commentService.findAll(comment.getBoardId());
        return commentList;
    }
}
