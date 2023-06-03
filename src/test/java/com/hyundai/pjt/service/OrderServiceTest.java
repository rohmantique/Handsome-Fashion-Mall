package com.hyundai.pjt.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hyundai.pjt.dto.OrderDTO;

@SpringBootTest
public class OrderServiceTest {

	@Autowired
	private OrderService service;
	
	@Test
	public void orderInsertTest() {
		OrderDTO order = new OrderDTO();
		order.setMid("user11");
		order.setOzipcode("01826");
		order.setOaddress1("주소1");
		order.setOaddress2("주소2");
		order.setOreceiver("받는사람");
		order.setOtel("010-0000-0000");
		order.setOusedmileage("0");
		order.setOusedcoupon("2");
		order.setOpayment(318000);
		order.setOdiscounted(10);
		order.setPid("MM2D1KTO001M");
		order.setCcolorcode("NY");
		order.setSsize("XL");
		order.setOamount(2);
		service.insertOrderList(order);
		service.insertOrderItem(order);
	}
	
	@Test
	public void orderItemTest() {
		OrderDTO order = new OrderDTO();
		order.setOid(23);
		order.setPid("MM2D1KTO001M");
		order.setCcolorcode("NY");
		order.setSsize("XL");
		order.setOamount(2);
		service.insertOrderItem(order);
	}
	
	@Test
	public void updateMemberPointTest() {
		String mid ="user11";
		int point = 3000;
		service.updateMemberPoint(mid, point);
	}
	
	
}
