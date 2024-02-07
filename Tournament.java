package com.springmvc.domain;

import java.sql.Time;
import java.util.Date;

public class Tournament 
{
	private String tournamentId; // 토너먼트ID
	private int tournamentReword; // 토너먼트 상금
	private int tournamentPrice; // 토너먼트 참가비
	private Date tournamentDate; // 토너먼트 날짜
	private Time tournamentTime; // 토너먼트 시간
	
	public String getTournamentId() {
		return tournamentId;
	} 
	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}
	public int getTournamentReword() {
		return tournamentReword;
	}
	public void setTournamentReword(int tournamentReword) {
		this.tournamentReword = tournamentReword;
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
