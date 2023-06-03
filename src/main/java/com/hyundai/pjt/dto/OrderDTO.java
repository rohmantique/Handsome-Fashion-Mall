package com.hyundai.pjt.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
	
	private int oid;
	private String mid;
	private String ozipcode;
	private String oaddress1;
	private String oaddress2;
	private String odate;
	private String oreceiver;
	private String otel;
	private String tel_num1;
	private String tel_num2;
	private String tel_num3;
	private String ousedmileage;
	private String ousedcoupon;
	private int opayment;
	private int ostatus;
	private String oaccountdeadline;
	private int odiscounted;
	
	private String pid;
	private String ccolorcode;
	private String ssize;
	private int oamount;
	private String cimage1;
	private int point;
	private String brand;
	private String pname;
	private String pprice;
	
	private List<OrderDTO> orderItemList;
	
}
