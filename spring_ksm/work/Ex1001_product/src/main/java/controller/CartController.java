package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.CartDAO;
import vo.CartVO;

@Controller
public class CartController {
	
	CartDAO cart_dao;
	
	public CartController(CartDAO cart_dao) {
		this.cart_dao = cart_dao;
	}
	
	@RequestMapping("/cart_list.do")
	public String cartList(Model model, int m_idx) {
		
		List<CartVO> list = cart_dao.select(m_idx);
		int total = cart_dao.selectTotalAmount(m_idx);
		
		model.addAttribute("list", list);
		model.addAttribute("total", total);

		return "/cart/cartList.jsp";
		
	}
	
	@RequestMapping("/cart_insert.do")
	public String cartInsert(int idx, int m_idx) {
		
		CartVO vo = new CartVO();
		vo.setIdx(idx);
		vo.setM_idx(m_idx);
		
		CartVO resVo = cart_dao.selectOne(vo);
		
		String result = "no";
		
		if(resVo == null) {
			result = "yes";
			//상품을 장바구니에 등록
			cart_dao.insert(vo);
		}
		
		return null;
		
	}
}


























