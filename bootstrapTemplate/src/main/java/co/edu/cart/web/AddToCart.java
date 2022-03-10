package co.edu.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.cart.vo.CartService;
import co.edu.cart.vo.CartServiceImpl;
import co.edu.cart.vo.CartVO;
import co.edu.common.DbCommand;

public class AddToCart implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 장바구니에 상품 추가
		CartService cartDAO = new CartServiceImpl();
		CartVO vo = new CartVO();

		vo.setId(request.getParameter("id"));
		vo.setPno(Integer.parseInt(request.getParameter("pno")));
		vo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		vo.setAmount(Integer.parseInt(request.getParameter("amount")));

		int n = cartDAO.insertCart(vo);
		
		if (n != 0) {
			return "cartList.do";
		} else {
			return "product/productDetail.tiles";
		}
	}

}
