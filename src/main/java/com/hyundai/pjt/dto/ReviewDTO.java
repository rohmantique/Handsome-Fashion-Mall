package com.hyundai.pjt.dto;

import java.util.List;

import lombok.Data;

@Data
public class ReviewDTO {
	
	private int rno;
	
	private String mid;
	private String mname;
	
	private String pid;
	private String pname;
	private String pcolor;
	private String psize;
	private String cmatchpid;
	private String cimage1;
	private String bname;
	private int pprice;
	
	private String rdate;
	private int rrate;
	private int rprice;
	private int rcomfortable;
	private String rtitle;
	private String rcontent;
	private String rage;
	private String rheight;
	private String rform;
	private String rsize;
	
	private String reviewFile1;
	private String reviewFile2;
	private String reviewFile3;
	
}
