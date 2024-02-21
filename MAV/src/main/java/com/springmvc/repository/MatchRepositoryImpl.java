package com.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Match;
import com.springmvc.domain.MatchRoom;
import com.springmvc.domain.Room;


@Repository 
public class MatchRepositoryImpl implements MatchRepository {
   
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public MatchRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
   public MatchRepositoryImpl() {
   }

   
   //매칭룸을 만드는 로직
   @Override
   public void matchCreate(Match match) {
	   System.out.println("Roomnum : "+ match.getRoomNum());
	    Room room = match.getRoom();
	    
	      if (room == null) {
	            room = new Room();
	            room.setMatched(true);
	           System.out.println("boolean : "+room.isMatched());
	     	
	        }
	        
	   
	    String sqlUpdateRoom = "UPDATE Room SET isMatched = ? WHERE roomNum = ?";
	    
	    
	    System.out.println(room+ "이건뭐니?");

  
        jdbcTemplate.update(
            sqlUpdateRoom,
            room.isMatched(),
            room.getRoomNum()
        );
	   
	   
       String sql = "INSERT INTO Matching (matchNum, matchTitle, roomNum, creatorId, matchStatus, matchResult) VALUES (?, ?, ?, ?, ?, ?)";
             
       jdbcTemplate.update(
           sql,
           match.getMatchNum(),
           match.getMatchTitle(),
           match.getRoomNum(),
           match.getCreatorId(),
           match.getMatchStatus(),
           match.getMatchResult()

       ); 
      
   }
   
   @Override
   public List<MatchRoom> findAllMatchRooms(MatchRoom matchroom) {
	    String sql = "SELECT m.matchNum, m.matchTitle, r.roomNum, m.creatorId, m.applicantId,m.matchStatus, m.matchResult, r.storeId, r.roomName, r.roomCapacity, r.roomCount, r.roomCategory, r.roomDetail, r.roomDate, r.roomTime FROM Matching m JOIN Room r ON m.roomNum = r.roomNum";
	    return jdbcTemplate.query(sql, new MatchRoomRowMapper());
	}

   
}