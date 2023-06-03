package com.hyundai.pjt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyundai.pjt.dto.CartDTO;
import com.hyundai.pjt.mapper.CartMapper;

@Service
public class CartService {

	@Autowired
	private CartMapper mapper;
	
	public void updateCart(CartDTO dto) {
		mapper.updateCart(dto);
	}
	
	public void deleteCart(CartDTO dto) {
		mapper.deleteCart(dto);
	}
	
	public List<CartDTO> cartList(String mid){
		List<CartDTO> list = mapper.cartList(mid);
		return list;
	}
	
	public int cartCount(String mid) {
		int count = mapper.countCart(mid);
		return count;
	}
	
	public void deleteAllCartList(String mid) {
		mapper.deleteAllCartList(mid);
	}
	
	public void updateOption(CartDTO dto) {
		mapper.updateOption(dto);
	}
}
