package com.hyundai.pjt.controller;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class UploadController {

	@Value("${com.hyundai.upload.path}")
	private String uploadPath;
	
	@GetMapping("/display")
	public ResponseEntity<byte[]> getFile(String fileName) {
				
		ResponseEntity<byte[]> result = null;
		try {
			// 브라우저에서 파일이름이 오기때문에 디코딩
			String srcFileName = URLDecoder.decode(fileName, "UTF-8");
			// log.info(srcFileName);
			File file = new File(uploadPath + File.separator + srcFileName);
			// log.info(file);
			// 헤더 생성 브라우져에 보내야 하므로
			HttpHeaders headers = new HttpHeaders();
			// 헤더에 콘텐츠 타입 설정
			headers.add("Content-Type", Files.probeContentType(file.toPath()));
			//
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// 500번 에러 보냄
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} // end try

		return result;
	}//
}
