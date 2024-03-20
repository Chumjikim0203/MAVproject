package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Comment;

public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(resultSet.getLong("id"));
        comment.setCommentWriter(resultSet.getString("commentWriter"));
        comment.setCommentContents(resultSet.getString("commentContents"));
        comment.setBoardId(resultSet.getLong("boardId"));
        
        // comment.setCommentCreatedTime(resultSet.getTimestamp("commentCreatedTime").toLocalDateTime());
        return comment;
    }
}
