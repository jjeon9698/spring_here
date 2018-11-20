package com.kh.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.domain.BoardVo;
import com.kh.domain.PagingDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private static final String NAMESPACE = "com.kh.mapper.boardMapper";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insert(BoardVo vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public BoardVo selectByBno(int bno) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectByBno", bno);
	}

	@Override
	public List<BoardVo> selectAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAll");
	}

	@Override
	public void update(BoardVo vo) throws Exception {
		sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", bno);
	}

	@Override
	public List<BoardVo> listPage(PagingDto pagingDto) throws Exception {
		List<BoardVo> list = sqlSession.selectList(NAMESPACE + ".listPage", pagingDto);
		return list;
	}

	@Override
	public int listCount(PagingDto pagingDto) throws Exception {
		int count = sqlSession.selectOne(NAMESPACE + ".listCount", pagingDto);
		return count;
	}

}
