package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	{		
		club.setClubPoint(0);
		club.setClubMaster(member.getMemberId());
		String SQL = "insert into Club values(null,?,?,?,?,?,?,?)";
		template.update(SQL,
				club.getClubName(),
				club.getClubMaster(),
				club.getClubCategory(),
				club.getClubLocale(),
				club.getClubPoint(),
				club.getClubImages(),
				club.getClubInfo());
	}

	
	@Override
	public void addNewClubMember(Club club, ClubMember clubmember, Member member) 
	{
		clubmember.setClubGrade("동호회장");
		clubmember.setClubApprove(true);
		clubmember.setC_memberId(member.getMemberId());
		String SQL = "insert into clubmember values(?,?,?,?)";
		
		template.update(SQL, club.getClubName(),clubmember.getC_memberId(),
						clubmember.getClubGrade(),clubmember.isClubApprove());
		
		System.out.println("1 : "+clubmember.getC_memberId());
		System.out.println("2 : "+clubmember.getClubGrade());
		System.out.println("3 : "+clubmember.isClubApprove());
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

	
	
}
