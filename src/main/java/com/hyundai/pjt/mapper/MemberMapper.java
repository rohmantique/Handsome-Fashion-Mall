package com.hyundai.pjt.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyundai.pjt.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	// 회원가입
	public void memberJoin(MemberDTO member);

	// 아이디 중복 체크
	public int idCheck(String mid);

	// 로그인을 위한 아이디 조회
	// 로그인시 menabled가 1이면 로그인 불가
	public MemberDTO findById(@RequestParam("mid") String mid);

	// 유저 권한 부여
	public void memberAuth(String mid);

	// 유저네임, 유저이메일 맞는지 확인
	MemberDTO findByUserEmailAndUserName(String mname, String memail);

	// 유저 정보 번호 업데이트
	public void changeInfo(MemberDTO member);

	// 비번 찾기를 위한 유저 조회
	public MemberDTO findByUser(String mpassword);
	
	//비번 업데이트
	public void changePassword(MemberDTO member);
	
	//회원 탈퇴 (menabled를 1로 바꾸기)
	public void deleteUser(String mid);
	
	//회원정보 변경
	public void changeUserInfo(MemberDTO member);
	
	//쿠폰 삽입
	public void insertCoupon(String mid);

	MemberDTO findByEmailAuthKey(String emailAuthKey);

	MemberDTO findByResetPasswordKey(String mpassword);

}
