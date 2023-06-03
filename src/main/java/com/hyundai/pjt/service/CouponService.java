package com.hyundai.pjt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.pjt.dto.CouponDTO;
import com.hyundai.pjt.mapper.CouponMapper;

@Service
public class CouponService {

	@Autowired
	CouponMapper mapper;
	
	public List<CouponDTO> couponList(String mid, int cstate){
		return mapper.selectCoupon(mid, cstate);
	}
}
