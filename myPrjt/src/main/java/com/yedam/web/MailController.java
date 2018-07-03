package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {
	@RequestMapping("mailSend")
	public String mailSend(MailVO vo,HttpServletResponse response) throws IOException {
		vo.setFrom("changno2010@gmail.com");
		vo.setTo("leadon@naver.com");
		vo.setUserName("changno2010");
		vo.setPassword("vagtsgkfazhtfgxs");
		vo.setSubject("vo mail test3");
		vo.setText("test mail send3");
		MailService.mailSend(vo);
		PrintWriter out = response.getWriter();
		out.print("<script>alert('send success');</script>");
		
		return "home/home";
	}
}
