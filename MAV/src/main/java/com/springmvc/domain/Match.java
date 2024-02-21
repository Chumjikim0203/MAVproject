package com.springmvc.domain;

import java.sql.Time;
import java.util.Date;

public class Match 
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
