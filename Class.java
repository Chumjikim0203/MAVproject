package com.springmvc.domain;

import java.sql.Time;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Class // 강사 전화번호를 개인회원 전화번호로 당겨올거 같아서 아직 getter/setter 하지 않음 회의 후 결정할것 
{
	private String classId; // 클래스아이디
	private Time classLecturetime; // 강의 시간
	private Date classLecturedate; // 강의 날짜
	private int classNumberOfStudents; // 강의 수강 인원
	private String classCourseContents; // 강의 수강 내용
	private String classGrade; // 강의 등급
	private String classIntroduction; // 강의 소개글
	private MultipartFile classImages; // 강의 이미지
	private String classLocale; // 강의 지역
	private int classPhone01; // 강사 전화번호 첫번째
	private int classPhone02; // 강사 전화번호 두번째
	private int classPhone03; // 강사 전화번호 세번째
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public Time getClassLecturetime() {
		return classLecturetime;
	}
	public void setClassLecturetime(Time classLecturetime) {
		this.classLecturetime = classLecturetime;
	}
	public Date getClassLecturedate() {
		return classLecturedate;
	}
	public void setClassLecturedate(Date classLecturedate) {
		this.classLecturedate = classLecturedate;
	}
	public int getClassNumberOfStudents() {
		return classNumberOfStudents;
	}
	public void setClassNumberOfStudents(int classNumberOfStudents) {
		this.classNumberOfStudents = classNumberOfStudents;
	}
	public String getClassCourseContents() {
		return classCourseContents;
	}
	public void setClassCourseContents(String classCourseContents) {
		this.classCourseContents = classCourseContents;
	}
	public String getClassGrade() {
		return classGrade;
	}
	public void setClassGrade(String classGrade) {
		this.classGrade = classGrade;
	}
	public String getClassIntroduction() {
		return classIntroduction;
	}
	public void setClassIntroduction(String classIntroduction) {
		this.classIntroduction = classIntroduction;
	}
	public MultipartFile getClassImages() {
		return classImages;
	}
	public void setClassImages(MultipartFile classImages) {
		this.classImages = classImages;
	}
	public String getClassLocale() {
		return classLocale;
	}
	public void setClassLocale(String classLocale) {
		this.classLocale = classLocale;
	}
	
	
}
