package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController4 {
	
	@RequestMapping("/doF")
	public String doF() {
		System.out.println("doF 고고");
		return "redirect:doG";
	}
	
	@RequestMapping("/doG")
	public String doG() {
		System.out.println("doG 고고");
		return "doG";
	}
}
