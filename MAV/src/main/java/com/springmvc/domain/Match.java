package com.springmvc.domain;

import java.sql.Time;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;


public class Match 
<<<<<<< HEAD
{
	private int matchNum; // 매칭 번호
	private String matchId; // 매칭 ID
	private Date matchDate; // 매칭 날짜
	private Time matchTime; // 매칭 시간
	private String matchResult; // 매칭 결과
	
	
	
	public int getMatchNum() {
		return matchNum;
	}
	public void setMatchNum(int matchNum) {
		this.matchNum = matchNum;
	}
	public String getMatchId() {
		return matchId; 
	}
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	public Date getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	public Time getMatchTime() {
		return matchTime;
	}
	public void setMatchTime(Time matchTime) {
		this.matchTime = matchTime;
	}
	public String getMatchResult() {
		return matchResult;
	}
	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}
		
}
=======
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
>>>>>>> origin/KTY
