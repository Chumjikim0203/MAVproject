package com.springmvc.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Room 
{
	private int roomNum; // 경기장 번호    
    

    private String roomId; // 경기장 ID

    @NotNull(message = "경기장 이름을 입력해주세요")
    @Size(max = 20, message = "경기장 이름은 최대 20자까지 입력 가능합니다")
    private String roomName; // 경기장 이름


    @NotNull(message = "경기장 수용인원을 입력해주세요")
    private int roomCapacity; // 경기장 수용인원

    @NotNull(message = "경기장 참가인원을 입력해주세요")
    private int roomCount; // 경기장 참가인원

    @NotNull(message = "경기 종류(종목)를 입력해주세요")
    @Size(max = 10, message = "경기 종류(종목)는 최대 10자까지 입력 가능합니다")
    private String roomCategory; // 경기 종류(종목)

    private String roomDetail; // 경기장 소개글

    @NotNull(message = "경기 날짜를 입력해주세요")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate roomDate; // 경기 날짜

    @NotNull(message = "경기 시간을 입력해주세요")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime roomTime; // 경기 시간
    
    private String storeId; // 상점 ID
   
    private boolean isMatched;
    
   public boolean isMatched() {
		return isMatched;
	}


	public void setMatched(boolean isMatched) {
		this.isMatched = isMatched;
	}


	public Room() {
<<<<<<< HEAD
      this.roomCapacity = 1;
      this.roomId = "mav";
      this.storeId = "mav"; 
=======

      this.roomCapacity = 1;
>>>>>>> 6f8e02927c668559c23d378e1cd5decd4cefd5ba
      this.isMatched = false;
	}

   
   public String getStoreId() {
      return storeId;
   }

   public void setStoreId(String storeId) {
      this.storeId = storeId;
   }
   
   public int getRoomNum() {
      return roomNum;
   }

   public void setRoomNum(int roomNum) {
      this.roomNum = roomNum;
   }

   public String getRoomId() {
      return roomId;
   }

   public void setRoomId(String roomId) {
      this.roomId = roomId;
   }

   public String getRoomName() {
      return roomName;
   }

   public void setRoomName(String roomName) {
      this.roomName = roomName;
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

   public LocalDate getRoomDate() {
      return roomDate;
   }

   public void setRoomDate(LocalDate roomDate) {
      this.roomDate = roomDate;
   }

   public LocalTime getRoomTime() {
      return roomTime;
   }

   public void setRoomTime(LocalTime roomTime) {
      this.roomTime = roomTime;
   }
   
} 
