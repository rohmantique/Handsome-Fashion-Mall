package com.hyundai.pjt.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.pjt.dto.ReviewDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class ReviewMapperTests {

	@Autowired
	private ReviewMapper mapper;
	
	// review 데이터 insert
	@Test
	public void testInsertReview() {
		
		log.info("Test insertReview.... ");
		
		ReviewDTO review = new ReviewDTO();
		
		review.setMid("hee");
		review.setPid("MM2D1KTO001M");
		review.setPname("울 블렌드 니트 탑");
		review.setPcolor("NY");
		review.setPsize("L");
		review.setRrate(5);
		review.setRprice(318000);
		review.setRcontent("test22!!");

		mapper.insertReview(review);
		
		log.info("Result insertReview pid : " + review.getRno());
	}
	
	// reviewInfo 데이터 insert
	@Test
	public void testInsertReviewInfo() {
		
		log.info("Test insertReviewInfo...");
		
		ReviewDTO review = new ReviewDTO();
		
		review.setRno(3);
		review.setRage("30대");
		review.setRheight("170");
		review.setRform("보통");
		review.setRsize("55");
		
		mapper.insertReviewInfo(review);
	}
	
	// reviewImg 데이터 insert
	@Test
	public void testInsertReviewImg() {
		
		log.info("Test insertReviewImg...");
		
		ReviewDTO review = new ReviewDTO();
		
		review.setRno(14);
		review.setReviewFile1("test1");
		review.setReviewFile2("test2");
		review.setReviewFile3("test3");
		
		mapper.insertReivewImg(review);
	}
	
	// 구매 상품 정보 select
	@Test 
	public void testSelectOrderProduct() {
		
		String mid = "BA2D1ABS007W";
		String ccolorcode = "GN";
		
		log.info(mapper.selectOrderProduct(mid, ccolorcode));
		
	}
	
	//모든 리뷰 select
	@Test
	public void testSelectAllReview() {
		
		List<ReviewDTO> list = mapper.selectAllReview();
		
		log.info(list);
		log.info("list size : " + list.size());
		
	}
	
	// 상품별 리뷰 조회
	@Test
	public void testSelectProReview() {
		
		String pid = "MM2D1KTO001M";
		
		log.info(mapper.selectProReview(pid));
	}

	// 리뷰 삭제
	@Test
	public void testDeleteReview() {
		
		String mid = "hee";
		int rno = 20;
		
		mapper.deleteReview(mid, rno);
		
	}
	
	// 작성 가능한 리뷰 목록 조회
	@Test
	public void testSelectReviewProdList() {
		
		String mid = "hee";
		
		log.info(mapper.selectReviewProdList(mid));
	}
}
