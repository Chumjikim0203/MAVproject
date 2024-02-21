package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Match;
import com.springmvc.domain.MatchRoom;

public interface MatchService {
	void matchCreate(Match match); 	
	List<MatchRoom> findAllMatchRooms(MatchRoom matchroom);

}
