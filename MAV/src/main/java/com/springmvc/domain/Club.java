package com.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class Club 
{
	private int clubNum; // 클럽 넘버
	private String clubId; // 동호회아이디
	private String clubName; // 동호회명
	private int clubPoint; // 동호회 포인트
	private String clubGrade; // 동호회원 등급
	private String clubInfo; // 동호회 소개글
	private MultipartFile clubImages; // 동호회 이미지
	
	
	
	public int getClubNum() {
		return clubNum;
	}
	public void setClubNum(int clubNum) {
		this.clubNum = clubNum;
	}
	public String getClubId() {
		return clubId; 
	}
	public void setClubId(String clubId) {
		this.clubId = clubId;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public int getClubPoint() {
		return clubPoint;
	}
	public void setClubPoint(int clubPoint) {
		this.clubPoint = clubPoint;
	}
	public String getClubGrade() {
		return clubGrade;
	}
	public void setClubGrade(String clubGrade) {
		this.clubGrade = clubGrade;
	}
	public MultipartFile getClubImages() {
		return clubImages;
	}
	public void setClubImages(MultipartFile clubImages) {
		this.clubImages = clubImages;
	}
	public String getClubInfo() {
		return clubInfo;
	}
	public void setClubInfo(String clubInfo) {
		this.clubInfo = clubInfo;
	}
	
}
