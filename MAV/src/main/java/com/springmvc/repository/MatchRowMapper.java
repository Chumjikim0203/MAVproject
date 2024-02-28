package com.springmvc.repository;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Match;

public class MatchRowMapper implements RowMapper<Match> {

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
}
