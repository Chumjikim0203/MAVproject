package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Comment;

public interface CommentService {
	
	void save(Comment comment);
    public List<Comment> findAll(Long boardId);

}
