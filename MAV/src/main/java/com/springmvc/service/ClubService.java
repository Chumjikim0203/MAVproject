package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Club;
import com.springmvc.domain.Member;

public interface ClubService 
{
	void addNewClub(Club club, Member member);
	List<Club> getByClubName(String clubName);
	Club getByClubId(String clubId);
}
