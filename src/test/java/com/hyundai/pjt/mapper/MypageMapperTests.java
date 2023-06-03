package com.hyundai.pjt.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.pjt.dto.MyorderDTO;
import com.hyundai.pjt.dto.MyorderitemDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class MypageMapperTests {

	@Autowired
	private MypageMapper mapper;
	
	//유저별 리뷰 상세 조회
	@Test
	public void testSelectMyReviewList() {
		String mid = "hee";
		List<MyorderDTO> list = mapper.selectMyReviewList(mid);
		log.info(list);
	}
	
//	//리뷰 상세
//	@Test
//	public void testSelectMyReviewItem() {
//		String mid="hee";
//		List<MyorderitemDTO> item = mapper.
//	}
	
	
	
	// 유저pk별, 주문pk별 주문내역 (상품 정보 조회)
	@Test
	public void testSelectMyOrderList() {
		String mid="hee";
		List<MyorderDTO> list = mapper.selectMyOrderList(mid);
		log.info("size : " + list.size());
		log.info(list);
		
		for(MyorderDTO l : list) {
			log.info(l.getOid());
		}
	}

}
