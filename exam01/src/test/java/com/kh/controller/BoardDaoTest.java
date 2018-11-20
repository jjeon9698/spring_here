package com.kh.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.domain.BoardVo;
import com.kh.persistence.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDaoTest {
	
	@Inject
	private BoardDao boardDao;
	
	@Test
	public void testInsert() throws Exception {
		BoardVo vo = new BoardVo();
		vo.setTitle("나리나리 개나리");
		vo.setContent("입에 따다 물고요");
		vo.setWriter("뼝");
		
		boardDao.insert(vo);
	}
}
