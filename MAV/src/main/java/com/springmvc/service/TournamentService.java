package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Tournament;

public interface TournamentService {
   void setNewTournament(Tournament tournament);
   List<Tournament> getAlltournament(Tournament tournament);
   Tournament updateTournamentForm(int tournamentNum);
}
