package com.kh.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.domain.BoardVo;
import com.kh.persistence.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDaoTest {
	
	@Inject
	private BoardDao boardDao;
	
	@Test
	public void testInsert() throws Exception {
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle("빠바바바");
		boardVo.setContent("도로로로록");
		boardVo.setPassword("0000");
		boardVo.setWriter("java");
		
		boardDao.insert(boardVo);
	}
	
	@Test
	public void testSelectByBno() throws Exception {
		// 테스트는 다른곳에 결과값을 받지 않는다!!!! void임!!!!
		boardDao.selectByBno(2);	
	}
	
	@Test
	public void testSelectAll() throws Exception {
		boardDao.selectAll();
	}
	
	@Test
	public void testModify() throws Exception {
		BoardVo boardVo = new BoardVo();
		boardVo.setBno(1);
		boardVo.setTitle("햄 드 위치");;
		boardVo.setContent("진짜 맛있어요!!! 에그 샌드위치 짱!");
		boardVo.setPassword("0123");
		boardVo.setWriter("퐉주임");
		
		boardDao.modify(boardVo);
	}
	
	@Test
	public void testDelete() throws Exception {
		boardDao.delete(3, "0000");
	}
}
