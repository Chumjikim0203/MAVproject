package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Comment;
import com.springmvc.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
    private  CommentRepository commentRepository;

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> findAll(Long boardId) {
        return commentRepository.findAll(boardId);
    }
}
