package com.kh.persistence;

import java.util.List;

import com.kh.domain.BoardVo;

public interface BoardDao {
	public void insert(BoardVo boardVo) throws Exception;
	public BoardVo selectByBno(int bno) throws Exception;
	public List<BoardVo> selectAll() throws Exception;
	public void modify(BoardVo boardVo) throws Exception;
	public void delete(int bno, String password) throws Exception;
	
}
