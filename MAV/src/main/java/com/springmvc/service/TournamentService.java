package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Tournament;

public interface TournamentService {
   void setNewTournament(Tournament tournament);
   List<Tournament> getAlltournament(Tournament tournament);
<<<<<<< HEAD
   Tournament updateTournamentForm(int tournamentNum);
=======
   List<Tournament> getTournamentByStoreId(String StoreId); 
   Tournament updateTournamentForm(int tournamentNum);
   void changeTournament(Tournament tournament);
   void deleteTournament(int tournamentNum);
>>>>>>> 6f8e02927c668559c23d378e1cd5decd4cefd5ba
}
