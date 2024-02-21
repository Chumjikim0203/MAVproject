package com.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Match;
import com.springmvc.domain.MatchRoom;
import com.springmvc.domain.MatchRoom;
import com.springmvc.repository.MatchRoomRowMapper;


@Repository 
public class MatchRepositoryImpl implements MatchRepository {
   
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public MatchRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
   public MatchRepositoryImpl() {
   }
   
   
   @Override
   public void matchCreate(Match match) {
       String sql = "INSERT INTO Matching (matchNum, roomNum,matchTitle ,memberId, matchStatus, matchResult) VALUES (?, ?, ?, ?, ?, ?)";
       
       jdbcTemplate.update(
           sql,
           match.getMatchNum(), // 오토인트리먼트 부분
           match.getRoomNum(),
           match.getMatchTitle(),
           match.getMemberId(),
           match.getMatchStatus(),
           match.getMatchResult()
       ); 
      
   }
   
   @Override
   public List<MatchRoom> findAllMatchRooms(MatchRoom matchroom) {
	    String sql = "SELECT m.matchNum, m.matchTitle, r.roomNum, m.matchStatus, m.matchResult, r.storeId, r.roomName, r.roomCapacity, r.roomCount, r.roomCategory, r.roomDetail, r.roomDate, r.roomTime FROM Matching m JOIN Room r ON m.roomNum = r.roomNum";
	    return jdbcTemplate.query(sql, new MatchRoomRowMapper());
	}

   
}