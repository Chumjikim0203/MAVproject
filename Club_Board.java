package com.springmvc.domain;

public class Club_Board 
{
	private long boardId; // 게시판ID
	private String boardTitle; // 게시글 제목
	private String boardDetail; // 게시글 내용
	private int boardViews; // 게시글 조회수
	// 댓글
	// 이전글 , 다음글 
	
	public long getBoardId() {
		return boardId;
	}
	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardDetail() {
		return boardDetail;
	}
	public void setBoardDetail(String boardDetail) {
		this.boardDetail = boardDetail;
	}
	public int getBoardViews() {
		return boardViews;
	}
	public void setBoardViews(int boardViews) {
		this.boardViews = boardViews;
	}
		
}
