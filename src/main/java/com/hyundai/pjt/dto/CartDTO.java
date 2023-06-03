package com.hyundai.pjt.dto;

import java.util.List;

import lombok.Data;
@Data
public class CartDTO {
	
	private String mid;
	private String pid;
	private String psize;
	private String pcolor;          
	private int pamount;
	private String bname;
	private String cimage1;
	private String pname;
	private int pprice;
	private int count;
	private String colorcode;
	private String totalPrice;
	
	private List<ColorDTO> colorlist;
	private List<StockDTO> stocklist;
	private List<CartDTO> cartlist;
	
}
