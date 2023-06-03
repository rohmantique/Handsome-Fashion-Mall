package com.hyundai.pjt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyundai.pjt.dto.MemberDTO;
import com.hyundai.pjt.dto.MyorderDTO;
import com.hyundai.pjt.dto.OrderDTO;
import com.hyundai.pjt.dto.ResetPasswordInputDTO;
import com.hyundai.pjt.dto.ReviewDTO;
import com.hyundai.pjt.security.service.MemberContext;
import com.hyundai.pjt.service.MemberService;
import com.hyundai.pjt.service.MypageService;
import com.hyundai.pjt.service.OrderService;
import com.hyundai.pjt.service.ReviewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/mypage")
public class MypageController {

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MypageService mypageService;
	
	/* 마이페이지 메인 */
	@PostMapping("/mypageFloating")
	public String mypageFloating(@RequestParam("mid") String mid, Model model) {
		log.info("마이페이지 컨트롤러!!!");
		//주문내역 리스트 보내야 함
		List<MyorderDTO> order = mypageService.selectMyOrderList(mid);
		model.addAttribute("myOrderList", order);
		model.addAttribute("mid", mid);
		return "mypage/mypageFloatingPop";
	}
	
	/* 마이페이지 주문내역 */
	@PostMapping("/myOrders")
	public String myOrders(@RequestParam("mid") String mid, Model model) {
		log.info(">>>>>>>>>>> 마이페이지 주문내역 컨트롤러!!");
		List<MyorderDTO> order = mypageService.selectMyOrderList(mid);
		model.addAttribute("myOrderList", order);
		model.addAttribute("mid", mid);
		log.info("주문내역 column: " + model);
		return "mypage/myOrders";
	}

	/* 나의 리뷰내역 */
	@PostMapping("/myReview")
	public String myReview(@RequestParam("mid") String mid, Model model) {
		log.info(">>>>>>>>>>>>>> 마이페이지 리뷰내역 페이지로 이동");
		List<MyorderDTO> review = mypageService.selectMyReviewList(mid);
		model.addAttribute("myReviewList", review);
		log.info("review는? " + model);
		return "mypage/myReview";
	}

	/* 마이 쿠폰내역 */
	@PostMapping("/myCoupon")
	public String myCoupon(@RequestParam("mid") String mid, Model model) {
		log.info(">>>>>>>>>>>>>> 마이페이지 쿠폰내역 페이지로 이동");
		return "mypage/myCoupon";
	}

	/* 비밀번호 찾기 페이지 이동 */
	@GetMapping("/findPw")
	public String findIdPw() {
		log.info("아이디 비번 찾기 페이지 진입");
		return "/member/findPw";
	}

	/* 비밀번호 찾기 */
	@PostMapping("/findPw")
	public String findPasswordSubmit(Model model, MemberDTO member) {
		boolean result = false;
		try {
			result = memberService.sendResetPassword(member);
		} catch (Exception e) {
		}
		model.addAttribute("result", result);
		return "member/find_password_result";
	}

	/* 비밀번호 초기화 페이지 이동 */
	@GetMapping("/reset/password")
	public String resetPassword(Model model, HttpServletRequest request) {
		String uuid = request.getParameter("id");
		model.addAttribute("uuid", uuid);
		return "member/reset_password";
	}

	/* 비밀번호 초기화 POST */
	@PostMapping("/reset/password")
	public String resetPasswordSubmit(Model model, MemberDTO member) {
		log.info("1" + member);
		MemberDTO mem = memberService.resetPassword(member.getMpassword());
		log.info("4" + mem);
		mem.setMpassword(passwordEncoder.encode(member.getResetPasswordKey()));
		log.info(mem);
		memberService.changeInfo(mem);
		log.info("6");

		return "redirect:/member/CustomLogin";
	}

}
