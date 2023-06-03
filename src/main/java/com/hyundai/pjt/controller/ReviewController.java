package com.hyundai.pjt.controller;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.hyundai.pjt.dto.ProductDTO;
import com.hyundai.pjt.dto.ReviewDTO;
import com.hyundai.pjt.dto.ReviewImgDTO;
import com.hyundai.pjt.dto.ReviewProdDTO;
import com.hyundai.pjt.service.ReviewService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/review/*")
public class ReviewController {

	@Autowired
	private ReviewService service;

	@Value("${com.hyundai.upload.path}")
	private String uploadPath;

	// 폴더 이름 만드는 함수
	private String makeFolder() {
		// 오늘 날자 생성패턴 대소문자 구분 주의
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// 날짜 구분
		String folderPath = str.replace("/", File.separator);
		// 폴더 생성
		File uploadPathFolder = new File(uploadPath, folderPath);
		if (uploadPathFolder.exists() == false) {
			uploadPathFolder.mkdirs();
		} // end if
		log.info(folderPath);
		return folderPath;
	}

	// 리뷰 작성 페이지
	@GetMapping("/write/{orderItem}")
	public String ReviewWrite(@PathVariable("orderItem") String orderItem, Model model) {

		ProductDTO oProd = service.orderProduct(orderItem);

		model.addAttribute("oProd", oProd);
		// orderItem -> oid_pid_ccolorcode_ssize
		model.addAttribute("oOption", orderItem.split("_"));

		return "review/write";
	}

	// 리뷰 작성 Action
	@PostMapping("/write")
	public ResponseEntity<String> ReviewWriteAction(ReviewDTO review,
			@RequestPart("reviewFile") List<MultipartFile> uploadFiles) {

		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));

		// 파일 업로드
		String[] fileList = { "", "", "" };
		int idx = 0;

		for (MultipartFile i : uploadFiles) {
			// 이미지 파일 검사
			if (i.getContentType().startsWith("image") == false) {
				log.warn("this file is not image type");
				break;
			}

			String originalName = i.getOriginalFilename();
			// 폴더 생성
			String folderPath = makeFolder();
			// uuid
			String uuid = UUID.randomUUID().toString();
			// 파일 이름 완성
			String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + originalName;
			// 경로 저장
			Path savePath = Paths.get(saveName);

			try {
				i.transferTo(savePath);
				ReviewImgDTO reviewImg = new ReviewImgDTO(originalName, uuid, folderPath);
				fileList[idx] = reviewImg.getImageURL();
				idx++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		review.setReviewFile1(fileList[0]);
		review.setReviewFile2(fileList[1]);
		review.setReviewFile3(fileList[2]);

		service.writeReview(review);

		try {
			String msg = "<script>location.href='/review/timeline';</script>";

			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

			String msg = "<script>alert('리뷰 등록에 실패하였습니다.'); history.back();</script>";

			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}

		return entity;

	}
	
	// 리뷰 삭제
	@PostMapping("/delete")
	public String deleteReview(@RequestParam("mid") String mid, @RequestParam("rno") int rno) {
		
		service.deleteReview(mid, rno);
		
		return "redirect:/review/timeline";
	}

	// 타임라인 페이지
	@GetMapping("/timeline")
	public String timeline(Model model) {

		List<ReviewDTO> review = service.selectAllReview();

		model.addAttribute("review", review);

		return "review/timeline";
	}
	
	// 주문한 상품 목록 조회 페이지
	@PostMapping("opList")
	public String orderProdList(@RequestParam("mid") String mid, Model model) {
		
		List<ReviewProdDTO> list = service.selectReviewProdList(mid);
		
		model.addAttribute("mid", mid);
		model.addAttribute("list", list);
		
		return "review/orderProdList"; 
	}

}
