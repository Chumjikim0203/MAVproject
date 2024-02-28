package com.springmvc.domain;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Tournament {
    private int tournamentNum;
    private String storeId;
    private int tournamentReward; //상금         
    private int tournamentPrice; // 참가비
    private int max_participants ; //참가팀 수
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tournamentDate;
    
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime tournamentTime;

	public Tournament() {
    }
	
    public int getMax_participants() {
		return max_participants;
	}

	public void setMax_participants(int max_participants) {
		this.max_participants = max_participants;
	}

    public int getTournamentNum() {
        return tournamentNum;
    }
        
    public void setTournamentNum(int tournamentNum) {
        this.tournamentNum = tournamentNum;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
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

    public LocalDate getTournamentDate() {
		return tournamentDate;
	}

	public void setTournamentDate(LocalDate tournamentDate) {
		this.tournamentDate = tournamentDate;
	}

	public LocalTime getTournamentTime() {
		return tournamentTime;
	}

	public void setTournamentTime(LocalTime tournamentTime) {
		this.tournamentTime = tournamentTime;
	}

}