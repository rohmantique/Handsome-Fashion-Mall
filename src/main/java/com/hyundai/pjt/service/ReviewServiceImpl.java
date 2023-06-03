package com.hyundai.pjt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.pjt.dto.ProductDTO;
import com.hyundai.pjt.dto.ReviewDTO;
import com.hyundai.pjt.dto.ReviewProdDTO;
import com.hyundai.pjt.mapper.ReviewMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper mapper;

	// 리뷰 작성
	@Override
	public void writeReview(ReviewDTO review) {

		// insert into data from review table
		mapper.insertReview(review);
		
		// insert into data from reviewInfo table
		mapper.insertReviewInfo(review);
		
		// insert into image data from reviewImg table
		mapper.insertReivewImg(review);
		
	}

	// 구매 상품 정보 select
	@Override
	public ProductDTO orderProduct(String orderItem) {
		
		String[] order = orderItem.split("_");
		String pid = order[1];
		String ccolorcode = order[2];

		return mapper.selectOrderProduct(pid, ccolorcode);
	}

	// 전체 리뷰 목록
	@Override
	public List<ReviewDTO> selectAllReview() {

		return mapper.selectAllReview();
	}

	// 상품별 리뷰 조회
	@Override
	public List<ReviewDTO> selectProReview(String pid) {

		return mapper.selectProReview(pid);
	}

	// 리뷰 삭제
	@Override
	public void deleteReview(String mid, int rno) {
		
		mapper.deleteReview(mid, rno);
	}

	// 작성 가능한 리뷰 목록 조회
	@Override
	public List<ReviewProdDTO> selectReviewProdList(String mid) {

		return mapper.selectReviewProdList(mid);
	}
	
}
