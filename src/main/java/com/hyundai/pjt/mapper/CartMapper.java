package com.hyundai.pjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyundai.pjt.dto.CartDTO;

@Mapper
public interface CartMapper {
	
	public void updateCart(CartDTO cart);
	
	public void deleteCart(CartDTO cart);
	
	public List<CartDTO> cartList(String mid);
	
	public int countCart(String mid);
	
	public void deleteAllCartList(String mid);
	
	public void updateOption(CartDTO dto);
}
