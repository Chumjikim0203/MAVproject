package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Club;
import com.springmvc.domain.ClubMember;
import com.springmvc.domain.Member;

public interface ClubService 
{
<<<<<<< HEAD
	void addNewClub(Club club,Member member);
	void joinClub(Club club, Member member);
	Club getByClubName(String clubName);
	List<Club> getAllClubList();
	void addNewClubMember(Club club,ClubMember clubmember, Member member);
	Club getByClubNum(Club club);
	void updateClub(Club club);
	void deleteClub(String clubName);
	List<Club> getMyClub(String c_memberId);
=======
	void addNewClub(Club club, Member member);
	void joinClub(Club club, Member member);
	Club getByClubName(String clubName);
	List<Club> getAllClubList();
	Club getByClubId(String clubId);
	Club getByClubNum(Club club);
	void updateClub(Club club);
	void deleteClub(String clubName);
>>>>>>> origin/KTY
}
