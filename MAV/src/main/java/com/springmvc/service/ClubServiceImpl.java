package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Club;
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
	public List<Club> getByClubName(String clubName) 
	{
		
		List<Club> getByClubName = clubRepository.getByClubName(clubName);
		return getByClubName;
	}

	@Override
	public Club getByClubId(String clubId) 
	{
		Club getByClubId = clubRepository.getByClubId(clubId);
		return getByClubId;
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
	
}
