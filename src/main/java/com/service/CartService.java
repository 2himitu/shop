package com.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CartDAO;
import com.dto.CartDTO;
import com.dto.OrderDTO;
@Service
public class CartService {
	
	@Autowired
	CartDAO dao;
	
	public int cartAdd(CartDTO dto) {
		int n =dao.cartAdd(dto);
		return n;
	}// end cartAdd
	
	public List<CartDTO> cartList(String userid) {
		List<CartDTO> list = dao.cartList(userid);
		return list;
	}
	public int cartUpdate(Map<String, Integer> map) {
		int n = dao.cartUpdate(map);
		return n;
	}
	
	public int cartDel(int num) {
		int n =dao.cartDel(num);
		return n;
	}
	public int cartAllDel(List<String> list) {
		int n = dao.cartAllDel(list);
		return n;
	}
	 public CartDTO cartbyNum(String num) {
		CartDTO dto = dao.cartbyNum(num);	
		return dto;
		}
	 
		public int orderDone(OrderDTO dto,String orderNum) {
			int n =  dao.orderDone(dto);
			n= dao.cartDel( Integer.parseInt(orderNum));
				
			return n;
		}
		
		 public List<CartDTO> orderAllConfirm(List<String> x) {
				List<CartDTO> list =null;
				list= dao.orderAllConfirm(x);
				return list;
			}
		 
		 public int orderAllDone(List<OrderDTO> x,List<String> nums) {
				
				int n = dao.orderAllDone( x);
					n= dao.cartAllDel(nums);
				return n;
			}
}// end class
