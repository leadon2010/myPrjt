package com.yedam.web.board.view;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.yedam.web.Paging;
import com.yedam.web.board.BoardSearchVO;
import com.yedam.web.board.BoardService;
import com.yedam.web.board.BoardVO;

@Controller
@SessionAttributes("board") // 모델에board속성이 추가되면 session에도 저장되도록..
public class BoardController {

	@Autowired
	BoardService boardService;

	/**
	 * getBoardList doc
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping("/getBoardList")
	public ModelAndView getBoardList(HttpServletRequest request, BoardSearchVO vo, Paging paging) {
		ModelAndView mav = new ModelAndView();
		if (paging.getPage() == null)
			paging.setPage(1);

		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());

		paging.setTotalRecord(boardService.getCount());

		mav.addObject("paging", paging);
		request.setAttribute("boardList", boardService.getBoardList(vo));
		mav.setViewName("board/getBoardList");
		// return "board/getBoardList";
		return mav;
	}

	@RequestMapping("/getBoardList2")
	public ModelAndView getBoardList2(HttpServletRequest request, BoardSearchVO vo, Paging paging) {
		// request.setAttribute("boardList", boardService.getBoardList2(vo));
		ModelAndView mav = new ModelAndView();
		if (paging.getPage() == null)
			paging.setPage(1);

		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());

		paging.setTotalRecord(boardService.getCount());

		mav.addObject("paging", paging);
		mav.addObject("boardList", boardService.getBoardList2(vo));

		mav.setViewName("board/getBoardList2");
		// return "board/getBoardList2";
		return mav;
	}

	@RequestMapping("/getBoard/{seq}")
	public String getBoard(@PathVariable String seq, Model model) {
		model.addAttribute("board", boardService.getBoard(seq));
		return "board/getBoard";
	}

	@RequestMapping("/getBoardXml/{seq}")
	public String getBoardXml(@PathVariable String seq, Model model) {
		model.addAttribute("board", boardService.getBoard(seq));
		return "board/getBoardXml";
	}

	@RequestMapping("/getBoard2")
	public String getBoard_b(@RequestParam(value = "s", required = false, defaultValue = "1") String seq,
			Model model/* HttpServletRequest request */) {
		// String seqs = request.getParameter("seq");
		// request.setAttribute("board", boardService.getBoard(seqs));
		model.addAttribute("board", boardService.getBoard(seq));
		return "board/getBoard2";
	}

	@RequestMapping(value = "/updateBoard", method = RequestMethod.GET)
	public String updateBoardForm(@ModelAttribute("board") BoardVO vo, HttpServletRequest request, Model model) {
		System.out.println(vo);
		model.addAttribute("board", boardService.getBoard(vo.getSeq()));
		return "board/updateBoard";
	}

	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public String updateBoard(@ModelAttribute("board") BoardVO vo, HttpServletRequest request) {
		System.out.println(vo);
		boardService.updateBoard(vo);
		return "redirect:getBoardList";
	}

	@RequestMapping(value = "/updateBoard2", method = RequestMethod.GET)
	public String updateBoardForm2(@ModelAttribute("board") BoardVO vo, HttpServletRequest request, Model model) {
		System.out.println(vo);
		model.addAttribute("board", boardService.getBoard(vo.getSeq()));
		return "board/updateBoard2";
	}

	@RequestMapping(value = "/updateBoard2", method = RequestMethod.POST)
	public String updateBoard2(@ModelAttribute("board") BoardVO vo, HttpServletRequest request) {
		System.out.println(vo);
		boardService.updateBoard(vo);
		return "redirect:getBoardList2";
	}

	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String insertBoardForm(HttpServletRequest request) {
		return "board/insertBoard";
	}

	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoard(@ModelAttribute("vo") BoardVO vo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		// MultipartFile uploadFile = vo.getTempUploadFile();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = multipartRequest.getFile("tempUploadFile");

		if (!uploadFile.isEmpty() && uploadFile.getSize() > 0) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("d:/upload", fileName));
			vo.setUploadFile(fileName);
		}
		boardService.insertBoard(vo);
		System.out.println(vo);
		return "board/getBoard";
		// return "redirect:getBoard2";
	}

	@RequestMapping(value = "/insertBoard2", method = RequestMethod.GET)
	public String insertBoardForm2(HttpServletRequest request) {
		return "board/insertBoard2";
	}

	@RequestMapping(value = "/insertBoard2", method = RequestMethod.POST)
	public String insertBoard2(@ModelAttribute("vo") BoardVO vo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		// MultipartFile uploadFile = vo.getTempUploadFile();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile uploadFile = multipartRequest.getFile("tempUploadFile");

		if (!uploadFile.isEmpty() && uploadFile.getSize() > 0) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("d:/upload", fileName));
			vo.setUploadFile(fileName);
		}
		boardService.insertBoard(vo);
		System.out.println(vo);
		return "board/getBoard2";
		// return "redirect:getBoard2";
	}

	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	@RequestMapping("downloadBoard")
	public void downloadBoard(@RequestParam String seq, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("::::::::::::::" + seq);
		BoardVO vo = boardService.getBoard(seq);
		String fileName = vo.getUploadFile();
		System.out.println("::::::::::::::" + fileName);
		// File uFile = new File("d:upload", fileName);

		// String atchFileId = (String) commandMap.get("uploadFile");
		File uFile = new File("d:/upload", fileName);
		long fSize = uFile.length();
		if (fSize > 0) {
			String mimetype = "application/x-msdownload";
			response.setContentType(mimetype);

			setDisposition(fileName, request, response);
			BufferedInputStream in = null;
			BufferedOutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(uFile));
				out = new BufferedOutputStream(response.getOutputStream());
				// FileCopyUtils.copy(in, out);
				int temp;

				while ((temp = in.read()) != -1) {
					out.write(temp);
				}
				out.flush();
			} catch (IOException ex) {
			} finally {
				in.close();
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
		} else {
			response.setContentType("application/x-msdownload");
			PrintWriter printwriter = response.getWriter();
			printwriter.println("<html>");
			printwriter.println("<h2>Could not get file name:<br>" + fileName + "</h2>");
			printwriter.println("<center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
			printwriter.println("&copy; webAccess");
			printwriter.println("</html>");
			printwriter.flush();
			printwriter.close();
		}

	}// enf of downloadFile

	private void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String browser = getBrowser(request);
		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;
		if (browser.equals("MSIE")) {
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Trident")) { // IE11 문자열 깨짐 방지
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Opera")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < filename.length(); i++) {
				char c = filename.charAt(i);
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFilename = sb.toString();
		} else {
			throw new IOException("Not supported browser");
		}
		response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);
		if ("Opera".equals(browser)) {
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
	}

	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Trident") > -1) { // IE11 문자열 깨짐 방지
			return "Trident";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		return "Firefox";
	}

}
