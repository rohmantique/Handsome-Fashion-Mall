package com.hyundai.pjt.dto;

import lombok.Data;

@Data
public class ReviewProdDTO {

	private int oid;
	private String pid;
	private String mid;
	private String pname;
	private String ccolorcode;
	private String ssize;
	private int oamount;
	private int opayment;
	private String rstatus;
	private String cimage1;
	private String odate;
	private String bname;
	private String cmatchpid;
	
	private String url = oid + "_" + pid + "_" + ccolorcode + "_" + ssize;
}
