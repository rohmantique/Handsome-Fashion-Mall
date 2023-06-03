package com.hyundai.pjt.security.handler;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log4j2
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String errMsg = "";
		
		if (exception instanceof BadCredentialsException) {
			errMsg = "아이디 또는 비밀번호가 맞지 않습니다. 다시 확인해주세요.";
		} else if (exception instanceof UsernameNotFoundException) {
			errMsg = "계정이 존재하지 않습니다. 회원가입을 진행해주세요.";
		} else {
			errMsg = "계정이 존재하지 않습니다. 회원가입을 진행해주세요.";
		}
		
		errMsg = URLEncoder.encode(errMsg, "UTF-8");
		log.info("########################## errMsg는 ??????????" + errMsg);
	}
	
}