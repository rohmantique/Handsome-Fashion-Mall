package com.hyundai.pjt.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.pjt.dto.MemberDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberMapperTests {

	@Autowired
	private MemberMapper mapper;

	// 회원가입 (이메일, 비번, 이름, 생년월일)
//	@Test
//	public void testMemberJoin() {
//		MemberDTO memberDTO = new MemberDTO();
//		
//		memberDTO.setMid("가보자고222");
//		memberDTO.setMpassword("1111");
//		memberDTO.setMname("김멍멍");
//		memberDTO.setMemail("aaa@mail.com");
//		memberDTO.setMdate("1999/02/12");
//		memberDTO.setMtel("010-1010-1010");
//		memberDTO.setMzipcode("1111");
//		memberDTO.setMaddress1("Sdfs");
//		memberDTO.setMaddress2("ffffffffffffff");
//		memberDTO.setMpoint(1);
//		memberDTO.setMenabled(0);
//		
//		mapper.memberJoin(memberDTO);
//		log.info("회원가입 테스트!!!!!!!!!!!!!!!!!!!!");
//	}

//	@Test
//	public void testFindById() {
//		MemberDTO member = new MemberDTO();
//		member = mapper.findById("soojin");
//		log.info(member);
//	}
	
//	@Test
//	public void testIdCheck() {
//		MemberDTO member = new MemberDTO();
//		int a = mapper.idCheck("mola");
//		log.info("mola가 있나요?? " + a);
//	}
//	
//	@Test
//	public void testFindByUser() {
//		MemberDTO member = new MemberDTO();
//		member = mapper.findByUser("12345678");
//		log.info(member);
//	}
//	
////	@Test
////	public void testChangeInfo() {
////		mapper.changePassword("훔냐링");
////	}
//	
//	//회원탈퇴 menabled을 1로 바꾸기
//	@Test
//	public void testDeletedUser() {
//		MemberDTO member = new MemberDTO();
//		mapper.deleteUser("rara");
//	}
//	
	
	//정보 변경
	@Test
	public void testChangeAddress() {
		MemberDTO mem = new MemberDTO();
		
		mem.setMid("hee");
		mem.setMemail("1212");
		mem.setMtel("11");
		
		mapper.changeUserInfo(mem);
	}
}
