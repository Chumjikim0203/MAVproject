package com.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class Teacher 
{
	private long teacherId; // 강사 아이디
	private MultipartFile teacherImages; // 강사 이미지
	private String teacherCategory; // 강사 종류
	private String teacherRecode; // 강사 이력
	private String teacherLicense; // 강사 자격증
	private String teacherInfomation; // 강사 소개 
	
	public String getTeacherInfomation() {
		return teacherInfomation;
	}
	public void setTeacherInfomation(String teacherInfomation) {
		this.teacherInfomation = teacherInfomation;
	}
	public long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(long teacherId) { 
		this.teacherId = teacherId;
	}
	public MultipartFile getTeacherImages() {
		return teacherImages;
	}
	public void setTeacherImages(MultipartFile teacherImages) {
		this.teacherImages = teacherImages;
	}
	public String getTeacherCategory() {
		return teacherCategory;
	}
	public void setTeacherCategory(String teacherCategory) {
		this.teacherCategory = teacherCategory;
	}
	public String getTeacherRecode() {
		return teacherRecode;
	}
	public void setTeacherRecode(String teacherRecode) {
		this.teacherRecode = teacherRecode;
	}
	public String getTeacherLicense() {
		return teacherLicense;
	}
	public void setTeacherLicense(String teacherLicense) {
		this.teacherLicense = teacherLicense;
	}
	
	
}
