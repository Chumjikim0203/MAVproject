package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Club;
import com.springmvc.domain.ClubMember;
import com.springmvc.domain.Member;

public interface ClubRepository 
{
	void addNewClub(Club club, Member member);
<<<<<<< HEAD
	void addNewClubMember(Club club,ClubMember clubmember, Member member);
	void joinClub(Club club, ClubMember clubmember);
	List<Club> getAllClubList();
	Club getByClubName(String clubName);
	Club getByClubNum(Club club);
	Club getClubInfo(Club club);
	List<Club> getMyClub(String c_memberId);
=======
	void joinClub(Club club, Member member);
	List<Club> getAllClubList();
	Club getByClubName(String clubName);
	Club getByClubNum(Club club);
	Club getByClubId(String clubId);
	Club getClubInfo(Club club);
>>>>>>> origin/KTY
	void updateClub(Club club);
	void deleteClub(String clubName);
}
