package com.hyundai.pjt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.pjt.mapper.ProductMapper;
import com.hyundai.pjt.dto.BrandDTO;
import com.hyundai.pjt.dto.CategoryDTO;
import com.hyundai.pjt.dto.ProductDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper mapper;
	
	// 브랜드 목록
	@Override
	public List<BrandDTO> selectBrand() {

		return mapper.selectBrand();
	}
	
	// 브랜드 이름
	@Override
	public BrandDTO selectBrandInfo(int bno) {
			
		return mapper.selectBrandInfo(bno);
	}	

	// 상품 세부
	@Override
	public ProductDTO selectProduct(String pid) {
		
		return mapper.selectProduct(pid);
	}

	// 카테고리 목록
	@Override
	public List<CategoryDTO> selectCategoryList(String clarge) {

		return mapper.selectCategoryList(clarge);
	}

	// 상품 목록(정렬)
	@Override
	public List<ProductDTO> selectProdListOrder(String clarge, String cmedium, String order) {
		
		List<ProductDTO> list = null;
		
		if(order.equals("NEW")) {
			list = mapper.selectProdListNew(clarge, cmedium, 1, 12);
		}else if(order.equals("SALES")) {
			list = mapper.selectProdListSale(clarge, cmedium, 1, 12);
		}else if(order.equals("REVIEW")) {
			list = mapper.selectProdListReview(clarge, cmedium, 1, 12);
		}else if(order.equals("HIGH")) {
			list = mapper.selectProdListHigh(clarge, cmedium, 1, 12);
		}else if(order.equals("LOW")) {
			list = mapper.selectProdListLow(clarge, cmedium, 1, 12);
		}
		
		return list;
	}

	// 상품 페이징(무한 스크롤)
	@Override
	public List<ProductDTO> selectAddProdList(String clarge, String cmedium, String order, int startIdx, int endIdx) {

		List<ProductDTO> list = null;
		
		if(order.equals("NEW")) {
			list = mapper.selectProdListNew(clarge, cmedium, startIdx, endIdx);
		}else if(order.equals("SALES")) {
			list = mapper.selectProdListSale(clarge, cmedium, startIdx, endIdx);
		}else if(order.equals("REVIEW")) {
			list = mapper.selectProdListReview(clarge, cmedium, startIdx, endIdx);
		}else if(order.equals("HIGH")) {
			list = mapper.selectProdListHigh(clarge, cmedium, startIdx, endIdx);
		}else if(order.equals("LOW")) {
			list = mapper.selectProdListLow(clarge, cmedium, startIdx, endIdx);
		}
		
		return list;
	}
	
	// 카테고리별 상품 전체 개수
	@Override
	public int productCnt(String clarge, String cmedium) {
		
		return mapper.productCnt(clarge, cmedium);
	}

	// 브랜드별 상품 전체 개수
	@Override
	public int brandProdCnt(int bno) {

		return mapper.brandProdCnt(bno);
	}

	// 브랜드별 탑 셀러
	@Override
	public List<ProductDTO> brandTopSeller(int bno) {

		return mapper.brandTopSeller(bno);
	}

	// 브랜드별 상품 목록(정렬)
	@Override
	public List<ProductDTO> selectBProdListOrder(int bno, String order) {

		List<ProductDTO> list = null;
		
		if(order.equals("NEW")) {
			list = mapper.selectBProdListNew(bno, 1, 12);
		}else if(order.equals("SALES")) {
			list = mapper.selectBProdListSale(bno, 1, 12);
		}else if(order.equals("REVIEW")) {
			list = mapper.selectBProdListReview(bno, 1, 12);
		}else if(order.equals("HIGH")) {
			list = mapper.selectBProdListHigh(bno, 1, 12);
		}else if(order.equals("LOW")) {
			list = mapper.selectBProdListLow(bno, 1, 12);
		}
		
		return list;
	}

	// 브랜드별 상품 페이징(무한 스크롤)
	@Override
	public List<ProductDTO> selectBAddProdList(int bno, String order, int startIdx, int endIdx) {

		List<ProductDTO> list = null;
		
		if(order.equals("NEW")) {
			list = mapper.selectBProdListNew(bno, startIdx, endIdx);
		}else if(order.equals("SALES")) {
			list = mapper.selectBProdListSale(bno, startIdx, endIdx);
		}else if(order.equals("REVIEW")) {
			list = mapper.selectBProdListReview(bno, startIdx, endIdx);
		}else if(order.equals("HIGH")) {
			list = mapper.selectBProdListHigh(bno, startIdx, endIdx);
		}else if(order.equals("LOW")) {
			list = mapper.selectBProdListLow(bno, startIdx, endIdx);
		}
		
		return list;
	}
	
	
	
	
}
