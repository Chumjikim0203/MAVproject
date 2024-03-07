package com.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class Club 
{
	private int clubNum; // 클럽 넘버
	private String clubName; // 동호회명
	private String clubMaster; // 동호회장 아이디
	private int clubPoint; // 동호회 포인트
	private String clubCategory; // 동호회 종류
	private String clubInfo; // 동호회 소개글
	private String clubLocale; // 동호회 활동지역
	private MultipartFile clubImages; // 동호회 이미지
	private String imageFileName; // 이미지 파일 이름
	
	
	public Club() {}
	
	public int getClubNum() {
		return clubNum;
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

	public String getClubCategory() {
		return clubCategory;
	}

	public void setClubCategory(String clubCategory) {
		this.clubCategory = clubCategory;
	}
<<<<<<< HEAD
=======

>>>>>>> origin/KTY
	public String getClubInfo() {
		return clubInfo;
	}

	public void setClubInfo(String clubInfo) {
		this.clubInfo = clubInfo;
	}

	public String getClubLocale() {
		return clubLocale;
	}

	public void setClubLocale(String clubLocale) {
		this.clubLocale = clubLocale;
	}

	public MultipartFile getClubImages() {
		return clubImages;
	}

	public void setClubImages(MultipartFile clubImages) {
		this.clubImages = clubImages;
	}

	public void setClubNum(int clubNum) {
		this.clubNum = clubNum;
	}

	public String getClubMaster() {
		return clubMaster;
	}

	public void setClubMaster(String clubMaster) {
		this.clubMaster = clubMaster;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
}
