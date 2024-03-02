package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Club;
import com.springmvc.domain.ClubMember;
import com.springmvc.domain.Member;

public interface ClubRepository 
{
	void addNewClub(Club club, Member member);
	void addNewClubMember(Club club,ClubMember clubmember, Member member);
<<<<<<< HEAD
	void joinClub(Club club, ClubMember clubmember, Member member);
=======
	void joinClub(Club club, ClubMember clubmember);
>>>>>>> 0ecc706b0705039adf0b76598156110dce22af29
	List<Club> getAllClubList();
	Club getByClubName(String clubName);
	Club getByClubNum(Club club);
	Club getClubInfo(Club club);
	List<Club> getMyClub(String c_memberId);
<<<<<<< HEAD
	void updateClub(Club club, Member member);
	void deleteClub(String clubName ,String c_memberId);
	ClubMember getMyClubMember(String c_memberId,String clubName);
	void leaveClub(String clubName, String c_memberId);
	List<ClubMember> getClubMemberList(String clubName);
	void ejectionMember(String ClubName, String c_memberId);
	void memberUpdate(ClubMember clubmember);
	ClubMember serchingC_member(String c_memberId, String clubName);
=======
	void updateClub(Club club);
	void deleteClub(String clubName);
>>>>>>> 0ecc706b0705039adf0b76598156110dce22af29
}
