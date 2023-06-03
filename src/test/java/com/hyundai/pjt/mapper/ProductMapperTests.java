package com.hyundai.pjt.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.pjt.dto.BrandDTO;
import com.hyundai.pjt.dto.ProductDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class ProductMapperTests {

	@Autowired(required = true)
	private ProductMapper mapper;

	// 브랜드 목록
	@Test
	public void testSelectBrand() {

		log.info("Test selectBrand >>>>>");

		List<BrandDTO> list = mapper.selectBrand();

		log.info("Result selectBrand >>>>> " + list);
	}

	// 브랜드 이름
	@Test
	public void testSelectBrandInfo() {
		
		int bno = 1;
		
		log.info(mapper.selectBrandInfo(bno));
	}
	
	// 상품 세부
	@Test
	public void testSelectProduct() {

		log.info("Test selectProduct >>>>>");

//		String pid = "SJ2D1WPC012W";
		String pid = "MM2D1KTO001M_NY";

		log.info("Result selectProduct >>>>>" + mapper.selectProduct(pid));
	}

	// 상품 목록 - 신상품순
	@Test
	public void testSelectProdListNew() {
		
		log.info("Test selectProdListNew >>>>> ");
		
		String clarge = "남성";
		String cmedium = "";
		int startIdx = 13;
		int endIdx = 24;
		
		List<ProductDTO> list = mapper.selectProdListNew(clarge, cmedium, startIdx, endIdx);
		
		log.info("Result size : " + list.size());
		log.info("Result selectProdListNew >>>>> " + list);
	}
	
	// 상품 목록 - 판매순
	@Test
	public void testSelectProdListSale() {
		
		log.info("Test selectProdListSale >>>>> ");
		
		String clarge = "남성";
		String cmedium = "";
		int startIdx = 13;
		int endIdx = 24;
		
		List<ProductDTO> list = mapper.selectProdListSale(clarge, cmedium, startIdx, endIdx);
		
		log.info("Result size : " + list.size());
		log.info("Result selectProdListSale >>>>> " + list);
	}
	
	// 상품 목록 - 리뷰순
	@Test
	public void testSelectProdListReview() {
		
		log.info("Test selectProdListReview >>>>> ");
		
		String clarge = "남성";
		String cmedium = "";
		int startIdx = 13;
		int endIdx = 24;
		
		List<ProductDTO> list = mapper.selectProdListReview(clarge, cmedium, startIdx, endIdx);
		
		log.info("Result size : " + list.size());
		log.info("Result selectProdListReview >>>>> " + list);
	}
	
	// 상품 목록 - 고가순
	@Test
	public void testSelectProdListHigh() {
		
		log.info("Test selectProdListHigh >>>>> ");
		
		String clarge = "남성";
		String cmedium = "";
		int startIdx = 13;
		int endIdx = 24;
		
		List<ProductDTO> list = mapper.selectProdListHigh(clarge, cmedium, startIdx, endIdx);
		
		log.info("Result size : " + list.size());
		log.info("Result selectProdListHigh >>>>> " + list);
	}
	
	// 상품 목록 - 저가순
	@Test
	public void testSelectProdListLow() {
		
		log.info("Test selectProdListLow >>>>> ");
		
		String clarge = "남성";
		String cmedium = "";
		int startIdx = 13;
		int endIdx = 24;
		
		List<ProductDTO> list = mapper.selectProdListLow(clarge, cmedium, startIdx, endIdx);
		
		log.info("Result size : " + list.size());
		log.info("Result selectProdListLow >>>>> " + list);
	}	
	
	// 카테고리 목록
	@Test
	public void testSelectCategory() {
		
		log.info("Test selectCategory >>>>>>");
		
		String clarge = "여성";
		
		log.info("Result selectCategory >>>>>" + mapper.selectCategoryList(clarge));
	}
	
	// 카테고리별 상품 전체 개수
	@Test
	public void testProductCnt() {
		
		log.info("Test productCnt >>>>> ");
		
		String clarge = "여성";
		String cmedium = "아우터";
		
		log.info("Result productCnt >>>>> " + mapper.productCnt(clarge, cmedium));
		
	}
	
	// 브랜드별 상품 전체 개수
	@Test
	public void testBrandProdCnt() {
		
		int bno = 1;
		
		log.info(mapper.brandProdCnt(bno));
	}
	
	// 브랜드별 탑 셀러
	@Test
	public void testBrandTopSeller() {
		
		int bno = 1;
		
 		List<ProductDTO> list = mapper.brandTopSeller(bno);
 		
		log.info("size : " + list.size());
		log.info(list);
		
	}
	
	// 브랜드별 상품 목록 - 신상품순
	@Test
	public void testSelectBProdListNew() {
			
		int rno = 1;
		int startIdx = 1;
		int endIdx = 12;
			
		List<ProductDTO> list = mapper.selectBProdListNew(rno, startIdx, endIdx);
			
		log.info("Result size : " + list.size());
		log.info("Result >>>>> " + list);
	}	
	
	// 브랜브별 상품 목록 - 판매순
	@Test
	public void testSelectBProdListSale() {
				
		int rno = 1;
		int startIdx = 1;
		int endIdx = 12;
				
		List<ProductDTO> list = mapper.selectBProdListSale(rno, startIdx, endIdx);
				
		log.info("Result size : " + list.size());
		log.info("Result >>>>> " + list);
	}		
	
	// 브랜브별 상품 목록 - 리뷰순
	@Test
	public void testSelectBProdListReview() {
					
		int rno = 1;
		int startIdx = 1;
		int endIdx = 12;
					
		List<ProductDTO> list = mapper.selectBProdListReview(rno, startIdx, endIdx);
					
		log.info("Result size : " + list.size());
		log.info("Result >>>>> " + list);
	}	
	
	// 브랜브별 상품 목록 - 고가순
	@Test
	public void testSelectBProdListHigh() {
					
		int rno = 1;
		int startIdx = 1;
		int endIdx = 12;
					
		List<ProductDTO> list = mapper.selectBProdListHigh(rno, startIdx, endIdx);
					
		log.info("Result size : " + list.size());
		log.info("Result >>>>> " + list);
	}
	
	// 브랜브별 상품 목록 - 저가순
	@Test
	public void testSelectBProdListLow() {
					
		int rno = 1;
		int startIdx = 1;
		int endIdx = 12;
					
		List<ProductDTO> list = mapper.selectBProdListLow(rno, startIdx, endIdx);
					
		log.info("Result size : " + list.size());
		log.info("Result >>>>> " + list);
	}
	
}
