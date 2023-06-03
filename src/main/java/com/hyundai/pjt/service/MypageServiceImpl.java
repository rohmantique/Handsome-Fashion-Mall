package com.hyundai.pjt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.pjt.dto.MyorderDTO;
import com.hyundai.pjt.mapper.MypageMapper;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired
	private MypageMapper mapper;

	// 유저별 주문내역 조회
	@Override
	public List<MyorderDTO> selectMyOrderList(String mid) {
		return mapper.selectMyOrderList(mid);
	}
	
	// 유저별 리뷰내역 조회
	@Override
	public List<MyorderDTO> selectMyReviewList(String mid) {
		return mapper.selectMyReviewList(mid);
	}
	
}
