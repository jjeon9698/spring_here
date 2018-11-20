package com.kh.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.domain.BoardVo;
import com.kh.domain.PageMaker;
import com.kh.domain.PagingDto;
import com.kh.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void registGet() {
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPost(BoardVo boardVo, RedirectAttributes rttr) throws Exception {
		boardService.regist(boardVo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		List<BoardVo> list = boardService.listAll();
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, 
					@ModelAttribute("pagingDto") PagingDto pagingDto, 
					Model model) throws Exception {
		BoardVo boardVo = boardService.read(bno);
		model.addAttribute("boardVo", boardVo);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVo boardVo, PagingDto pagingDto, RedirectAttributes rttr) throws Exception {
		boardService.modify(boardVo);
		rttr.addAttribute("bno", boardVo.getBno());
		rttr.addAttribute("page", pagingDto.getPage());
		rttr.addAttribute("perPage", pagingDto.getPerPage());
		return "redirect:/board/read";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(@RequestParam("bno") int bno, PagingDto pagingDto,
						RedirectAttributes rttr) throws Exception {
		boardService.remove(bno);
		rttr.addAttribute("page", pagingDto.getPage());
		rttr.addAttribute("perPage", pagingDto.getPerPage());
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(PagingDto pagingDto, Model model) throws Exception {
		System.out.println("BoardController, listPage, pagingDto:" + pagingDto);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPagingDto(pagingDto);
		pageMaker.setTotalCount(boardService.listCount(pagingDto)); 
		System.out.println("pageMaker:" + pageMaker);
		List<BoardVo> list = boardService.listPage(pagingDto);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
	}
}
