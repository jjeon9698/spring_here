package com.kh.service;

import java.util.List;

import com.kh.domain.BoardVo;
import com.kh.domain.PagingDto;

public interface BoardService {
	public void regist(BoardVo vo) throws Exception;
	public BoardVo read(int bno) throws Exception;
	public List<BoardVo> listAll() throws Exception;
	public void modify(BoardVo vo) throws Exception;
	public void remove(int bno) throws Exception;
	public List<BoardVo> listPage(PagingDto pagingDto) throws Exception;
	public int listCount(PagingDto pagingDto) throws Exception;
}
