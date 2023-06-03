package com.hyundai.pjt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.hyundai.pjt.components.MailComponents;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequiredArgsConstructor
public class MainController {

	// 메인 페이지 매핑
	@GetMapping("/main")
	public String Main() {
		log.info("메인");
		return "/main";
	}
}
