package com.kh.service;

import java.util.List;

import com.kh.domain.BoardVo;

public interface BoardService {
	public void regist(BoardVo boardVo) throws Exception;
	public BoardVo read(int bno) throws Exception;
	public List<BoardVo> listAll() throws Exception;
	public void modify(BoardVo boardVo) throws Exception;
	public void delete(int bno, String password) throws Exception;
}
