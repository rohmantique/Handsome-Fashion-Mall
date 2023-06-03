package com.hyundai.pjt.security.dto;


import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AuthMemberDTO extends User {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	public AuthMemberDTO(String username, String password, List<? extends GrantedAuthority> authorities) {
		super (username, password, authorities);
		this.id = username;
	}
	

}