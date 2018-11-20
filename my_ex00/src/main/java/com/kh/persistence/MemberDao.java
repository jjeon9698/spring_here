package com.kh.persistence;

import com.kh.domain.MemberVo;

public interface MemberDao {
	public String getTime();
	public void insertMember(MemberVo memberVo);
	public MemberVo selectMember(String userid);
	public MemberVo readWithPw(String userid, String userpw);
}
