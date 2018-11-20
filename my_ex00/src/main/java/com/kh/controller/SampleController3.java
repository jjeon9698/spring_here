package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.domain.ProductVo;

@Controller
public class SampleController3 {

	@RequestMapping("/doE")
	public String doE(Model model) {
		ProductVo vo = new ProductVo("정장", 300);
		model.addAttribute("vo", vo);
		
		return "productDetail";
	}
}
