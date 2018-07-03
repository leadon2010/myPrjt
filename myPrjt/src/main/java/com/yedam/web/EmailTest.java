package com.yedam.web;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailTest {
	public static void main(String args[]) {
		SimpleEmail email = new SimpleEmail();
		// setHostName에 실제 메일서버정보
		email.setCharset("euc-kr"); // 한글 인코딩
		email.setHostName("smtp.gmail.com"); // SMTP서버 설정
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("changno2010", "vagtsgkfazhtfgxs"));
		email.setSSLOnConnect(true);
		try {
			email.addTo("leadon@empal.com", "lch"); // 수신자 추가
		} catch (EmailException e) {
			e.printStackTrace();
		}
		try {
			email.setFrom("changno2010@gmail.com", "Me"); // 보내는 사람
		} catch (EmailException e) {
			e.printStackTrace();
		}
		String contents = "이메일 테스트 입니다.\n오늘하루도 열심히 공부하세요\n내일은 오늘의 결과를 맛보게굅니다.";
		email.setSubject("메일전송테스트"); // 메일 제목
		email.setContent(contents, "text/plain; charset=euc-kr");
		try {
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
