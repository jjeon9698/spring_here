package com.kh.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.domain.BoardVo;
import com.kh.domain.PagingDto;
import com.kh.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDao boardDao;

	@Override
	public void regist(BoardVo vo) throws Exception {
		boardDao.insert(vo);
	}

	@Override
	public BoardVo read(int bno) throws Exception {
		BoardVo boardVo = boardDao.selectByBno(bno);
		return boardVo;
	}

	@Override
	public List<BoardVo> listAll() throws Exception {
		List<BoardVo> list = boardDao.selectAll();
		return list;
	}

	@Override
	public void modify(BoardVo vo) throws Exception {
		boardDao.update(vo);
	}

	@Override
	public void remove(int bno) throws Exception {
		boardDao.delete(bno);
	}

	@Override
	public List<BoardVo> listPage(PagingDto pagingDto) throws Exception {
		List<BoardVo> list = boardDao.listPage(pagingDto);
		return list;
	}

	@Override
	public int listCount(PagingDto pagingDto) throws Exception {
		int count = boardDao.listCount(pagingDto);
		return count;
	}

}
