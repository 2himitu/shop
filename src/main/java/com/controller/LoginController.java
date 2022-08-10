package com.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/loginUI")
	public String loginUI() {
		return"loginForm";
	}
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(@RequestParam Map<String,String> map,Model m
			,HttpSession session) {
		System.out.println(map);
		MemberDTO dto = memberService.login(map);
		System.out.println(dto);
		String page = "";
		if(dto==null) {
			//실패
			m.addAttribute("mesg","아이디 또는 비번 실패");
			page= "loginForm";
		}else {
			//성공
			session.setAttribute("login",dto);
			page = "redirect:/main";
		}
		
		return page;
	}
	
	@RequestMapping ("/logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	@RequestMapping ("/MemberIdSearchUI")
	public String MemberIdSearchUI () {
		return"idSearch";
	}
	@RequestMapping("/MemberIdSearch")
	public String MemberIdSearch(
			HttpServletRequest request,
			HttpServletResponse response)
	{
		 
		String username = request.getParameter("username").trim();
		 String phone1 = request.getParameter("phone1").trim();
		 String phone2 = request.getParameter("phone2").trim();
		 String phone3 = request.getParameter("phone3").trim();
		 String email1 = request.getParameter("email1").trim();
		 String email2 = request.getParameter("email2").trim();
		 
		 MemberDTO dto = new MemberDTO();
		 dto.setUsername(username);
		 dto.setPhone1(phone1);
		 dto.setPhone2(phone2);
		 dto.setPhone3(phone3);
		
		 String userid = "aa";//memberService.idSearch(dto);
		 String Page = null;
			 if(userid==null) {
				 Page="idSearch";
				 request.setAttribute("mesg", "이름 또는 핸드폰이 등록되지 않은 정보");
			 }else {
				 Page="redirect:sendMail";
				 request.setAttribute("mailTo", email1+"@"+email2);
				 request.setAttribute("userid", userid);
				 
				 //메일기능 서블리 요창
				
			 }
			 return Page;
			 
		}
}
