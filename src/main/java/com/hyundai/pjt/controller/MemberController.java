package com.hyundai.pjt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyundai.pjt.dto.MemberDTO;
import com.hyundai.pjt.mapper.MemberMapper;
import com.hyundai.pjt.security.service.MemberContext;
import com.hyundai.pjt.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
   private UserDetailsService userDetailsService;
	   

	/* 회원가입 폼작성 페이지 이동 */
	@GetMapping("/join")
	public String joinForm() {
		return "member/joinForm";
	}

	/* 회원가입 POST */
	@Transactional
	@PostMapping("/join")
	public String joinPOST(MemberDTO member) throws Exception {
		log.info("회원가입 페이지 진입 : " + member);
		// 비밀번호 인코딩
		String encoderPassword = passwordEncoder.encode(member.getMpassword());
		member.setMpassword(encoderPassword);
		String mid = member.getMid();
		// insert
		memberService.memberJoin(member);
		mapper.insertCoupon(mid);
		
		return "redirect:/member/joinComplete";
	}

	/* 회원가입 성공 페이지 이동 */
	@GetMapping("/joinComplete")
	public String joinComplete() {
		return "member/joinComplete";
	}

	/* 아이디 중복 체크 */
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChk(String mid) throws Exception {

		log.info("memberIdChk() 진입");
		log.info("ajax에서 넘어온 mid =" + mid);
		int result = memberService.idCheck(mid);// 해당 아이디가 있는지 result 변수에 담기
		log.info("결과값 = " + result);

		if (result != 0) {
			return "fail"; // 아이디가 존재하면 fail 을 ajax result 값으로 던짐
		} else {
			return "success"; // 아이디가 존재하지 않으면 success 을 ajax result 값으로 던짐
		}
	}

	/* 로그인 페이지 이동 */
	@GetMapping("/CustomLogin")
	public String login() {
		return "member/login";
	}

	/* 로그아웃 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/main";
	}

	/* 비밀번호 체크 페이지 이동 */
	@GetMapping("/pwCheck")
	public String pwCheck() {
		return "member/pwCheck";
	}

	/* 회원탈퇴 */
	@PostMapping("/userDelete")
	public String userDelete(@RequestParam("mid") String mid, Model model, HttpSession session) {
		memberService.deleteUser(mid);
		SecurityContextHolder.clearContext(); // 세션 삭제 -> 로그아웃
		return "redirect:/main";
	}
	
	/* 정보변경 페이지 이동 */
	@GetMapping("/userInfoChange")
	public String userInfoChange() {
		log.info("정보 변경 페이지로 이동 >>>>>>>>>>>>>>>>>>>>>>>");
		return "member/userInfoChange";
	}
	
	/* 정보변경 Action */
	@PostMapping("/userInfoChange")
	public String userInfoChangePOST(MemberDTO member, Model model) {
		
		MemberContext memberContext = (MemberContext) userDetailsService.loadUserByUsername(member.getMid());
		log.info("1 - 회원정보가 변경되는 mid는? " + member.getMid() );
		MemberDTO mem = memberContext.getMember();
		mem.setMemail(member.getMemail());
		mem.setMtel(member.getMtel());
		
		memberService.changeUserInfo(mem);
		
		return "redirect:/main";
	}

}
