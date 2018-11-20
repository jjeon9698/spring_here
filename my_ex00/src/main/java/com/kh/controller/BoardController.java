package com.kh.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.domain.BoardVo;
import com.kh.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void registGet() {
		System.out.println("registGet 실행~!");
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registRedirect(BoardVo boardVo, RedirectAttributes rttr) throws Exception {
		System.out.println("registPost() 실행됨!");
		System.out.println("boardVo : " + boardVo);
		boardService.regist(boardVo);
		rttr.addFlashAttribute("result", "success");
		
		return "redirect:/board/listAll";
	}
	
	// 글 목록
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		System.out.println("listAll() 실행됨");
		
		List<BoardVo> list = boardService.listAll();
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardVo boardVo = boardService.read(bno);
		model.addAttribute("boardVo", boardVo);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("bno") int bno, @RequestParam("password") String password) throws Exception {
		boardService.delete(bno, password);
		System.out.println("삭제 서비스 실행");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVo boardVo) throws Exception {
		System.out.println("수정 서비스 실행");
		boardService.modify(boardVo);
		return "redirect:/board/read?bno=" + boardVo.getBno();
	}
}
