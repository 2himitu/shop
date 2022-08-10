package com.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	MemberDAO dao;
	

	public int idCheck(String userid) {
			int count = dao.idCheck(userid);
			return count;
		}//end idCheck
	public int memberAdd(MemberDTO dto) {
		  int n =dao.memberAdd(dto);
		 
		  return n;
		  }
	public MemberDTO login(Map<String, String> map) {
	 MemberDTO dto =dao.login(map);
		return dto;
	}
	 public MemberDTO mypage(String userid) {
	 MemberDTO dto =dao.mypage(userid);
	 return dto;	
	}
	 public String idSearch(MemberDTO dto) {
			String userid = dao.idSearch(dto);
			return userid;
		}
}//end class
