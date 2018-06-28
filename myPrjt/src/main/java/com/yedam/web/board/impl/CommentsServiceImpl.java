package com.yedam.web.board.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.web.board.CommentsService;
import com.yedam.web.board.CommentsVO;

@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	CommentsMybatisDAO dao;

	public void insertComments(CommentsVO vo) {
		dao.insertComments(vo);
	}

	public void updateComments(CommentsVO vo) {
		dao.updateComments(vo);
	}

	public void deleteComments(CommentsVO vo) {
		dao.deleteComments(vo);
	}

	public List<Map<String, Object>> getCommentsList(CommentsVO vo) {
		return dao.getCommentsList(vo);
	}

	public List<CommentsVO> getCommentsList2(CommentsVO vo) {
		return dao.getCommentsList2(vo);
	}

	public CommentsVO getComments(CommentsVO vo) {
		return dao.getComments(vo);
	}

}
