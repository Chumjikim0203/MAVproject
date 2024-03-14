package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Board;

public class BoardRowMapper implements RowMapper<Board> {

    @Override
    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
        Board board = new Board();
        board.setId(rs.getLong("id"));
        board.setBoardWriter(rs.getString("boardWriter"));
        board.setBoardPass(rs.getString("boardPass"));
        board.setBoardTitle(rs.getString("boardTitle"));
        board.setBoardContents(rs.getString("boardContents"));
        board.setBoardCreatedTime(rs.getTimestamp("boardCreatedTime"));
        board.setBoardHits(rs.getInt("boardHits"));
        
        // board.setFileAttached(rs.getInt("fileAttached"));

        return board; // 수정된 부분
    }
}
