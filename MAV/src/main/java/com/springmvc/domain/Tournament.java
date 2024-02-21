package com.springmvc.domain;

import java.sql.Time;
import java.util.Date;

public class Tournament 
{
	private int tournamentNum; // 토너먼트 넘버
	private String tournamentId; // 토너먼트 ID
	private int tournamentReward; // 토너먼트 상금
	private int tournamentPrice; // 토너먼트 참가비
	private Date tournamentDate; // 토너먼트 날짜
	private Time tournamentTime; // 토너먼트 시간
	
	
	
	public int getTournamentNum() {
		return tournamentNum;
	}
	public void setTournamentNum(int tournamentNum) {
		this.tournamentNum = tournamentNum;
	}
	public String getTournamentId() {
		return tournamentId;
	} 
	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}
	public int getTournamentReward() {
		return tournamentReward;
	}
	public void setTournamentReward(int tournamentReward) {
		this.tournamentReward = tournamentReward;
	}
	public int getTournamentPrice() {
		return tournamentPrice;
	}
	public void setTournamentPrice(int tournamentPrice) {
		this.tournamentPrice = tournamentPrice;
	}
	public Date getTournamentDate() {
		return tournamentDate;
	}
	public void setTournamentDate(Date tournamentDate) {
		this.tournamentDate = tournamentDate;
	}
	public Time getTournamentTime() {
		return tournamentTime;
	}
	public void setTournamentTime(Time tournamentTime) {
		this.tournamentTime = tournamentTime;
	}
	
	
}
