package com.hyundai.pjt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hyundai.pjt.dto.CartDTO;
import com.hyundai.pjt.dto.CouponDTO;
import com.hyundai.pjt.dto.MemberDTO;
import com.hyundai.pjt.dto.OrderDTO;
import com.hyundai.pjt.mapper.CouponMapper;
import com.hyundai.pjt.service.CartService;
import com.hyundai.pjt.service.CouponService;
import com.hyundai.pjt.service.OrderService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class OrderController {

	@Autowired
	CouponService couponservice;

	@Autowired
	OrderService orderservice;

	@Autowired
	CouponMapper couponmapper;

	@Autowired
	CartService cartservice;

	@PostMapping("/orderComplete")
	public String orderConfirm(OrderDTO order, Model model) {
		String tel = order.getTel_num1() + order.getTel_num2() + order.getTel_num3();
		order.setOtel(tel);
		orderservice.insertOrderList(order);
		int oid = order.getOid();
		String mid = order.getMid();
		log.info(order);

		// orderitem insert
		List<OrderDTO> orderProductList = order.getOrderItemList();
		for (OrderDTO dto : orderProductList) {
			dto.setOid(oid);
			orderservice.insertOrderItem(dto);

			// 상품 주문 수량 증가
			String pid = dto.getPid();
			orderservice.updateProductOrder(pid);

			// 카트 삭제 
			CartDTO cart = new CartDTO();
			cart.setPid(pid);
			cart.setMid(mid);
			cart.setPsize(dto.getSsize());
			cart.setPcolor(dto.getCcolorcode());
			cartservice.deleteCart(cart);
			log.info(cart);

		}

		// deleteCoupon
		if (order.getOusedcoupon() != "") {
			int eid = Integer.parseInt(order.getOusedcoupon());
			couponmapper.deleteCoupon(mid, eid);
			//couponmapper.deleteEvent(eid);
		}

		// updatePoint
		if (order.getPoint() > 0) {
			int point = order.getPoint();
			orderservice.updateMemberPoint(mid, point);
		}

		model.addAttribute("order", order);

		return "order/orderComplete";
	}

	@GetMapping("/order")
	public String order() {
		return "order/order";
	}

	@PostMapping("/order")
	public String orderForm(CartDTO cart, Model model) {
		String mid = cart.getMid();
		List<CartDTO> cartlist = cart.getCartlist();
		List<CouponDTO> coupon = couponservice.couponList(mid, 0);
		MemberDTO user = orderservice.userInfo(mid);
		model.addAttribute("productlist", cartlist);
		model.addAttribute("couponlist", coupon);
		model.addAttribute("user", user);
		return "order/order";
	}

	@GetMapping("/address")
	public String orderAddress() {
		return "order/new_address";
	}

}
