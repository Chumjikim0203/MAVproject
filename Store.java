package com.springmvc.domain;

import org.springframework.web.multipart.MultipartFile;

public class Store 
{
	private String storeId; // 업체ID
	private String storeName; // 업체명
	private String storeAddr; // 업체 주소
	private String storeCategory; // 업체 종목
	private String storeCode; // 업체 사업자등록번호
	private int storePhone01; // 업체 전화번호 첫번째 
	private int storePhone02; // 업체 전화번호 두번째
	private int storePhone03; // 업체 전화번호 세번째
	private MultipartFile storeImages; // 업체 이미지
	
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
	public int getStorePhone01() {
		return storePhone01;
	}
	public void setStorePhone01(int storePhone01) {
		this.storePhone01 = storePhone01;
	}
	public int getStorePhone02() {
		return storePhone02;
	}
	public void setStorePhone02(int storePhone02) {
		this.storePhone02 = storePhone02;
	}
	public int getStorePhone03() {
		return storePhone03;
	}
	public void setStorePhone03(int storePhone03) {
		this.storePhone03 = storePhone03;
	}
	public MultipartFile getStoreImages() {
		return storeImages;
	}
	public void setStoreImages(MultipartFile storeImages) {
		this.storeImages = storeImages;
	}
		
}
