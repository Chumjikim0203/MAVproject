package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Member;

public interface MemberRepository 
{
	void setNewMember(Member member);
	List<Member> getAllMemberList();
	void updateMember(Member member);
	void deleteMember(String memberId);
	Member getById(String memberId);
	Member getLogin(String memberId, String memberPassword);
}
