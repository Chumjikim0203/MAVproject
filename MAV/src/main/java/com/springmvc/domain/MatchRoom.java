package com.springmvc.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class MatchRoom {
    private int matchNum; // 매칭 번호
    private String matchTitle;
    private int roomNum; // 방 번호
	private String memberId; // 회원 ID
    private String matchStatus; // 매칭 상태
    private String matchResult; // 매칭 결과
    
    private String storeId; // 상점 ID
    private String roomName; // 경기장 이름
    
	@NotNull(message = "경기장 ID를 입력해주세요")
    @Size(max = 15, message = "경기장 ID는 최대 15자까지 입력 가능합니다")
    private String roomId; // 경기장 ID

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

}
