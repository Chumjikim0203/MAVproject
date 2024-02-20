package com.springmvc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Match;


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

}