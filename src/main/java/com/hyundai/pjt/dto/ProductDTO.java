package com.hyundai.pjt.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductDTO {
	
	private String cimage1;
	private int price;
	private String colorimage;
	private String pid;
	private int pno;
	private String pname;
	private int pprice;
	private String pdetail;
	private String pseason;
	
	private int ptotalamount;
	
	// 브랜드
	private int bno;
	private String bname;
	
	// 카테고리
	private String clarge;
	private String cmedium;
	private String csmall;
	
	// 색
	private List<ColorDTO> colorList;
	
	// 사이즈
	private List<StockDTO> stockList;
	
	// 리뷰수
	private int rcnt;
	
}
