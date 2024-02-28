package com.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class Store 
{
	private String storeId; // 업체 ID
	private String storeName; // 업체명
	private String storeAddr; // 업체 주소
	private String storeCategory; // 업체 종목
	private String storeCode; // 업체 사업자등록번호
	private String storePhone01; // 업체 전화번호 첫번째 
	private String storePhone02; // 업체 전화번호 두번째
	private String storePhone03; // 업체 전화번호 세번째
	private MultipartFile storeImages; // 업체 이미지
	private String storeInfomation; // 업체 소개
	private String storeNotice; // 업체 공지사항
	private boolean storeApprove; // 업체 승인 신청
	private boolean storeRegApprove; // 업체 신청 확인

	
	
	public Store()
	{
		super();
	}
	public String getStoreInfomation() {
		return storeInfomation;
	}
	public void setStoreInfomation(String storeInfomation) {
		this.storeInfomation = storeInfomation;
	}
	public String getStoreNotice() {
		return storeNotice;
	}
	public void setStoreNotice(String storeNotice) {
		this.storeNotice = storeNotice;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddr() {
		return storeAddr;
	}
	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}
	public String getStoreCategory() {
		return storeCategory;
	}
	public void setStoreCategory(String storeCategory) {
		this.storeCategory = storeCategory;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getStorePhone01() {
		return storePhone01;
	}
	public void setStorePhone01(String storePhone01) {
		this.storePhone01 = storePhone01;
	}
	public String getStorePhone02() {
		return storePhone02;
	}
	public void setStorePhone02(String storePhone02) {
		this.storePhone02 = storePhone02;
	}
	public String getStorePhone03() {
		return storePhone03;
	}
	public void setStorePhone03(String storePhone03) {
		this.storePhone03 = storePhone03;
	}
	public void setStoreImages(MultipartFile storeImages) {
		this.storeImages = storeImages;
	}
	public boolean isStoreApprove() {
		return storeApprove;
	}
	public void setStoreApprove(boolean storeApprove) {
		this.storeApprove = storeApprove;
	}
	public boolean isStoreRegApprove() {
		return storeRegApprove;
	}
	public void setStoreRegApprove(boolean storeRegApprove) {
		this.storeRegApprove = storeRegApprove;
	}
	public MultipartFile getStoreImages() {
		return storeImages;
	}
	
}
