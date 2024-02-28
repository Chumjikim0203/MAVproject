package com.springmvc.repository;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Match;

public class MatchRowMapper implements RowMapper<Match> {

<<<<<<< HEAD
   @Override
   public Match mapRow(ResultSet resultSet, int rowNum) throws SQLException {
       Match match = new Match();
       match.setMatchNum(resultSet.getInt("matchNum"));
       match.setRoomNum(resultSet.getInt("roomNum"));
       match.setMatchTitle(resultSet.getString("matchTiltle"));
       match.setMemberId(resultSet.getString("memberId"));
       match.setMatchStatus(resultSet.getString("matchStatus"));
       match.setMatchResult(resultSet.getString("matchResult"));
       
       return match;
   }
=======
	@Override
	public Match mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Room room = new Room();
	    Match match = new Match();
	    match.setMatchNum(rs.getInt("matchNum"));
	    match.setMatchTitle(rs.getString("matchTitle"));
	    match.setRoomNum(rs.getInt("roomNum"));
	    match.setCreatorId(rs.getString("creatorId"));
	    match.setApplicantId(rs.getString("applicantId"));
	    match.setMatchStatus(rs.getString("matchStatus"));
	    match.setMatchResult(rs.getString("matchResult"));

	    boolean isMatched = rs.getBoolean("isMatched");
	    room.setMatched(isMatched);

	    match.setRoom(room);

	    return match;
	}


>>>>>>> origin/KTY
}
