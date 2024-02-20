package com.springmvc.domain;

import java.sql.Time;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;


public class Match 
{   

    private int matchNum; // 매칭 번호
    private int roomNum; // 방 번호
    private String matchTitle;
	private String memberId; // 회원 ID
    private String matchStatus; // 매칭 상태
    private String matchResult; // 매칭 결과

    private Room room;
    
    
    
    public String getMatchTitle() {
		return matchTitle;
	}

	public void setMatchTitle(String matchTitle) {
		this.matchTitle = matchTitle;
	}
	
   public int getMatchNum() {
      return matchNum;
   }

   public void setMatchNum(int matchNum) {
      this.matchNum = matchNum;
   }

   public int getRoomNum() {
      return roomNum;
   }

   public void setRoomNum(int roomNum) {
      this.roomNum = roomNum;
   }

   public String getMemberId() {
      return memberId;
   }

   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }

   public String getMatchStatus() {
      return matchStatus;
   }

   public void setMatchStatus(String matchStatus) {
      this.matchStatus = matchStatus;
   }

   public String getMatchResult() {
      return matchResult;
   }

   public void setMatchResult(String matchResult) {
      this.matchResult = matchResult;
   }

   public Room getRoom() {
      return room;
   }

   public void setRoom(Room room) {
      this.room = room;
   }
    
    
      
}