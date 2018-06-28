package com.yedam.web.board.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.web.board.BoardSearchVO;
import com.yedam.web.board.BoardService;
import com.yedam.web.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;

	@Override
	public List<Map<String, Object>> getBoardList(BoardSearchVO vo) {
		return dao.getBoardList(vo);
	}

	@Override
	public List<BoardVO> getBoardList2(BoardSearchVO vo) {
		return dao.getBoardList2(vo);
	}

	@Override
	public BoardVO getBoard(String seq) {
		return dao.getBoard(seq);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
		;
	}

	@Override
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(String seqs) {
		dao.deleteBoard(seqs);
	}

	@Override
	public int getCount() {
		return dao.getCount();
	}

}
