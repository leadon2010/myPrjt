package com.yedam.web;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	Date tday = new Date();

	@Scheduled(cron = "0/20 0/1 11 * * *")
	public void doCron() {
		tday = new Date();
		System.out.println("오전 11시 1분간격으로 실행" + tday);

	}

}
