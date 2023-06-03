package com.hyundai.pjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyundai.pjt.dto.ProductDTO;
import com.hyundai.pjt.dto.ReviewDTO;
import com.hyundai.pjt.dto.ReviewProdDTO;

@Mapper
public interface ReviewMapper {

	// review 데이터 insert
	public void insertReview(ReviewDTO review);
	
	// reviewInfo 데이터 insert
	public void insertReviewInfo(ReviewDTO review);
	
	// reviewImg 데이터 insert
	public void insertReivewImg(ReviewDTO review);
	
	// 구매 상품 정보 select
	public ProductDTO selectOrderProduct(String pid, String ccolorcode);

	// 모든 리뷰 select
	public List<ReviewDTO> selectAllReview();
	
	// 상품별 리뷰 조회
	public List<ReviewDTO> selectProReview(String pid);

	// 리뷰 삭제
	public void deleteReview(String mid, int rno);
	
	// 작성 가능한 리뷰 목록 조회
	public List<ReviewProdDTO> selectReviewProdList(String mid);

}
