package com.kh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.domain.ProductVo;

@Controller
public class SampleController5 {
	
	@RequestMapping("/doJSON")
	public @ResponseBody List<ProductVo> doJSON() {
		List<ProductVo> list = new ArrayList<>();
		
		for (int i = 0; i<10; i++) {
			ProductVo vo = new ProductVo("청바지" + i, 25000 + i);
			list.add(vo);
		}
		
		return list;
	}
	
}
