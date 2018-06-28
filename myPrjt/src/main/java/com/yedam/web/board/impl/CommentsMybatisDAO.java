package com.yedam.web.board.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.web.board.CommentsVO;

@Repository
public class CommentsMybatisDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public void insertComments(CommentsVO vo) {
		sqlSession.insert("comments.insertComments", vo);
	}

	public void updateComments(CommentsVO vo) {
		sqlSession.update("comments.updateComments", vo);
	}

	public void deleteComments(CommentsVO vo) {
		sqlSession.delete("comments.deleteComments", vo);
	}

	public List<Map<String, Object>> getCommentsList(CommentsVO vo) {
		return sqlSession.selectList("comments.getCommentsList", vo);
	}

	public List<CommentsVO> getCommentsList2(CommentsVO vo) {
		return sqlSession.selectList("comments.getCommentsList2", vo);
	}

	public CommentsVO getComments(CommentsVO vo) {
		return sqlSession.selectOne("comments.getComments", vo);
	}
}
