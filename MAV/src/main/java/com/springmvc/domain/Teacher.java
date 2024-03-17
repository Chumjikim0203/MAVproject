package com.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class Teacher 
{
   private String teacherId; // 강사 아이디
   private MultipartFile teacherImages; // 강사 이미지
   private String teacherimageFileName;  //이미지 파일이름
   private String teacherCategory; // 강사 종류
   private String teacherRecode; // 강사 이력
   private MultipartFile teacherLicense1; // 강사 자격증1
   private MultipartFile teacherLicense2; // 강사 자격증2
   private MultipartFile teacherLicense3; // 강사 자격증3
   private MultipartFile teacherLicense4; // 강사 자격증4
   private MultipartFile teacherLicense5; // 강사 자격증5
   private String LicenseimageFileName1; //  자격증이미지 파일이름1
   private String LicenseimageFileName2; //  자격증이미지 파일이름2
   private String LicenseimageFileName3; //  자격증이미지 파일이름3
   private String LicenseimageFileName4; //  자격증이미지 파일이름4
   private String LicenseimageFileName5; //  자격증이미지 파일이름5
   private String teacherInfomation; // 강사 소개 
   private boolean teacherApprove; // 강사 승인 신청

   
   
   
   public Teacher() {
	super();
	
	
   }

public String getTeacherInfomation() {
      return teacherInfomation;
   }
   public void setTeacherInfomation(String teacherInfomation) {
      this.teacherInfomation = teacherInfomation;
   }
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
   public MultipartFile getTeacherLicense1() {
      return teacherLicense1;
   }
   public void setTeacherLicense1(MultipartFile teacherLicense1) {
      this.teacherLicense1 = teacherLicense1;
   }
   public boolean isTeacherApprove() {
      return teacherApprove;
   }
   public void setTeacherApprove(boolean teacherApprove) {
      this.teacherApprove = teacherApprove;
   }
	public String getTeacherimageFileName() {
		return teacherimageFileName;
	}

	public void setTeacherimageFileName(String teacherimageFileName) {
		this.teacherimageFileName = teacherimageFileName;
	}

	public MultipartFile getTeacherLicense2() {
		return teacherLicense2;
	}

	public void setTeacherLicense2(MultipartFile teacherLicense2) {
		this.teacherLicense2 = teacherLicense2;
	}

	public MultipartFile getTeacherLicense3() {
		return teacherLicense3;
	}

	public void setTeacherLicense3(MultipartFile teacherLicense3) {
		this.teacherLicense3 = teacherLicense3;
	}

	public MultipartFile getTeacherLicense4() {
		return teacherLicense4;
	}

	public void setTeacherLicense4(MultipartFile teacherLicense4) {
		this.teacherLicense4 = teacherLicense4;
	}

	public MultipartFile getTeacherLicense5() {
		return teacherLicense5;
	}

	public void setTeacherLicense5(MultipartFile teacherLicense5) {
		this.teacherLicense5 = teacherLicense5;
	}

	public String getLicenseimageFileName1() {
		return LicenseimageFileName1;
	}

	public void setLicenseimageFileName1(String licenseimageFileName1) {
		LicenseimageFileName1 = licenseimageFileName1;
	}

	public String getLicenseimageFileName2() {
		return LicenseimageFileName2;
	}

	public void setLicenseimageFileName2(String licenseimageFileName2) {
		LicenseimageFileName2 = licenseimageFileName2;
	}

	public String getLicenseimageFileName3() {
		return LicenseimageFileName3;
	}

	public void setLicenseimageFileName3(String licenseimageFileName3) {
		LicenseimageFileName3 = licenseimageFileName3;
	}

	public String getLicenseimageFileName4() {
		return LicenseimageFileName4;
	}

	public void setLicenseimageFileName4(String licenseimageFileName4) {
		LicenseimageFileName4 = licenseimageFileName4;
	}

	public String getLicenseimageFileName5() {
		return LicenseimageFileName5;
	}

	public void setLicenseimageFileName5(String licenseimageFileName5) {
		LicenseimageFileName5 = licenseimageFileName5;
	}
	
}