package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Member;

public interface MemberRepository 
{
	void setNewMember(Member member);
	Member getMyInfo(Member member);
	void updateMember(Member member);
}
