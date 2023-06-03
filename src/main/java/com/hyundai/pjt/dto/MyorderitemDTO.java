package com.hyundai.pjt.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MyorderitemDTO {
	
	private String mid;
	private String oid;
	private String pid;
	private String pname;
	private String ccolorcode;
	private String cmatchpid;
	private String ssize;
	private int oamount;
	
	private String cimage1;
	private String rStatus;
	private Date rdate;
	private String rcontent;
	
	private String ozipcode;
	private String oaddress1;
	private String oaddress2;
	private String odate;
	private String oreceiver;
	private String otel;
	private String ousedmileage;
	private String ousedcoupon;
	private String opayment;
	private String ostatus;
	
}
