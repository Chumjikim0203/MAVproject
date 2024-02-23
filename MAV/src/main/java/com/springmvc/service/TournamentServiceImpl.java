package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Tournament;
import com.springmvc.repository.TournamentRepository;


@Service
public class TournamentServiceImpl implements TournamentService {
	
    @Autowired
    private TournamentRepository tournamentRepository;

    
	@Override
	public void setNewTournament(Tournament tournament) {
		
		
	 tournamentRepository.setTournament(tournament);
	}


	@Override
	public List<Tournament> getAlltournament(Tournament tournament) {
		
		return tournamentRepository.getAlltournament(tournament);
	}


	@Override
	public Tournament updateTournamentForm(int tournamentNum) {
		
		return tournamentRepository.getByNumUpdateRoom(tournamentNum);
	}

}
