package com.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
<<<<<<< HEAD
       String sql = "INSERT INTO Matching (matchNum, roomNum,matchTitle ,memberId, matchStatus, matchResult) VALUES (?, ?, ?, ?, ?, ?)";
       
=======
       System.out.println("Roomnum : " + match.getRoomNum());
       Room room = match.getRoom();

       if (room == null) {
           room = new Room();
       }

       int roomNum = match.getRoomNum();
       System.out.println(roomNum + ": roomNum");
       room.setRoomNum(roomNum);
       room.setMatched(true); // isMatched 값 true


       String sqlUpdate = "UPDATE Room SET isMatched = ? WHERE roomNum = ?";

       jdbcTemplate.update(sqlUpdate,room.isMatched(),room.getRoomNum());
       
       String sql = "INSERT INTO Matching (matchNum, matchTitle, roomNum, creatorId, matchStatus, matchResult) VALUES (?, ?, ?, ?, ?, ?)";

>>>>>>> origin/KTY
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
<<<<<<< HEAD
   
=======

   // 매칭룸 전체 보여주기
>>>>>>> origin/KTY
   @Override
   public List<MatchRoom> findAllMatchRooms(MatchRoom matchroom) {
	    String sql = "SELECT m.matchNum, m.matchTitle, r.roomNum, m.matchStatus, m.matchResult, r.storeId, r.roomName, r.roomCapacity, r.roomCount, r.roomCategory, r.roomDetail, r.roomDate, r.roomTime FROM Matching m JOIN Room r ON m.roomNum = r.roomNum";
	    return jdbcTemplate.query(sql, new MatchRoomRowMapper());
	}

   //매칭룸 아이디별 보여주기
   @Override
   public List<MatchRoom> getMatchRoomsByStoreId(String storeId) {
	    String sql = "SELECT m.matchNum, m.matchTitle, r.roomNum, m.creatorId, m.applicantId,m.matchStatus, m.matchResult, r.storeId, r.roomName, r.roomCapacity, r.roomCount, r.roomCategory, r.roomDetail, r.roomDate, r.roomTime FROM Matching m JOIN Room r ON m.roomNum = r.roomNum";
	    return jdbcTemplate.query(sql, new MatchRoomRowMapper());
   }
   
   //룸넘버에따른 정보가지고 오기
   public MatchRoom getMatchByRoomNum(int roomNum) {
	    String sql = "SELECT m.matchNum, m.matchTitle, r.roomNum, m.creatorId, m.applicantId, m.matchStatus, m.matchResult, r.storeId, r.roomName, r.roomCapacity, r.roomCount, r.roomCategory, r.roomDetail, r.roomDate, r.roomTime FROM Matching m JOIN Room r ON m.roomNum = r.roomNum WHERE r.roomNum = ?";
	    
	    List<MatchRoom> matchRooms = jdbcTemplate.query(sql, new Object[]{roomNum}, new MatchRoomRowMapper());

	    if (matchRooms.isEmpty()) {
	        // 해당 방 번호에 매칭 정보가 없을 경우 null 반환하거나 다른 처리 수행 가능
	        return null;
	    } else {
	        // 리스트에서 첫 번째 요소를 반환
	        return matchRooms.get(0);
	    }
	}
   	
   
   //매칭 신청하기
	@Override
	public void applyMatch(Match match) {
		System.out.println(match.getRoomNum() + "match.getRoomNum()");
		String sql = "UPDATE Matching SET applicantId = ? WHERE roomNum = ?";
	    jdbcTemplate.update(sql, match.getApplicantId(), match.getRoomNum());
	    
	}



   
}