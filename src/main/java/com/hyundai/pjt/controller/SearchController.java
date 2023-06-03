package com.hyundai.pjt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hyundai.pjt.mapper.SearchMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@AllArgsConstructor
public class SearchController {
	
	@Autowired
	SearchMapper mapper;

	@GetMapping("/search")
	public String search() {
		return "search/search";
	}
	
	
	@PostMapping("/searchList")
	public String searchAction(String search, Model model) {
		model.addAttribute("keyword", search);
		model.addAttribute("searchList",mapper.searchList(search));
		return "search/searchList";
	}
}
