package com.springmvc.domain;

public class Notice 
{
	private long noticeId; // 공지사항ID
	private String noticeTitle; // 공지사항 제목
	private String noticeDetail; // 공지사항 글 내용
	private int noticeView; // 공지사항 조회수
	// 댓글
	// 이전글, 다음글 
	
	
	public long getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(long noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeDetail() {
		return noticeDetail;
	}
	public void setNoticeDetail(String noticeDetail) {
		this.noticeDetail = noticeDetail;
	}
	public int getNoticeView() {
		return noticeView;
	}
	public void setNoticeView(int noticeView) {
		this.noticeView = noticeView;
	}
	
	
}
