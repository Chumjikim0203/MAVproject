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
<<<<<<< HEAD
		
		
=======
>>>>>>> 6f8e02927c668559c23d378e1cd5decd4cefd5ba
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

<<<<<<< HEAD
=======
    //업데이트 된 것 데이터베이스 저장
	@Override
	public void changeTournament(Tournament tournament) {
		tournamentRepository.changeTournament(tournament);	
	}


	@Override
	public void deleteTournament(int tournamentNum) {
		
		tournamentRepository.deleteTournament(tournamentNum);
	}


	@Override
	public List<Tournament> getTournamentByStoreId(String StoreId) {
		return tournamentRepository.getTournamentByStoreId(StoreId);
	}

>>>>>>> 6f8e02927c668559c23d378e1cd5decd4cefd5ba
}
