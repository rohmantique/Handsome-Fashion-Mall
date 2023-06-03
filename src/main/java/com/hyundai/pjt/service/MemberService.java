package com.hyundai.pjt.service;

import com.hyundai.pjt.dto.MemberDTO;
import com.hyundai.pjt.dto.ResetPasswordInputDTO;

public interface MemberService {

	// 회원가입
	public void memberJoin(MemberDTO member) throws Exception;

	// 아이디 중복 체크
	public int idCheck(String mid);

	// 입력한 이메일로 비밀번호 초기화 정보 전송
	public boolean sendResetPassword(MemberDTO member);

	// uuid에 해당하는 계정 활성화
	boolean emailAuth(String uuid);

	/* 입력받은 uuid에 대해서 password로 초기화 함 */
	MemberDTO resetPassword(String mpassword);

	/* 입력받은 uuid값이 유효한지 판단 */
	boolean checkResetPassword(String uuid);

	public void changeInfo(MemberDTO mem);
	
	//회원 탈퇴 (menabled를 1로 바꾸기)
	public void deleteUser(String mid);
	
	//회원정보 변경
	public void changeUserInfo(MemberDTO member);

}
