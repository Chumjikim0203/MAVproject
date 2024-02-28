package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Club;
import com.springmvc.domain.ClubMember;
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
<<<<<<< HEAD
	{		
		club.setClubPoint(0);
		club.setClubMaster(member.getMemberId());
		String SQL = "insert into Club values(null,?,?,?,?,?,?,?)";
		template.update(SQL,
=======
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
>>>>>>> origin/PMS
				club.getClubName(),
				club.getClubMaster(),
				club.getClubCategory(),
				club.getClubLocale(),
<<<<<<< HEAD
				club.getClubPoint(),
				club.getClubImages(),
=======
				point,
				grade,
				approve,
>>>>>>> origin/PMS
				club.getClubInfo());
	}

	
	@Override
	public void addNewClubMember(Club club, ClubMember clubmember, Member member) 
	{
		clubmember.setClubGrade("동호회장");
		clubmember.setClubApprove(true);
		clubmember.setC_memberId(member.getMemberId());
		String SQL = "insert into clubmember values(?,?,?,?)";
		
<<<<<<< HEAD
		template.update(SQL, club.getClubName(),clubmember.getC_memberId(),
						clubmember.getClubGrade(),clubmember.isClubApprove());
		
		System.out.println("1 : "+clubmember.getC_memberId());
		System.out.println("2 : "+clubmember.getClubGrade());
		System.out.println("3 : "+clubmember.isClubApprove());
=======
>>>>>>> origin/PMS
	}

	@Override
	public List<Club> getByClubName(String clubName) 
	{
		List<Club> getByClubName = new ArrayList<Club>();
		String SQL = "select * from club where clubName LIKE '%'+clubName+'%'";
		getByClubName = template.query(SQL, new ClubRowMapper());
		return getByClubName;
	}

<<<<<<< HEAD
	
	@Override
	public void updateClub(Club club) 
	{
		System.out.println("수정 처리할 클럽ID : "+club.getClubNum());
		String SQL = "update Club set clubName=?, clubLocale=?, clubCategory=?, clubInfo=? where clubNum=?";
		template.update(SQL, club.getClubName(),club.getClubLocale(), club.getClubCategory(), 
						club.getClubInfo(), club.getClubNum());
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
	public void joinClub(Club club, ClubMember clubmember) 
	{
		club.setClubGrade("준회원");
		clubmember.setClubApprove(false);
		club.setClubPoint(0);
		club.setClubId(member.getMemberId());
		String SQL = "insert into Clubmember values(null,?,?,?,?,?,?,?,?)";
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

	@Override
	public List<Club> getMyClub(String c_memberId) {
	    List<Club> clubs = new ArrayList<>();

	    String SQL = "SELECT * " +
	                 "FROM clubmember cm INNER JOIN club c ON cm.clubname = c.clubname " +
	                 "WHERE cm.c_memberId = ?";

	    try {
	        clubs = template.query(SQL, new Object[]{c_memberId}, new ClubRowMapper());
	        return clubs;
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}

=======
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
>>>>>>> origin/PMS
	
	
}
