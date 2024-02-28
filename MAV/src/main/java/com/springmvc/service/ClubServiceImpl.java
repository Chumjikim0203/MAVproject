package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Club;
import com.springmvc.domain.ClubMember;
import com.springmvc.domain.Member;
import com.springmvc.repository.ClubRepository;

@Service
public class ClubServiceImpl implements ClubService
{
	@Autowired
	private ClubRepository clubRepository;
	
	@Override
	public void addNewClub(Club club, Member member) 
	{
		clubRepository.addNewClub(club, member);
	}

	@Override
	public Club getByClubName(String clubName) 
	{
		
		Club getByClubName = clubRepository.getByClubName(clubName);
		return getByClubName;
	}
	@Override
	public void addNewClubMember(Club club, ClubMember clubmember, Member member) 
	{
		clubRepository.addNewClubMember(club, clubmember, member);
	}

	@Override
	public void updateClub(Club club) 
	{
		clubRepository.updateClub(club);
	}

	@Override
	public void deleteClub(String clubName) 
	{
		clubRepository.deleteClub(clubName);
	}

	@Override
	public void joinClub(Club club, Member member) 
	{
		clubRepository.joinClub(club, member);
	}

	@Override
	public List<Club> getAllClubList() 
	{
		List<Club> getAllClubList = clubRepository.getAllClubList();
		return getAllClubList;
	}

	@Override
	public Club getByClubNum(Club club) 
	{
		Club getByClubNum = clubRepository.getByClubNum(club);
		return getByClubNum;
	}

	@Override
	public List<Club> getMyClub(String c_memberId) 
	{
		return clubRepository.getMyClub(c_memberId);
	}

}
