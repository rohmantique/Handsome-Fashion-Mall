/**
 * @function : CartController
 * @author : Hansol Lee
 * @Date : Jan 10. 2023.
 * 카트 컨트롤러
**/
package com.hyundai.pjt.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyundai.pjt.dto.CartDTO;
import com.hyundai.pjt.service.CartService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class CartController {
	
	@Autowired
	CartService service;

	
	@GetMapping("/cart")
	public String Cart(Model model, Principal prin) {
		String dto = prin.getName();
		
		String[] tmp = dto.split(",");
		String mid = tmp[0].replace("MemberDTO(mid=", "");
		
		log.info("mid : " + mid);
		model.addAttribute("cartList", service.cartList(mid));
		model.addAttribute("count", service.cartCount(mid));
		return "cart/cart";
	}
	
	@PostMapping("/cartlist")
	@ResponseBody
	public ResponseEntity<List<CartDTO>> cartList(@RequestParam("mid") String mid) {
		return new ResponseEntity<>(service.cartList(mid),HttpStatus.OK);
	}
	
	@PostMapping("/removeCart")
	@ResponseBody
	public void removeCart(@RequestParam("pid") String pid, @RequestParam("psize") String psize, @RequestParam("pcolor") String pcolor, @RequestParam("mid") String mid) {
		CartDTO dto = new CartDTO();
		dto.setPid(pid);
		dto.setPsize(psize);
		dto.setPcolor(pcolor);
		dto.setMid(mid);
		service.deleteCart(dto);
	}
	
	@PostMapping("/removeAllCart")
	@ResponseBody
	public void removeAllCart(@RequestParam("mid") String id) {
		service.deleteAllCartList(id);
	}
	
	@PostMapping("/modifyOption")
	@ResponseBody
	public ResponseEntity<CartDTO> modifyOption(@RequestParam("size") String size, @RequestParam("color") String color, @RequestParam("pid") String pid, @RequestParam("quantity") int quantity, @RequestParam("mid") String mid) {
		CartDTO dto = new CartDTO();
		dto.setPsize(size);
		dto.setPcolor(color);
		dto.setMid(mid);
		dto.setPid(pid);
		dto.setPamount(quantity);
		service.updateOption(dto);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@PostMapping("/cart")
	public String addCart(CartDTO cart) {
		service.updateCart(cart);
		return "cart/cart";
	}
}
