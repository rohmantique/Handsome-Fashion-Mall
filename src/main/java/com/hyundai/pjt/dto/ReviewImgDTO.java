package com.hyundai.pjt.dto;

import java.io.Serializable;
import java.net.URLEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewImgDTO implements Serializable{

	private String fileName;
	private String uuid;
	private String folderPath;
	
	public String getImageURL() {
		try {
			return URLEncoder
					.encode(folderPath + "/" + uuid + "_" + fileName, "UTF-8");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}
}
