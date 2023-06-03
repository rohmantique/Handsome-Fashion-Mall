package com.hyundai.pjt.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hyundai.pjt.dto.MemberDTO;
import com.hyundai.pjt.mapper.MemberMapper;

import lombok.extern.log4j.Log4j2;

@Service("UserDetailsService")
@Log4j2
public class HandsomeUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberMapper mapper;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		MemberDTO member = mapper.findById(username);
		if (member == null) {
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		log.info("=================member 객체는????????" + member);
		roles.add(new SimpleGrantedAuthority(member.getRole_set()));
		
		MemberContext memberContext = new MemberContext(member, roles);
		String userName = memberContext.getUsername();
		
		log.info("유저아이디는: " + userName);
		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        log.info("유저 정보는????????????" + user);

		return memberContext;
	}

}
