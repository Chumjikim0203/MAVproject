package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Tournament;

public interface TournamentRepository {
	
	void setTournament(Tournament tournament);
	List<Tournament> getAlltournament(Tournament tournament);
	Tournament getByNumUpdateRoom(int tournamentNum);
}
