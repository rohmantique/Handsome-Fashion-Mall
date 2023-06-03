package com.hyundai.pjt.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDTO {

	private String mid;
	private String memail;
	private String mpassword;
	private String mname;
	private String mdate;

	private String year;

	private String month;
	private String day;

	private String mtel;
	
	private String mzipcode;
	private String maddress1;
	private String maddress2;
	
	private String maddress;
	
	private int mpoint;
	private int menabled;

	private String role_set;

//	private String mGrade;
//	private int mZipCode;
	
	private String resetPasswordKey;
	private LocalDateTime resetPasswordLimitDt;



}
