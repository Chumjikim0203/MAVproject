package com.springmvc.repository;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Match;
import com.springmvc.domain.Room;
import com.springmvc.domain.Tournament;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TournamentRowMapper implements RowMapper<Tournament> {
   
    public Tournament mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tournament tournament = new Tournament();
        tournament.setTournamentNum(rs.getInt("tournamentNum"));
        tournament.setStoreId(rs.getString("storeId"));
        tournament.setTournamentReward(rs.getInt("tournamentReward"));
        tournament.setTournamentPrice(rs.getInt("tournamentPrice"));
        tournament.setMax_participants(rs.getInt("max_participants"));
        tournament.setTournamentDate(rs.getDate("tournamentDate").toLocalDate());
        tournament.setTournamentTime(rs.getTime("tournamentTime").toLocalTime());
        return tournament;
    }
}


