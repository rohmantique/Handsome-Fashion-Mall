package com.hyundai.pjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyundai.pjt.dto.CouponDTO;

@Mapper
public interface CouponMapper {
	
	public List<CouponDTO> selectCoupon(String mid, int cstate);
	
	public void deleteCoupon(String mid, int eid);
	
	public void deleteEvent(int eid);
}
