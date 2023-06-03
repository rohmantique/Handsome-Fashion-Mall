package com.hyundai.pjt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.pjt.dto.MemberDTO;
import com.hyundai.pjt.dto.OrderDTO;
import com.hyundai.pjt.mapper.OrderMapper;

@Service
public class OrderService {

	@Autowired OrderMapper order;
	
	public void insertOrderList(OrderDTO dto) {
		order.insertOrderList(dto);
	}
	
	public void insertOrderItem(OrderDTO dto) {
		order.insertOrderItem(dto);
	}
	
	public MemberDTO userInfo(String mid) {
		return order.userSelect(mid);
	}
	
	public void updateProductOrder(String pid) {
		order.updateProductOrder(pid);
	}
	
	public void updateMemberPoint(String mid, int point) {
		order.updateMemberPoint(mid, point);
	}
}
