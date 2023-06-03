package com.hyundai.pjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyundai.pjt.dto.MyorderDTO;
import com.hyundai.pjt.dto.ReviewDTO;

@Mapper
public interface MypageMapper {

	//유저별(mid) 리뷰내역 조회
	public List<MyorderDTO> selectMyReviewList(String mid);
	
	//회원pk별, 주문pk별 주문내역(상품정보) 조회
	public List<MyorderDTO> selectMyOrderList(String mid);
	
}
