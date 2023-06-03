package com.hyundai.pjt.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log4j2
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{
    
    @Override    
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        log.debug("CustomLogoutSuccessHandler.onLogoutSuccess ::::");
        super.onLogoutSuccess(request, response, authentication);
    }
    
}