package com.hyundai.pjt.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class ProductServiceTests {
	
	@Autowired
	private ProductService service;
	
	// 브랜드 목록
	@Test
	public void testSelectBrand() {
		
		log.info("Test service selectBrand >>>>> ");
		
		log.info("Result selectBrand >>>>> " + service.selectBrand());
	}
}
