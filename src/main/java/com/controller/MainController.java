//ShopMiniMall �꽌釉붾┸ 踰꾩쟾�쓽 MainServlet �뿭�븷

package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.GoodsDTO;
import com.service.GoodsService;

@Controller
public class MainController {

	@Autowired
	GoodsService goodsService;
	
	@RequestMapping("/main")
	public String msain(Model m) {
		
		List<GoodsDTO> goodsList = goodsService.goodsList("outer");
		m.addAttribute("goodsList", goodsList);
		return "main";   //main.jsp
	}
}
