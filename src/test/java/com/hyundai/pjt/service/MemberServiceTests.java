package com.hyundai.pjt.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.pjt.dto.MemberDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberServiceTests {

	@Autowired
	private MemberService service;

	// 정보변경
	@Test
	public void testChangeUserInfo() {
		MemberDTO member = new MemberDTO();
		service.changeUserInfo(member);
	}

}
