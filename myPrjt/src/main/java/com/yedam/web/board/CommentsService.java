package com.yedam.web.board;

import java.util.List;
import java.util.Map;

public interface CommentsService {
	public void insertComments(CommentsVO vo);

	public void updateComments(CommentsVO vo);

	public void deleteComments(CommentsVO vo);

	public List<Map<String, Object>> getCommentsList(CommentsVO vo);

	public List<CommentsVO> getCommentsList2(CommentsVO vo);

	public CommentsVO getComments(CommentsVO vo);
}
