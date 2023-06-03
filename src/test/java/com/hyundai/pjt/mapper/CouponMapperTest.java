package com.hyundai.pjt.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class CouponMapperTest {
	
	@Autowired
	CouponMapper mapper;
	
	@Test
	public void selectCouponTest() {
		log.info(mapper.selectCoupon("user11", 0));
	}
	
	@Test
	public void deleteCouponTest() {
		String mid = "user11";
		int eid = 3;
		mapper.deleteCoupon(mid, eid);
	}
	
	@Test
	public void deleteEventTest() {
		int eid = 3;
		mapper.deleteEvent(eid);
	}

}
