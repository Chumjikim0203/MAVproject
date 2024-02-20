package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Club;
import com.springmvc.domain.Member;

public interface ClubRepository 
{
	void addNewClub(Club club, Member member);
	List<Club> getByClubName(String clubName);
	Club getByClubId(String clubId);
}
