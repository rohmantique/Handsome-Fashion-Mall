package com.hyundai.pjt.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
@SpringBootTest
@Log4j2
public class CartMapperTest {

	@Autowired
	private CartMapper mapper;
	
	@Test
	public void cartListTest() {
		log.info(mapper.cartList("user11"));
	}
	
}
