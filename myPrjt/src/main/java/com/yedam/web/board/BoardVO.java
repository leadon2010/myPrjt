package com.yedam.web.board;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private String seq;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int cnt;
	private String uploadFile;

	//MultipartFile tempUploadFile;

	private String searchKeyword;
	private String searchCondition;

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}

	//public MultipartFile getTempUploadFile() {
	//	return tempUploadFile;
	//}

	//public void setTempUploadFile(MultipartFile tempUploadFile) {
	//	this.tempUploadFile = tempUploadFile;
	//}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + ", uploadFile=" + uploadFile + ", tempUploadFile=" + "tempUploadFile"
				+ ", searchKeyword=" + searchKeyword + ", searchCondition=" + searchCondition + "]";
	}

}
