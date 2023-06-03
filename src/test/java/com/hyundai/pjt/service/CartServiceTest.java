package com.hyundai.pjt.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.pjt.dto.CartDTO;
import com.hyundai.pjt.service.CartService;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j2;
@SpringBootTest
@Log4j2
public class CartServiceTest {
	
	@Autowired
	private CartService cartservice;
	
	@Test
	public void insertCartTest() {
		CartDTO cart = new CartDTO();
		cart.setMid("user11");
		cart.setPid("MM2D1KTO001M");
		cart.setPsize("L");
		cart.setPcolor("NY");
		cart.setPamount(5);
		cartservice.updateCart(cart);
	}
	
	@Test
	public void deleteCartTest() {
		CartDTO cart = new CartDTO();
		cart.setMid("user11");
		cart.setPid("MM2D1KTO001M");
		cart.setPsize("S");
		cart.setPcolor("NY");
		cart.setPamount(1);
		cartservice.deleteCart(cart);
	}
	
	@Test
	public void cartListTest() {
		log.info(cartservice.cartList("user11"));
		log.info("size=" + cartservice.cartList("user11").size());
		
	}
	
	@Test
	public void updateOptionTest() {
		CartDTO cart = new CartDTO();
		cart.setPid("MN2D1KCD522W");
		cart.setPcolor("LV");
		cart.setPamount(3);
		cart.setPsize("90");
		cart.setMid("user11");
		cartservice.updateOption(cart);
	}

}
