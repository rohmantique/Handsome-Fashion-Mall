package com.hyundai.pjt.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hyundai.pjt.security.service.MemberContext;

@Controller
public class SecurityController {

//    @GetMapping("/userInfo")
//    public ModelAndView currentUserName(@AuthenticationPrincipal MemberContext member) {
//        String username = member.getUsername();
//        ModelAndView mv = new ModelAndView();
//        mv.add
//        return username;
//
//    }
}