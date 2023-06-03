package com.hyundai.pjt.service;

import java.util.List;

import com.hyundai.pjt.dto.BrandDTO;
import com.hyundai.pjt.dto.CategoryDTO;
import com.hyundai.pjt.dto.ProductDTO;

public interface ProductService {

	// 브랜드 목록
	public List<BrandDTO> selectBrand();
	
	// 브랜드 이름
	public BrandDTO selectBrandInfo(int bno);

	// 상품 세부
	public ProductDTO selectProduct(String pid);
	
	// 상품 목록(정렬)
	public List<ProductDTO> selectProdListOrder(String clarge, String cmedium, String order);
	
	// 상품 페이징(무한 스크롤)
	public List<ProductDTO> selectAddProdList(String clarge, String cmedium, String order, int startIdx, int endIdx);
	
	// 카테고리 목록
	public List<CategoryDTO> selectCategoryList(String clarge);

	// 카테고리별 상품 전체 개수
	public int productCnt(String clarge, String cmedium);
	
	// 브랜드별 상품 전체 개수
	public int brandProdCnt(int bno);
	
	// 브랜드별 탑 셀러
	public List<ProductDTO> brandTopSeller(int bno);
	
	// 브랜드별 상품 목록(정렬)
	public List<ProductDTO> selectBProdListOrder(int bno, String order);
	
	// 브랜드별 상품 페이징(무한 스크롤)
	public List<ProductDTO> selectBAddProdList(int bno, String order, int startIdx, int endIdx);
}