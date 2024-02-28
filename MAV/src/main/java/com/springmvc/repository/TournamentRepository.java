package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Tournament;

public interface TournamentRepository {
	
	
	//create
	//토너먼트 입력
	void setTournament(Tournament tournament);
	
	
	//Read
	//모든 토너먼트 리드
	List<Tournament> getAlltournament(Tournament tournament);
	//스토어 아이디별 리드
	 List<Tournament> getTournamentByStoreId(String StoreId);
	//update
	//토너먼트 업데이트하기위해 리드
	Tournament getByNumUpdateRoom(int tournamentNum);
	//토너먼트 업데이트
	void changeTournament(Tournament tournament);
	
	//delete
	//토너먼트 삭제
	 void deleteTournament(int tournamentNum);
}

