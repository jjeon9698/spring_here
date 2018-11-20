package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {
	
	@RequestMapping("/doD")
	public String doD(@ModelAttribute("named") String name) {
		// 본파일 보기
		System.out.println("TaDa");
		return "jjan";
	}
	
	
}
