package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Comment;

public interface CommentRepository {
    void save(Comment comment);
    List<Comment> findAll(Long boardId);
}
