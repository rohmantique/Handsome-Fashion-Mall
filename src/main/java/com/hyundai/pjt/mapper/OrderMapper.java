package com.hyundai.pjt.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hyundai.pjt.dto.MemberDTO;
import com.hyundai.pjt.dto.OrderDTO;

@Mapper
public interface OrderMapper {

	public void insertOrderList(OrderDTO dto);
	
	public void insertOrderItem(OrderDTO dto);
	
	public MemberDTO userSelect(String mid);
	
	public void updateProductOrder(String pid);
	
	public void updateMemberPoint(String mid, int point);
}
