package com.springmvc.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository 
{
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource)
	{
		this.template = new JdbcTemplate(dataSource);
	}
	
	private List<Member> listOfMembers = new ArrayList<Member>();
	
	@Override
	public void setNewMember(Member member) 
	{
		String SQL = "insert into Member"
				+ "(memberId, memberName, memberPassword, memberBirth, memberAddr, memberPhone01, memberPhone02, memberPhone03, "
				+ "memberGender, memberEmail, memberTeacherApprove, memberStoreApprove, memberClubApprove, memberClubMemberApprove)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
		template.update(SQL, member.getMemberId(),member.getMemberName(), member.getMemberPassword(), member.getMemberBirth(), member.getMemberAddr()
				        , member.getMemberPhone01(), member.getMemberPhone02(), member.getMemberPhone03(), member.getMemberGender()
				        , member.getMemberEmail(), member.isMemberTeacherApprove(), member.isMemberStoreApprove(),member.isMemberClubApprove()
				        , member.ismemberClubMemberApprove());
	}
	
	

	@Override
	public Member getMyInfo(Member member) 
	{
	
		return member;
	}



	@Override
	public void updateMember(Member member) 
	{
		String SQL = "update Member set memberPassword=? memberBirth=? ,memberPhone01=?, memberPhone02=? memberPhone03=?,memberGender=?, memberName=?,"
				   + "memberEmail=?, memberAddr=? where memberId=?";
		
		template.update(SQL, member.getMemberPassword() , member.getMemberBirth(), member.getMemberPhone01(), member.getMemberPhone02(), member.getMemberPhone03(), 
				        member.getMemberGender(), member.getMemberEmail(), member.getMemberAddr(), member.getMemberId());		
	}	
}
