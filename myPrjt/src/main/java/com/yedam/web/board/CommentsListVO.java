package com.yedam.web.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "commentsList")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommentsListVO {

	@XmlElement(name = "comments")
	private List<CommentsVO> commentsList;

	public List<CommentsVO> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<CommentsVO> commentsList) {
		this.commentsList = commentsList;
	}

}
