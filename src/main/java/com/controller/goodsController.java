package com.controller;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.service.CartService;
import com.service.GoodsService;
import com.service.MemberService;

@Controller
public class goodsController {
	@Autowired
	GoodsService goodsService;
	@Autowired
	CartService cartService;
	@Autowired
	MemberService memberService;
	
	//2번쨰 매뉴 클릿 시 화면
	
	@RequestMapping("/goodsList")
	public String goodsList (@RequestParam(value = "gCategory",
	required = false, defaultValue = "top")String gCategory,Model m) {
		List<GoodsDTO> list = goodsService.goodsList(gCategory);
		m.addAttribute("goodsList",list);
		return "main";
	
	}
	@RequestMapping("/goodsRetrieve")//GoodsRetrieve.jsp로 찾음
	@ModelAttribute("goodsRetrieve")//goodsRetrieve jsp에 보여줄 키값
	public GoodsDTO GoodsRetrieve(@RequestParam("gCode") String gCode) {
		GoodsDTO gDTO = goodsService.goodsRetrieve(gCode);
		
		return gDTO;
	}
	
	@RequestMapping ("/goodsCart")
	public String GoodsCart(CartDTO cDTO,HttpSession session,Model m,
			RedirectAttributes xx) {
  		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
  		String page="";
  		if(mDTO!=null) {
  			cDTO.setUserid(mDTO.getUserid());
  			System.out.println(cDTO);
  			int num= cartService.cartAdd(cDTO);
  			xx.addFlashAttribute("mesg", "장바구니의 담김");
  			page ="redirect:/goodsRetrieve?gCode="+cDTO.getgCode();
  		}
  		else {
  			m.addAttribute("mesg","로그인이 필요한 기능 입니다.로그인 해주세요");
  			page = "loginForm";
  		}
		return page;
	}
	
	@RequestMapping("/cartList")
	public String cartList(HttpSession session,Model m) {
		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
		String page="";
  		if(mDTO!=null) {
  			List<CartDTO> cartList = cartService.cartList(mDTO.getUserid());
  			m.addAttribute("cartList", cartList);
  			page ="cartList";
  		}
  		else {
  			m.addAttribute("mesg","로그인이 필요한 기능 입니다.로그인 해주세요");
  			page = "loginForm";
  		}
		
		return page;
		
	}
	
	@RequestMapping("/cartUpdate")
	@ResponseBody
	public void cartUpdate(@RequestParam Map<String,Integer> map) {
		cartService.cartUpdate(map);
	}
	
	@RequestMapping("/CartDelete")
	@ResponseBody
	public void CartDelete(@RequestParam ("num")int num) {
		cartService.cartDel(num);
	}	
	
	@RequestMapping("CartDelAllt2")
	public String CartDelAllt2(HttpServletRequest request) {
		String [] checks = request.getParameterValues("check");
		System.out.println(Arrays.toString(checks));
		List<String> list = Arrays.asList(checks);
		cartService.cartAllDel(list);
		return "redirect:/cartList";
	}
	
	@RequestMapping("/CartOrderConfirm")
	public ModelAndView  CartOrderConfirm(@RequestParam("num") String num,
			HttpSession session ) {
			CartDTO cDTO =cartService.cartbyNum(num);
			MemberDTO dto =(MemberDTO)session.getAttribute("login");
			String userid = dto.getUserid();
			MemberDTO mDTO  = memberService.mypage(userid);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("cDTO", cDTO);
			mav.addObject("mDTO", mDTO);
			mav.setViewName("orderConfirm");
			
			return mav;
		
	}
	@RequestMapping("/CartOrderDone")
	public String CartOrderDone(OrderDTO oDTO,HttpSession session,
			@RequestParam ("orderNum") String orderNum ) {
		System.out.println(oDTO);
		MemberDTO dto =(MemberDTO)session.getAttribute("login");
		String userid = dto.getUserid();
		oDTO.setUserid(userid);
		
		cartService.orderDone(oDTO, orderNum);
		
		return"orderDone";
		
	}
	@RequestMapping("/CartOrderAllConfirm")
	public String CartOrderAllConfirm (HttpServletRequest request,
			HttpSession session,Model m) {
		String [] checks = request.getParameterValues("check");
		//배열을 리스트로
		List<String> list = Arrays.asList(checks);
		MemberDTO dto =(MemberDTO)session.getAttribute("login");
		String userid = dto.getUserid();
		List<CartDTO> cList = cartService.orderAllConfirm(list);
		MemberDTO mDTO = memberService.mypage(userid);
		m.addAttribute("cartList",cList);
		m.addAttribute("memberDTO",mDTO);
		
		return "orderAllConfirm";
	}
	
	@RequestMapping ("/CartOrderAllDone")
	public String CartOrderAllDone (HttpServletRequest request,
			HttpSession session,Model m) {
		String [] nums = request.getParameterValues("num");
		//배열을 리스트로
		List<String> list = Arrays.asList(nums);
		List<CartDTO> cList = cartService.orderAllConfirm(list);
		
		String orderName= request.getParameter("orderName");
		String post=request.getParameter("post");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		String phone=request.getParameter("phone");
		String payMethod=request.getParameter("payMethod");
		
		List<OrderDTO> oList = new ArrayList<>();
		MemberDTO dto =(MemberDTO)session.getAttribute("login");
		String userid = dto.getUserid();
		
		for(CartDTO cDTO : cList) {
			OrderDTO oDTO = new OrderDTO();
			oDTO.setUserid(userid);
			oDTO.setNum(cDTO.getNum());
			oDTO.setgCode(cDTO.getgCode());
			oDTO.setgName(cDTO.getgName());
			oDTO.setgPrice(cDTO.getgPrice());
			oDTO.setgAmount(cDTO.getgAmount());
			oDTO.setgSize(cDTO.getgSize());
			oDTO.setgColor(cDTO.getgColor());
			oDTO.setgImage(cDTO.getgImage());
			oDTO.setOrderName(orderName);
			oDTO.setPost(post);
			oDTO.setAddr1(addr1);
			oDTO.setAddr2(addr2);
			oDTO.setPhone(phone);
			oDTO.setPayMethod(payMethod);
			System.out.println(oDTO);
			oList.add(oDTO);
		}
		int n =cartService.orderAllDone(oList, list);
		m.addAttribute("orderAllDone",oList);
		return"orderAllDone";
		
	}
}
