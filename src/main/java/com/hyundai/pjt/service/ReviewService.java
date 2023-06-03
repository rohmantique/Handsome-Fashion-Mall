package com.hyundai.pjt.service;

import java.util.List;

import com.hyundai.pjt.dto.ProductDTO;
import com.hyundai.pjt.dto.ReviewDTO;
import com.hyundai.pjt.dto.ReviewProdDTO;

public interface ReviewService {

	// 리뷰 작성
	public void writeReview(ReviewDTO review);
	
	// 구매 상품 정보 select
	public ProductDTO orderProduct(String orderItem);
	
	// 전체 리뷰 목록
	public List<ReviewDTO> selectAllReview();
	
	// 상품별 리뷰 조회
	public List<ReviewDTO> selectProReview(String pid);
	
	// 리뷰 삭제
	public void deleteReview(String mid, int rno);
	
	// 작성 가능한 리뷰 목록 조회
	public List<ReviewProdDTO> selectReviewProdList(String mid);
}
