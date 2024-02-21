package com.springmvc.domain;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class Classes
{
	private int classNum; // 클래스 번호
	private String classId; // 클래스 아이디
	private String className; // 클래스 이름
	@DateTimeFormat(pattern="HH:mm")
	private String classLecturetime; // 강의 시간
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate classLecturedate; // 강의 날짜
	private int classNumberOfStudents; // 강의 수강 인원
	private String classCourseContents; // 강의 수강 내용
	private String classGrade; // 강의 등급
	private String classIntroduction; // 강의 소개글
	private String fileName;
	private MultipartFile classImages; // 강의 이미지(경로)dto한개 생성
	private String classLocale; // 강의 지역
	private boolean classApprove; // 강의 신청 승인
	
	
	
	

	public Classes() {
		super();
	this.classId="1";
		// TODO Auto-generated constructor stub
	}
	public Classes(String className) {
		super();
		this.className = className;
		
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public boolean isClassApprove() {
		return classApprove;
	}
	public void setClassApprove(boolean classApprove) {
		this.classApprove = classApprove;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassLecturetime() {
		return classLecturetime;
	}
	public void setClassLecturetime(String classLecturetime) {
		this.classLecturetime = classLecturetime;
	}
	public LocalDate getClassLecturedate() {
		return classLecturedate;
	}
	public void setClassLecturedate(LocalDate classLecturedate) {
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
