package com.springmvc.domain;

import java.time.LocalDate;

import javax.validation.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;

public class Member 
{
	private String memberId; // 멤버 ID
	private String memberPassword; // 멤버 비밀번호
	private String memberName; // 멤버 이름
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate memberBirth; // 멤버 생년월일	
	private String viewBirth; // 보여주기위한 임시 생년월일
	private String memberAddr; // 멤버 주소
	private String memberPhone01; // 멤버 핸드폰 첫번째
	private String memberPhone02; // 멤버 핸드폰 두번째
	private String memberPhone03; // 멤버 핸드폰 세번째
	private String memberGender; // 멤버 성별
	private String memberEmail; // 멤버 이메일
	private boolean memberTeacherApprove; // 강사 신청 승인
	private boolean memberStoreApprove; // 업체 신청 승인
	private boolean memberClubMemberApprove; // 동호회원 신청 승인
	private boolean memberClubApprove; // 동호회 신청 승인

	
	public Member()
	{
		
	}

	public String getViewBirth() {
		return viewBirth;
	}


	public void setViewBirth(String viewBirth) {
		this.viewBirth = viewBirth;
	}


	public boolean isMemberTeacherApprove() {
		return memberTeacherApprove;
	}
	public void setMemberTeacherApprove(boolean memberTeacherApprove) {
		this.memberTeacherApprove = memberTeacherApprove;
	}
	public boolean isMemberStoreApprove() {
		return memberStoreApprove;
	}
	public void setMemberStoreApprove(boolean memberStoreApprove) {
		this.memberStoreApprove = memberStoreApprove;
	}
	public boolean isMemberClubApprove() {
		return memberClubApprove;
	}
	public void setMemberClubApprove(boolean memberClubApprove) {
		this.memberClubApprove = memberClubApprove;
	}
	public boolean ismemberClubMemberApprove() {
		return memberClubMemberApprove;
	}
	public void setmemberClubMemberApprove(boolean memberClubManagerApprove) {
		this.memberClubMemberApprove = memberClubManagerApprove;
	}
	public String getMemberId()  
	{
		return memberId;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public LocalDate getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(LocalDate memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getMemberPhone01() {
		return memberPhone01;
	}
	public void setMemberPhone01(String memberPhone01) {
		this.memberPhone01 = memberPhone01;
	}
	public String getMemberPhone02() {
		return memberPhone02;
	}
	public void setMemberPhone02(String memberPhone02) {
		this.memberPhone02 = memberPhone02;
	}
	public String getMemberPhone03() {
		return memberPhone03;
	}
	public void setMemberPhone03(String memberPhone03) {
		this.memberPhone03 = memberPhone03;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	
}
