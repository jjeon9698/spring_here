package com.kh.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.domain.MemberVo;
import com.kh.persistence.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDaoTest {
	
	@Inject
	private MemberDao memberDao;
	
	@Test
	public void testGetTime() throws Exception {
		String time = memberDao.getTime();
		System.out.println(time);
	}
	
	@Test
	public void testInsertMember() throws Exception {
		MemberVo vo = new MemberVo();
		vo.setUserid("cho");
		vo.setUserpw("0000");
		vo.setUsername("조요한");
		vo.setEmail("chothe@google");
		memberDao.insertMember(vo);
	}
	
	@Test
	public void testSelectMember() throws Exception {
		String userid= "ho";
		memberDao.selectMember(userid);
	}
	
	@Test
	public void testReadWithPw() throws Exception {
		memberDao.readWithPw("cho", "0000");
	}
}
