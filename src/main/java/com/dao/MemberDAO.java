package com.dao;

import java.util.Map;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.MemberDTO;


@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate session;
	

	public MemberDTO login(Map<String, String> map) {
		MemberDTO n = session.selectOne("MemberMapper.login", map);
		return n;
	}
	public int idCheck (String userid) {
		int count =session.selectOne("MemberMapper.idCheck",userid);
		return count;
	}
	
	public int memberAdd(MemberDTO dto) {
		   int n = session.insert("MemberMapper.memberAdd", dto);
		   //인설트 된 겟수를 알려줌
		   return n;
	   }
	public MemberDTO mypage(String userid) {
		   MemberDTO n = session.selectOne("MemberMapper.mypage", userid);
		   return n;
	   }
	public String idSearch(
			MemberDTO dto) {
		String userid = session.selectOne("MemberMapper.idSearch",dto);
		return userid;
	}
}

	
