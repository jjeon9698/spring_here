package com.kh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	@RequestMapping("/doA")
	public void doA() {
		System.out.println("doA 실행쓰 뺨");
	}
	
	@RequestMapping("/doB")
	public void doB() {
		System.out.println("doB 실행쓰 뺨");
	}
	
	@RequestMapping("/doC")
	public String doC() {
		System.out.println("doC 실행됨///");
		return "doC_view";	// WEB-INF/views/doC_view.jsp
	}
}
