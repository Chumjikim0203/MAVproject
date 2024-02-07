package com.springmvc.domain;

import java.sql.Time;
import java.util.Date;

public class Room 
{
	private String roomId; // 경기장 ID
	private int roomCapacity; // 경기장 수용인원
	private int roomCount; // 경기장 참가인원
	private String roomCategory; // 경기장 종목(종류)
	private String roomDetail; // 경기장 세부사항
	private Date roomDate; // 경기 날짜
	private Time roomTime; // 경기 시간
	
	public String getRoomId() {
		return roomId;
	} 
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public int getRoomCapacity() {
		return roomCapacity;
	}
	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	public int getRoomCount() {
		return roomCount;
	}
	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
	public String getRoomCategory() {
		return roomCategory;
	}
	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}
	public String getRoomDetail() {
		return roomDetail;
	}
	public void setRoomDetail(String roomDetail) {
		this.roomDetail = roomDetail;
	}
	public Date getRoomDate() {
		return roomDate;
	}
	public void setRoomDate(Date roomDate) {
		this.roomDate = roomDate;
	}
	public Time getRoomTime() {
		return roomTime;
	}
	public void setRoomTime(Time roomTime) {
		this.roomTime = roomTime;
	}
	
	
}
