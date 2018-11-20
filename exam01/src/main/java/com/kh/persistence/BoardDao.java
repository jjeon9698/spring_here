package com.kh.persistence;

import java.util.List;

import com.kh.domain.BoardVo;
import com.kh.domain.PagingDto;

public interface BoardDao {
	public void insert(BoardVo vo) throws Exception;
	public BoardVo selectByBno(int bno) throws Exception;
	public List<BoardVo> selectAll() throws Exception;
	public void update(BoardVo vo) throws Exception;
	public void delete(int bno) throws Exception;
	public List<BoardVo> listPage(PagingDto pagingDto) throws Exception;
	public int listCount(PagingDto pagingDto) throws Exception;
}
