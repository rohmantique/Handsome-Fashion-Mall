package com.hyundai.pjt.service;

import java.util.List;

import com.hyundai.pjt.dto.MyorderDTO;
import com.hyundai.pjt.dto.ReviewDTO;

public interface MypageService {
	
	//유저별(mid) 주문내역 조회
	public List<MyorderDTO> selectMyOrderList(String mid);
	
	//유저별(mid) 리뷰내역 조회
	public List<MyorderDTO> selectMyReviewList(String mid);
	
	//유저별(mid) 쿠폰내역 조회

}
