package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("memberUI")
	public String memberUI () {
		return "memberForm";
	}
	
	@RequestMapping(value = "/idCheck",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	//스트링을 뷰로 하지 않게 하는 것(데이터 문자열,ArrayList,TO 등등)으로 처리  @ResponseBody
	public String idCheck(@RequestParam("id") String userid,
			@RequestParam ("pw") String pw) {
		int n =memberService.idCheck(userid);
		
		String masg = "success 성공";
		if (n==1) {
			masg ="fail 실패";
		}
		System.out.println(userid);
		return masg;
		//'main'을 문자열로 받아 처리 하여 응답==>전체 화면이 아닌 일부분에 화면만 얻기위해서 
	}
	@RequestMapping(value = "/memberAdd",method =RequestMethod.GET )
	public String memberAdd(MemberDTO dto,Model m) {
		System.out.println(dto);
		int n = memberService.memberAdd(dto);
		if(n==1) {
			m.addAttribute("mesg", "회원가입성공");
		}else {
			m.addAttribute("mesg", "회원가입실패");		}
		return "forward:/main";
	}
	@RequestMapping("/mypage")
	public String mypage(HttpSession session) {
		//로그인 된 키 값이 session에  로그인키로 디티오가 저장 되어 있음
		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
		//userid에 해당하는 회원 정보를 DB에서 가져와서 저장
		MemberDTO dto = memberService.mypage(mDTO.getUserid());
		session.setAttribute("login", dto);
		return"mypage";
	}
	
}
