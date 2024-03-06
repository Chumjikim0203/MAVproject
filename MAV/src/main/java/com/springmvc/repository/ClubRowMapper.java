package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Club;

public class ClubRowMapper implements RowMapper<Club> 
{

	@Override
	public Club mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Club club = new Club();
		
		
		club.setClubCategory(rs.getString("clubCategory"));
		club.setImageFileName(rs.getString("imageFileName"));
		club.setClubInfo(rs.getString("clubInfo"));
		club.setClubLocale(rs.getString("clubLocale"));
		club.setClubName(rs.getString("clubName"));
		club.setClubNum(rs.getInt("clubNum"));
		club.setClubPoint(rs.getInt("clubPoint"));
		club.setClubMaster(rs.getString("clubMaster"));
		
		return club;
	}
	
}
