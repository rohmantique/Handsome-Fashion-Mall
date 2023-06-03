package com.hyundai.pjt.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log4j2
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//	 implements ExceptionProcessor
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
        log.debug("CustomAuthenticationSuccessHandler.onAuthenticationSuccess ::::");
        /*
         * 쿠키에 인증 토큰을 넣어준다.
         */
        super.onAuthenticationSuccess(request, response, authentication);
    }
 
//    @Override
//    public void makeExceptionResponse(HttpServletRequest request, HttpServletResponse response,
//            Exception exception) {
//    }
    
}