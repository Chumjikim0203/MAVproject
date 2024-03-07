package com.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Comment;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
	
	   @Autowired
	   private  JdbcTemplate jdbcTemplate;

	    @Autowired
	    public CommentRepositoryImpl(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    public void save(Comment comment) {
	        String sql = "INSERT INTO comment_table(commentWriter, commentContents, boardId) VALUES (?, ?, ?)";
	        jdbcTemplate.update(sql, comment.getCommentWriter(), comment.getCommentContents(), comment.getBoardId());
	    }

	    public List<Comment> findAll(Long boardId) {
	        String sql = "SELECT * FROM comment_table WHERE boardId = ? ORDER BY id DESC";
	        return jdbcTemplate.query(sql, new Object[]{boardId}, new CommentRowMapper());
	    }
}
