package com.hyundai.pjt.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.pjt.dto.MyorderDTO;
import com.hyundai.pjt.dto.ReviewDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MypageServiceTests {

	@Autowired
	private MypageService service;

	// 나의 리뷰목록 출력
	@Test
	public void testSelectMyReview() {

		List<MyorderDTO> list = service.selectMyReviewList("hee");

		log.info(list);
		log.info(list.size());
	}

	// 나의 주문내역 출력
	@Test
	public void testSelectMyOrder() {
		List<MyorderDTO> list = service.selectMyOrderList("user11");
		log.info(list);
		log.info(list.size());
	}
}
