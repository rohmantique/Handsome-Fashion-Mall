package com.hyundai.pjt.dto;

import lombok.Data;

@Data
public class CouponDTO {
	
	private String ccode;
	private int eid;
	private String cname;
	private String cstartdate;
	private String cenddate;
	private int cstate;
	private int eamount;
	private int price;

}
