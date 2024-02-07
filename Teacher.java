package com.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class Teacher 
{
	private String teacherId; // 강사 아이디
	private MultipartFile teacherImages; // 강사 이미지
	private String teacherCategory; // 강사 종류
	private String teacherRecode; // 강사 이력
	private String teacherLicense; // 강사 자격증
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) { 
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
