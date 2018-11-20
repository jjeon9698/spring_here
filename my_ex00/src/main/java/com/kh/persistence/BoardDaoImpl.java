package com.kh.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.domain.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {

	private static final String NAMESPACE = "com.kh.mappers.boardMapper"; 
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insert(BoardVo boardVo) throws Exception {
		sqlSession.insert(NAMESPACE + ".insert", boardVo);
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
	public void modify(BoardVo boardVo) throws Exception {
		sqlSession.update(NAMESPACE + ".update", boardVo);
	}

	@Override
	public void delete(int bno, String password) throws Exception {
		Map<String, Object> vMap = new HashMap<>();
		vMap.put("bno", bno);
		vMap.put("password", password);
		sqlSession.delete(NAMESPACE + ".delete", vMap);
	}

}
