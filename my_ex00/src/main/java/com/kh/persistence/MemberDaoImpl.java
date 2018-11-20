package com.kh.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.domain.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	private static final String NAMESPACE = "com.kh.mappers.memberMapper"; 
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public String getTime() {
		
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}

	@Override
	public void insertMember(MemberVo memberVo) {
		sqlSession.insert(NAMESPACE + ".insertMember", memberVo );
	}

	@Override
	public MemberVo selectMember(String userid) {
		return sqlSession.selectOne(NAMESPACE + ".selectMember", userid);
	}

	@Override
	public MemberVo readWithPw(String userid, String userpw) {
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("userid", userid);
		paraMap.put("userpw", userpw);
		return sqlSession.selectOne(NAMESPACE + ".readWithPw", paraMap);
	}
	
	

}
