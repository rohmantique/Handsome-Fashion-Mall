package com.hyundai.pjt.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.pjt.dto.ReviewDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class ReviewServiceTests {

	@Autowired
	private ReviewService service;
	
	// 리뷰 작성
	@Test
	public void testWriteReview() {
		
		log.info("test service writeReview...");
		
		ReviewDTO review = new ReviewDTO();
		
		review.setMid("hee");
		review.setPid("MM2D1KTO001M");
		review.setPname("울 블렌드 니트 탑");
		review.setPcolor("NY");
		review.setPsize("L");
		review.setRrate(5);
		review.setRprice(318000);
		review.setRcontent("test service");
		review.setRage("30대");
		review.setRheight("170");
		review.setRform("보통");
		review.setRsize("55");
		
		service.writeReview(review);
		
	}
	
	// 구매 상품 정보
	@Test
	public void testOrderProduct() {
		String orderItem = "test_BA2D1ABS007W_GN_FREE";
		
		log.info(service.orderProduct(orderItem));
	}
	
	// 전체 리뷰 목록 select
	@Test
	public void testSelectAllReview() {
		
		List<ReviewDTO> list = service.selectAllReview();
		
		log.info(list);
		
		log.info(list.size());
	}
}
