package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Tournament;

public interface TournamentService {
   void setNewTournament(Tournament tournament);
   List<Tournament> getAlltournament(Tournament tournament);
   List<Tournament> getTournamentByStoreId(String StoreId); 
   Tournament updateTournamentForm(int tournamentNum);
   void changeTournament(Tournament tournament);
   void deleteTournament(int tournamentNum);
}
