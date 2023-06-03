package com.hyundai.pjt.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResetPasswordInputDTO {
	
	private String userId;
	private String userName;

}
