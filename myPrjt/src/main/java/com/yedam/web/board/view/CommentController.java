package com.yedam.web.board.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.web.board.CommentsListVO;
import com.yedam.web.board.CommentsVO;
import com.yedam.web.board.impl.CommentsServiceImpl;

@Controller
public class CommentController {

	@Autowired
	CommentsServiceImpl commentsService;

	@RequestMapping("/ajaxTest")
	@ResponseBody
	public List<String> getComment() {
		List<String> list = new ArrayList<String>();

		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");

		return list;
	}

	@RequestMapping("/insertComments")
	@ResponseBody
	public CommentsVO insertComments(CommentsVO vo) {
		commentsService.insertComments(vo);
		return commentsService.getComments(vo);
	}

	@RequestMapping("/updateComments")
	@ResponseBody
	public CommentsVO updateComments(CommentsVO vo) {
		commentsService.updateComments(vo);
		return commentsService.getComments(vo);
	}

	@RequestMapping("/deleteComments")
	@ResponseBody
	public CommentsVO deleteComments(CommentsVO vo) {
		commentsService.deleteComments(vo);
		return vo;
	}

	@RequestMapping("/getCommentsList")
	@ResponseBody
	public List<Map<String, Object>> getCommentsList(CommentsVO vo) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = commentsService.getCommentsList(vo);
		return list;
	}

	@RequestMapping("/getCommentsList2")
	@ResponseBody
	public List<CommentsVO> getCommentsList2(CommentsVO vo) {
		List<CommentsVO> list = new ArrayList<CommentsVO>();
		list = commentsService.getCommentsList2(vo);
		return list;
	}

	@RequestMapping("/getCommentsXml")
	@ResponseBody
	public CommentsListVO getCommentsXml(CommentsVO vo) {
		List<CommentsVO> list = commentsService.getCommentsList2(vo);
		CommentsListVO listvo = new CommentsListVO();
		listvo.setCommentsList(list);
		return listvo;
	}

}
