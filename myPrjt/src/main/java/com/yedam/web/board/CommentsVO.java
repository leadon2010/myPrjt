package com.yedam.web.board;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlAccessorType(XmlAccessType.FIELD)
public class CommentsVO {

	@XmlAttribute
	private String seq; // 댓글번호
	private String name; // 이름
	private String content; // 내용
	private String boardSeq; // 게시글번호(참조키)
	private String regdate;

	@XmlTransient
	private int pageUnit;

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(String boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@JsonIgnore
	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	@Override
	public String toString() {
		return "CommentsVO [seq=" + seq + ", name=" + name + ", content=" + content + ", boardSeq=" + boardSeq
				+ ", regdate=" + regdate + "]";
	}
}
