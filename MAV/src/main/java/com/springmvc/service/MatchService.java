package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Match;
import com.springmvc.domain.MatchRoom;

public interface MatchService {
	int matchCreate(Match match); 	
	List<MatchRoom> findAllMatchRooms(MatchRoom matchroom);
<<<<<<< HEAD

=======
	List<MatchRoom> getMatchRoomsByStoreId(String storeId);
	MatchRoom getMatchByRoomNum(int roomNum);
	void applyMatch(Match match);
>>>>>>> origin/KTY
}
