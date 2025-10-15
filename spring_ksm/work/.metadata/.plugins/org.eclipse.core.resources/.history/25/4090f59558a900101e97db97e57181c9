package com.kh.pro;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CartDAO;
import vo.CartVO;
@Controller
public class CartController {
	
	CartDAO cart_dao;
	public void setCart_dao(CartDAO cart_dao) {
		this.cart_dao = cart_dao;
	}
	
	//장바구니 보기
	@RequestMapping("/cart_list.do")
	public String cartList(int m_idx, Model model) {
	
		List<CartVO> list = cart_dao.select(m_idx);
		
		int total = cart_dao.selectTotalAmount(m_idx);
		
		model.addAttribute("list", list);
		model.addAttribute("total", total);
		
		return "/cart/cartList";
		
	}
	
	//장바구니 담기
	@RequestMapping("cart_insert.do")
	@ResponseBody
	public String addcart(CartVO vo) {
		
		CartVO resVo = cart_dao.selectOne(vo);
		
		String result = "no";
		
		if(resVo == null) {
			result = "yes";
			//상품을 장바구니에 등록
			cart_dao.insert(vo);
		}
		
		String resStr = String.format("[{'result':'%s'}]", result);
		
		return resStr;
	}
	
	//장바구니 삭제
	@RequestMapping("cart_delete.do")
	public String deleteCart(int c_idx, Model model) {
		
		cart_dao.delete(c_idx);
		
		List<CartVO> list = cart_dao.select(1);
		
		int total_amount = cart_dao.selectTotalAmount(1);
		
		model.addAttribute("list", list);
		model.addAttribute("total", total_amount);
		
		return "/cart/cartList";
	}
	
	//장바구니 수정
	@RequestMapping("cart_update.do")
	public String update(CartVO vo, Model model) {
		
		cart_dao.update_cnt( vo );
		
		//현재 접속한 회원의 장바구니 목록 조회 1 = 회원번호
		List<CartVO> list = cart_dao.select(1);
		
		// 장바구니 총계
		int total_amount = cart_dao.selectTotalAmount(1);
		
		model.addAttribute("list", list);
		model.addAttribute("total", total_amount);
		
		return "/cart/cartList";
	}
	
}
