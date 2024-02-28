package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
		
		club.setClubGrade("동호회장");
		club.setClubApprove(true);
		club.setClubPoint(0);
		club.setClubId(member.getMemberId());
		String SQL = "insert into Club values(null,?,?,?,?,?,?,?,?)";
		template.update(SQL,
				club.getClubId(),
				club.getClubName(),
				club.getClubCategory(),
				club.getClubLocale(),
				club.getClubPoint(),
				club.getClubGrade(),
				club.isClubApprove(),
				club.getClubInfo());
		
		System.out.println("1:"+ member.getMemberId());
		System.out.println("2:"+ club.getClubName());
		System.out.println("3 :"+club.getClubPoint());
		System.out.println("4 :"+club.getClubLocale());
		System.out.println("5 :"+club.getClubGrade());
		System.out.println("6 :"+club.isClubApprove());
	}

	@Override
	public Club getByClubName(String clubName) {
	    String SQL = "SELECT * FROM club WHERE clubName=?";
	    Club club = null;
	    try {
	        club = template.queryForObject(SQL, new Object[]{clubName}, new ClubRowMapper());
	    } catch (EmptyResultDataAccessException ex) {
	        // 클럽을 찾을 수 없는 경우 예외 처리
	        // 이 부분을 적절하게 처리해야 합니다.
	    }
	    return club;
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

	
	@Override
	public void updateClub(Club club) 
	{
		System.out.println("수정 처리할 클럽ID : "+club.getClubId());
		String SQL = "update Club set clubName=?, clubLocale=?, clubCategory=?, clubInfo=? where clubId=?";
		template.update(SQL, club.getClubName(),club.getClubLocale(), club.getClubCategory(), 
						club.getClubInfo(), club.getClubId());
	}

	@Override
	public void deleteClub(String clubName) 
	{
		String SQL = "delete from club where clubName=?";
		this.template.update(SQL, clubName);
	}

	@Override
	public Club getClubInfo(Club club) 
	{
		String SQL = "select * from club where clubNum=? and clubName=?";
		template.update(SQL, club.getClubNum(), club.getClubName());
		return club;
	}

	@Override
	public void joinClub(Club club, Member member) 
	{
		club.setClubGrade("준회원");
		club.setClubApprove(false);
		club.setClubPoint(0);
		club.setClubId(member.getMemberId());
		String SQL = "insert into Club values(null,?,?,?,?,?,?,?,?)";
		template.update(SQL,
				club.getClubId(),
				club.getClubName(),
				club.getClubCategory(),
				club.getClubLocale(),
				club.getClubPoint(),
				club.getClubGrade(),
				club.isClubApprove(),
				club.getClubInfo());
	}

	@Override
	public List<Club> getAllClubList() 
	{
		String SQL = "select * from Club";
		List<Club> getAllClubList = template.query(SQL, new ClubRowMapper());
		return getAllClubList;
	}

	@Override
	public Club getByClubNum(Club club) 
	{		
		String SQL = "select * from club where clubNum=?";
		 Club getByClubNum = (Club) template.queryForObject(SQL, new Object[] {club.getClubNum()}, new ClubRowMapper());
		 return getByClubNum;
	}
	
	
}
