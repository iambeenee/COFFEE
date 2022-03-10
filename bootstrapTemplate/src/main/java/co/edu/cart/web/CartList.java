package co.edu.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.cart.vo.CartService;
import co.edu.cart.vo.CartServiceImpl;
import co.edu.common.DbCommand;

public class CartList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 장바구니 리스트

		CartService service = new CartServiceImpl();

		request.setAttribute("cartList", service.selectCartList());

		return "cart/cartList.tiles";
	}

}
