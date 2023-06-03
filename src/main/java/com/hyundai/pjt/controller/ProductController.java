package com.hyundai.pjt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyundai.pjt.dto.BrandDTO;
import com.hyundai.pjt.dto.CategoryDTO;
import com.hyundai.pjt.dto.ProductDTO;
import com.hyundai.pjt.dto.ReviewDTO;
import com.hyundai.pjt.service.ProductService;
import com.hyundai.pjt.service.ReviewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private ReviewService rService;
	
	// 카테고리 페이지로 이동
	@GetMapping("/category")
	public String category(Model model) {
		
		List<BrandDTO> list = service.selectBrand();
		
		model.addAttribute("list", list);
		
		return "product/category";
	}
	
	// 상품 목록 페이지로 이동(브랜드)
	@GetMapping("/brList/{brand}")
	public String productBrList(@PathVariable("brand") String brand, Model model) {
		
		int bno = Integer.parseInt(brand.substring(2,4));
		
		model.addAttribute("brand", service.selectBrandInfo(bno));
		model.addAttribute("bProCnt", service.brandProdCnt(bno));
		model.addAttribute("topList", service.brandTopSeller(bno));
		
		return "product/brList";
	}

	// 상품 목록 페이지로 이동(카테고리)
	@GetMapping("/list/{cate}")
	public String productList(@PathVariable("cate") String cate, Model model) {
		
		String clarge = cate.substring(0, 2);
		String cmedium = cate.length() > 2 ? cate.substring(2, 4) : "";
		
		model.addAttribute("cate", cate);
		model.addAttribute("clarge", clarge);
		
		String[] cateNames = chgCateName(clarge, cmedium);
		clarge = cateNames[0];
		cmedium = cateNames[1];
		
		List<CategoryDTO> cateList = service.selectCategoryList(clarge);
		int proCnt = service.productCnt(clarge, cmedium);
		
		model.addAttribute("cateList", cateList);
		model.addAttribute("proCnt", proCnt);
		model.addAttribute("cmedium", cmedium);
		
		return "product/list";
	}
	
	// 상품 리스트 정렬(ajax)
	@PostMapping("/orderList")
	@ResponseBody
	public List<ProductDTO> prodOrderList(@RequestParam("cate") String cate, @RequestParam("order") String order){
	
		String clarge = cate.substring(0, 2);
		String cmedium = cate.length() > 2 ? cate.substring(2, 4) : "";
		
		// 카테고리 이름 변경
		String[] cateNames = chgCateName(clarge, cmedium);
		clarge = cateNames[0];
		cmedium = cateNames[1];
		
		List<ProductDTO> list = service.selectProdListOrder(clarge, cmedium, order);
		
		return list;
	}
	
	// 브랜드별 상품 리스트 정렬(ajax)
	@PostMapping("/bOrderList")
	@ResponseBody
	public List<ProductDTO> bProdcOrderList(@RequestParam("bno") int bno, @RequestParam("order") String order){
		
		List<ProductDTO> list = service.selectBProdListOrder(bno, order);
		
		return list;
	}
	
	// 상품 페이징(무한 스크롤/ajax)
	@PostMapping("/addList")
	@ResponseBody
	public List<ProductDTO> addProdList(@RequestParam("cate") String cate, @RequestParam("order") String order, @RequestParam("startIdx") int startIdx, @RequestParam("endIdx") int endIdx){
		
		String clarge = cate.substring(0, 2);
		String cmedium = cate.length() > 2 ? cate.substring(2, 4) : "";
		
		// 카테고리 이름 변경
		String[] cateNames = chgCateName(clarge, cmedium);
		clarge = cateNames[0];
		cmedium = cateNames[1];
		
		List<ProductDTO> list = service.selectAddProdList(clarge, cmedium, order, startIdx, endIdx);
		
		return list;
	}
	
	// 브랜드별 상품 페이징(무한 스크롤/ajax)
	@PostMapping("/bAddList")
	@ResponseBody
	public List<ProductDTO> bAddProdList(@RequestParam("bno") int bno, @RequestParam("order") String order, @RequestParam("startIdx") int startIdx, @RequestParam("endIdx") int endIdx){
		
		List<ProductDTO> list = service.selectBAddProdList(bno, order, startIdx, endIdx);
		
		return list;
	}
	
	// 상품 세부 페이지로 이동
	@GetMapping("/detail/{cmatchpid}")
	public String productDetail(@PathVariable("cmatchpid") String cmatchpid, Model model) {
		
		String pid = cmatchpid.split("_")[0];
		String color = cmatchpid.split("_")[1];

		ProductDTO dto = service.selectProduct(pid);
		
		model.addAttribute("cmatchpid", cmatchpid);
		model.addAttribute("color", color);
		model.addAttribute("product", dto);
		
		// 리뷰 목록
		List<ReviewDTO> reviewList = rService.selectProReview(pid);
		
		int sumRate = 0;
		int avgRate = 0;
		if(reviewList.size() > 0) {
			for(int i=0; i<reviewList.size(); i++) {
				sumRate += reviewList.get(i).getRrate();
			}
			avgRate = sumRate/reviewList.size();
		}
		
		model.addAttribute("avgRate", avgRate);
		model.addAttribute("reviewList", reviewList);
		
		return "product/detail";
	}
	
	// 카테고리 이름 변경하는 메서드
	public String[] chgCateName(String clarge, String cmedium) {
		String[] cateNames = new String[2];
		
		if(clarge.equals("we")) {
			clarge = "여성";
		}else if(clarge.equals("me")) {
			clarge = "남성";
		}else if(clarge.equals("as")) {
			clarge = "잡화";
		}
		
		if(cmedium.equals("01")) {
			cmedium = "아우터";
		}else if(cmedium.equals("02")) {
			cmedium = "탑";
		}else if(cmedium.equals("03")) {
			cmedium = "팬츠";
		}
		
		cateNames[0] = clarge;
		cateNames[1] = cmedium;
		
		return cateNames;
		
	}
	
	

}
