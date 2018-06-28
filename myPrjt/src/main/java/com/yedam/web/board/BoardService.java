package com.yedam.web.board;

import java.util.List;
import java.util.Map;

public interface BoardService {

	// 목록조회
	public List<Map<String, Object>> getBoardList(BoardSearchVO vo);

	public List<BoardVO> getBoardList2(BoardSearchVO vo);

	// 단건저회
	public BoardVO getBoard(String seqs);

	public int getCount();

	// 입력
	public void insertBoard(BoardVO vo);

	// 수정
	public void updateBoard(BoardVO vo);

	// 삭제
	public void deleteBoard(String seqs);
}
