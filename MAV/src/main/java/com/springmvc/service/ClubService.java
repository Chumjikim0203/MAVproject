package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Club;
import com.springmvc.domain.ClubMember;
import com.springmvc.domain.Member;

public interface ClubService 
{

	void addNewClub(Club club,Member member);
	void joinClub(Club club, ClubMember clubmember, Member member);
	Club getByClubName(String clubName);
	List<Club> getAllClubList();
	void addNewClubMember(Club club,ClubMember clubmember, Member member);
	Club getByClubNum(Club club);
	void updateClub(Club club,Member member);
	void deleteClub(String clubName,String c_memberId);
	List<Club> getMyClub(String c_memberId);
	ClubMember getMyClubMember(String c_memberId, String clubName);
	void leaveClub(String clubName, String c_memberId);
	List<ClubMember> getClubMemberList(String clubName);
	void ejectionMember(String ClubName, String c_memberId);

}
