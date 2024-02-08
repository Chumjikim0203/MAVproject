package com.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class Club 
{
	private long clubId; // 동호회아이디
	private String clubName; // 동호회명
	private int clubPoint; // 동호회 포인트
	private String clubGrade; // 동호회원 등급
	private MultipartFile clubImages; // 동호회 이미지
	
	public long getClubId() {
		return clubId; 
	}
	public void setClubId(long clubId) {
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

	
}
