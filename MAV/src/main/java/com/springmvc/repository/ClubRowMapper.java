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
		
		club.setClubApprove(rs.getBoolean("clubApprove"));
		club.setClubCategory(rs.getString("clubCategory"));
		club.setClubGrade(rs.getString("clubGrade"));
		club.setClubId(rs.getString("clubId"));
		club.setClubInfo(rs.getString("clubInfo"));
		club.setClubLocale(rs.getString("clubLocale"));
		club.setClubName(rs.getString("clubName"));
		club.setClubNum(rs.getInt("clubNum"));
		club.setClubPoint(rs.getInt("clubPoint"));
		
		return club;
	}
	
}
