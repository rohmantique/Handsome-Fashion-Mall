package com.hyundai.pjt.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class MyorderDTO {
	
	private String mid;
	private String oid;
	private int ozipcode;
	private String oaddress1;
	private String oaddress2;
	private Date odate;
	private String oreceiver;
	private String otel;
	private int ousedmileage;
	private int ousedcoupon;
	private int opayment;
	private int ostatus;
	private Date oaccountdeadline;
	private int odiscounted;
	
	private List<MyorderitemDTO> itemList;

}
