package com.hyundai.pjt.security.service;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.hyundai.pjt.dto.MemberDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MemberContext extends User {

	private final MemberDTO member;

	public MemberContext(MemberDTO member, Collection<? extends GrantedAuthority> authorities) {
		super(member.getMid(), member.getMpassword(), authorities);
		this.member = member;
		log.info("member는?????" +  member);
	}

	public MemberDTO getMember() {
		return member;
	}

   public String getUsername() {
      //userName 반환하는
      return member.getMid();
   }


}