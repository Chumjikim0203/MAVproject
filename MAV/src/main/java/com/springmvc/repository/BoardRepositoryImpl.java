package com.springmvc.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Board;
@Repository
public class BoardRepositoryImpl implements BoardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public BoardRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
	   public BoardRepositoryImpl() {
		   
	   }
	   
	    @Override
	    public int save(Board board) {
	        String sql = "INSERT INTO board_table (boardWriter, boardPass, boardTitle, boardContents) VALUES (?, ?, ?, ?)";
	        return jdbcTemplate.update(sql,
	                board.getBoardWriter(),
	                board.getBoardPass(),
	                board.getBoardTitle(),
	                board.getBoardContents());
	    }
	   
	    public List<Board> findAll() {
	        String sql = "SELECT * FROM board_table";
	        return jdbcTemplate.query(sql, new BoardRowMapper());
	    }

	    public Board findById(Long id) {
	        String sql = "SELECT * FROM board_table WHERE id = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BoardRowMapper());
	    }

	    public void updateHits(Long id) {
	        String sql = "UPDATE board_table SET boardHits = boardHits + 1 WHERE id = ?";
	        jdbcTemplate.update(sql, id);
	    }

	    public void delete(Long id) {
	        String sql = "DELETE FROM board_table WHERE id = ?";
	        jdbcTemplate.update(sql, id);
	    }

	    public void update(Board Board) {
	        String sql = "UPDATE board_table SET boardWriter = ?, boardPass = ?, boardTitle = ?, boardContents = ? WHERE id = ?";
	        jdbcTemplate.update(sql, Board.getBoardWriter(), Board.getBoardPass(),
	                Board.getBoardTitle(), Board.getBoardContents(), Board.getId());
	    }

	    public List<Board> pagingList(Map<String, Integer> pagingParams) {
	        int limit = pagingParams.get("limit");
	        int offset = pagingParams.get("start");

	        String sql = "SELECT * FROM board_table ORDER BY id ASC LIMIT ? OFFSET ?";
	        return jdbcTemplate.query(sql, new Object[]{limit, offset}, new BoardRowMapper());
	    }

	    public int boardCount() {
	        String sql = "SELECT COUNT(*) FROM board_table";
	        return jdbcTemplate.queryForObject(sql, Integer.class);
	    }


}
