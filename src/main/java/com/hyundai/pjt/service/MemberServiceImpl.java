package com.hyundai.pjt.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.hyundai.pjt.components.MailComponents;
import com.hyundai.pjt.dto.MemberDTO;
import com.hyundai.pjt.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;

	@Autowired
	private MailComponents mailComponents;

	/* 회원가입 */
	@Override
	public void memberJoin(MemberDTO member) throws Exception {
		log.info("register@@@@@@@@@@@@@@@@@@@" + member);
		String mdate = member.getYear() + "/" + member.getMonth() + "/" + member.getDay();
		member.setMdate(mdate);
		String maddress = member.getMzipcode() + " " + member.getMaddress1() + " " + member.getMaddress2();
		member.setMaddress(maddress);
		member.setMpoint(2500); //기본으로 2500 꽂아주기 dto에 맵핑
		member.setMenabled(0); //가입이면 0, 탈퇴면 1
		
		log.info("date값은: " + member.getMdate());
		log.info("maddress값은: " + member.getMaddress());
		log.info("member는: " + member);
		mapper.memberJoin(member);
		log.info("dto에 맵핑완료된 값은: " + mapper);
		mapper.memberAuth(member.getMid());
	}

	/* 아이디 중복체크*/
	@Override
	public int idCheck(String mid) {
		int flag = mapper.idCheck(mid);
		if(flag == 1) {
			log.info("아이디 사용 불가!!!!!!!!!!!!!!!");
		}else {
			log.info("아이디 사용 가능!!!!!!!!!!!!!!!");
		}
		return flag;
	}

	@Override
	public boolean sendResetPassword(MemberDTO member) {
		log.info("1");
		MemberDTO optionalMember = mapper.findByUserEmailAndUserName(member.getMname(), member.getMemail());
		log.info("2");
		if (optionalMember == null) {
			log.info("2-1");
			throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다!");
		}
		log.info("3");
		log.info(optionalMember);

		String uuid = UUID.randomUUID().toString();
		log.info("uuid는" + uuid);
		optionalMember.setMpassword(uuid);
		log.info("optionalMember는??????" + optionalMember);
		mapper.changeInfo(optionalMember);

		String email = member.getMemail();
		String subject = "[더한섬닷컴] 비밀번호 초기화 메일입니다.";
		String text = "<p>비밀번호 초기화 메일입니다. </p>" + "<p>아래 링크를 클릭하셔서 비밀번호를 초기화해주세요.</p>"
				+ "<div><a target='_blank'" + "href='http://localhost/mypage/reset/password?id=" + uuid
				+ "'>비밀번호 초기화 링크 </a></div>";

		mailComponents.sendMail(email, subject, text);
		return true;
	}

	@Override
	public boolean emailAuth(String uuid) {
		return false;
	}

	@Override
	public MemberDTO resetPassword(String mpassword) {
		log.info("2" + mpassword);
		MemberDTO member = mapper.findByUser(mpassword);
		log.info("3" + member);
		return member;
	}

	@Override
	public boolean checkResetPassword(String uuid) {
		return false;
	}

	@Override
	public void changeInfo(MemberDTO mem) {
		log.info("5" + mem);
		mapper.changeInfo(mem);
	}

	/* 회원탈퇴 */
	@Override
	public void deleteUser(String mid) {
		log.info("멤버서비스단 ====> 회원 탈퇴 ");
		mapper.deleteUser(mid);
	}

	/* 회원정보 변경 */
	@Override
	public void changeUserInfo(MemberDTO member) {
		log.info("멤버 서비스단 ====> 회원정보 변경 (이메일, 폰번호)" );
		mapper.changeUserInfo(member);
	}

}
