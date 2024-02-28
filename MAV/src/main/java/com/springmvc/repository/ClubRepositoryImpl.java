package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Club;
import com.springmvc.domain.Member;
import com.springmvc.exception.MemberIdException;

@Repository
public class ClubRepositoryImpl implements ClubRepository 
{

	private JdbcTemplate template;
	
	private List<Club> listOfClubs = new ArrayList<Club>();
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource)
	{
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void addNewClub(Club club, Member member) 
	{
		
		String grade = "동호회장";
		boolean approve = true;
		int point = 0;
		System.out.println("1:"+ member.getMemberId());
		System.out.println("2:"+ club.getClubName());
		String SQL = "insert into Club values(null,?,?,?,?,?,?,?,?,?)";
		template.update(SQL,
				member.getMemberId(),
				member.getMemberId(),
				club.getClubName(),
				club.getClubCategory(),
				club.getClubLocale(),
				point,
				grade,
				approve,
				club.getClubInfo());
		
	}

	@Override
	public List<Club> getByClubName(String clubName) 
	{
		List<Club> getByClubName = new ArrayList<Club>();
		String SQL = "select * from club where clubName LIKE '%'+clubName+'%'";
		getByClubName = template.query(SQL, new ClubRowMapper());
		return getByClubName;
	}

	@Override
	public Club getByClubId(String clubId) 
	{
		Club clubInfo = null;
		String SQL = "SELECT count(*) FROM Club where clubId=?";
		int rowCount = template.queryForObject(SQL, Integer.class, clubId);
		if(rowCount!=0)
		{
			SQL = "SELECT * FROM Club where clubId=?";
			clubInfo = template.queryForObject(SQL, new Object[] {clubId}, new ClubRowMapper());
		}
		for(int i=0; i<listOfClubs.size(); i++)
		{
			Club club=listOfClubs.get(i);
			if(club!=null && club.getClubId()!= null && club.getClubId().equals(clubId))
			{
				clubInfo=club;
				break;
			}
		}
		if(clubInfo==null)
		{
			throw new MemberIdException(clubId);
		}
		return clubInfo;
	}
	
	
}
