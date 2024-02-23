package com.springmvc.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Tournament;

@Repository
public class TournamentRepositoryImpl implements TournamentRepository {
	
	@Autowired
	private final JdbcTemplate jdbcTemplate;
	
    public TournamentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
    
    //토너먼트 만들기
	@Override
	public void setTournament(Tournament tournament) {
		String sql = "insert into Tournament ( storeId, tournamentReward, tournamentPrice, max_participants,tournamentDate,tournamentTime)"+
				"VALUES ( ?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(
				sql,
				tournament.getStoreId(),
				tournament.getTournamentReward(),
				tournament.getTournamentPrice(),
				tournament.getMax_participants(),
				tournament.getTournamentDate(),
				tournament.getTournamentTime()
				
				
				);
		
		
	}

	//룸 전체를 들고오는거
	@Override
	public List<Tournament> getAlltournament(Tournament tournament) {
		String sql = "select*from Tournament";
		return jdbcTemplate.query(sql, new TournamentRowMapper());
	}

	//룸 넘버에 맞는 룸 가지고 오기
	@Override
	public Tournament getByNumUpdateRoom(int tournamentNum) {
		
		String sql = "select * from Tournament where tournamentNum = ?";
		return jdbcTemplate.queryForObject(sql, new TournamentRowMapper(),tournamentNum);
	}
	
	

}
