package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Match;
import com.springmvc.domain.MatchRoom;
import com.springmvc.repository.MatchRepository;

@Service
public class MatchServiceImpl implements MatchService {
	
	@Autowired
	private MatchRepository matchRepository;
	
	@Override
	public void matchCreate(Match match) {
		matchRepository.matchCreate(match);
		
	}

	@Override
	public List<MatchRoom> findAllMatchRooms(MatchRoom matchroom) {
		return 	matchRepository.findAllMatchRooms(matchroom);

	}

}
