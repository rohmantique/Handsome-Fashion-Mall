package com.hyundai.pjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyundai.pjt.dto.BrandDTO;
import com.hyundai.pjt.dto.CategoryDTO;
import com.hyundai.pjt.dto.ProductDTO;

@Mapper
public interface ProductMapper {
	
	// 브랜드 목록
	public List<BrandDTO> selectBrand();
	
	// 브랜드 정보
	public BrandDTO selectBrandInfo(int bno);
	
	// 카테고리 목록
	public List<CategoryDTO> selectCategoryList(String clarge);
	
	// 카테고리별 상품 전체 개수
	public int productCnt(String clarge, String cmedium);
	
	// 상품 목록 - 신상품순
	public List<ProductDTO> selectProdListNew(String clarge, String cmedium, int startIdx, int endIdx);
	
	// 상품 목록 - 판매순
	public List<ProductDTO> selectProdListSale(String clarge, String cmedium, int startIdx, int endIdx);

	// 상품 목록 - 리뷰순
	public List<ProductDTO> selectProdListReview(String clarge, String cmedium, int startIdx, int endIdx);
	
	// 상품 목록 - 고가순
	public List<ProductDTO> selectProdListHigh(String clarge, String cmedium, int startIdx, int endIdx);
	
	// 상품 목록 - 저가순
	public List<ProductDTO> selectProdListLow(String clarge, String cmedium, int startIdx, int endIdx);
	
	// 브랜드별 상품 목록 - 신상품순
	public List<ProductDTO> selectBProdListNew(int bno, int startIdx, int endIdx);
	
	// 브랜드별 상품 목록 - 판매순
	public List<ProductDTO> selectBProdListSale(int bno, int startIdx, int endIdx);
	
	// 브랜드별 상품 목록 - 리뷰순
	public List<ProductDTO> selectBProdListReview(int bno, int startIdx, int endIdx);
	
	// 브랜드별 상품 목록 - 고가순
	public List<ProductDTO> selectBProdListHigh(int bno, int startIdx, int endIdx);
	
	// 브랜드별 상품 목록 - 저가순
	public List<ProductDTO> selectBProdListLow(int bno, int startIdx, int endIdx);

	// 상품 세부
	public ProductDTO selectProduct(String pid);
	
	// 브랜드별 상품 전체 개수
	public int brandProdCnt(int bno);
	
	// 브랜드별 탑 셀러
	public List<ProductDTO> brandTopSeller(int bno);

}