package com.springmvc.repository;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Match;
import com.springmvc.domain.Room;

public class MatchRowMapper implements RowMapper<Match> {

	@Override
	public Match mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Room room = new Room();
	    Match match = new Match();
	    match.setMatchNum(rs.getInt("matchNum"));
<<<<<<< HEAD
	    match.setMatchTitle(rs.getString("matchTiltle"));
	    match.setRoomNum(rs.getInt("roomNum"));
	    match.setCreatorId(rs.getString("creatorId"));
	    match.setApplicantId(rs.getString("applicantId"));
	    match.setMemberId(rs.getString("memberId"));
=======
	    match.setMatchTitle(rs.getString("matchTitle"));
	    match.setRoomNum(rs.getInt("roomNum"));
	    match.setCreatorId(rs.getString("creatorId"));
	    match.setApplicantId(rs.getString("applicantId"));
>>>>>>> 6f8e02927c668559c23d378e1cd5decd4cefd5ba
	    match.setMatchStatus(rs.getString("matchStatus"));
	    match.setMatchResult(rs.getString("matchResult"));

	    boolean isMatched = rs.getBoolean("isMatched");
	    room.setMatched(isMatched);

	    match.setRoom(room);

	    return match;
	}

<<<<<<< HEAD

=======
>>>>>>> 6f8e02927c668559c23d378e1cd5decd4cefd5ba
}

