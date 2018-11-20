package com.kh.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.domain.BoardVo;
import com.kh.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDao boardDao;
	
	@Override
	public void regist(BoardVo boardVo) throws Exception {
		boardDao.insert(boardVo);
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
	public void modify(BoardVo boardVo) throws Exception {
		boardDao.modify(boardVo);
	}

	@Override
	public void delete(int bno, String password) throws Exception {
		boardDao.delete(bno, password);
	}

	

}
